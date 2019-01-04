/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.master.file;

import alluxio.AlluxioURI;
import alluxio.Constants;
import alluxio.RpcUtils;
import alluxio.RpcUtils.RpcCallable;
import alluxio.RpcUtils.RpcCallableThrowsIOException;
import alluxio.exception.AlluxioException;
import alluxio.exception.status.AlluxioStatusException;
import alluxio.master.file.options.CheckConsistencyOptions;
import alluxio.master.file.options.CompleteFileOptions;
import alluxio.master.file.options.CreateDirectoryOptions;
import alluxio.master.file.options.CreateFileOptions;
import alluxio.master.file.options.DeleteOptions;
import alluxio.master.file.options.DescendantType;
import alluxio.master.file.options.FreeOptions;
import alluxio.master.file.options.GetStatusOptions;
import alluxio.master.file.options.ListStatusOptions;
import alluxio.master.file.options.LoadMetadataOptions;
import alluxio.master.file.options.MountOptions;
import alluxio.master.file.options.RenameOptions;
import alluxio.master.file.options.SetAttributeOptions;
import alluxio.master.game.GameSystemMaster;
import alluxio.thrift.*;
import alluxio.underfs.UnderFileSystem;
import alluxio.wire.MountPointInfo;

import com.google.common.base.Preconditions;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * This class is a Thrift handler for file system master RPCs invoked by an Alluxio client.
 */
@NotThreadSafe // TODO(jiri): make thread-safe (c.f. ALLUXIO-1664)
public final class FileSystemMasterClientServiceHandler implements
    FileSystemMasterClientService.Iface{
  private static final Logger LOG =
      LoggerFactory.getLogger(FileSystemMasterClientServiceHandler.class);
  private final FileSystemMaster mFileSystemMaster;

  /**
   * Creates a new instance of {@link FileSystemMasterClientServiceHandler}.
   *
   * @param fileSystemMaster the {@link FileSystemMaster} the handler uses internally
   */
  FileSystemMasterClientServiceHandler(FileSystemMaster fileSystemMaster) {
    Preconditions.checkNotNull(fileSystemMaster, "fileSystemMaster");
    mFileSystemMaster = fileSystemMaster;
  }

  @Override
  public GetServiceVersionTResponse getServiceVersion(GetServiceVersionTOptions options) {
    return new GetServiceVersionTResponse(Constants.FILE_SYSTEM_MASTER_CLIENT_SERVICE_VERSION);
  }

  @Override
  public CheckConsistencyTResponse checkConsistency(final String path,
      final CheckConsistencyTOptions options) throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<CheckConsistencyTResponse>() {
      @Override
      public CheckConsistencyTResponse call() throws AlluxioException, IOException {
        List<AlluxioURI> inconsistentUris = mFileSystemMaster.checkConsistency(
            new AlluxioURI(path), new CheckConsistencyOptions(options));
        List<String> uris = new ArrayList<>(inconsistentUris.size());
        for (AlluxioURI uri : inconsistentUris) {
          uris.add(uri.getPath());
        }
        return new CheckConsistencyTResponse(uris);
      }

      @Override
      public String toString() {
        return String.format("CheckConsistency: path=%s, options=%s", path, options);
      }
    });
  }

  @Override
  public CompleteFileTResponse completeFile(final String path, final CompleteFileTOptions options)
      throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<CompleteFileTResponse>() {
      @Override
      public CompleteFileTResponse call() throws AlluxioException, AlluxioStatusException {
        mFileSystemMaster.completeFile(new AlluxioURI(path), new CompleteFileOptions(options));
        return new CompleteFileTResponse();
      }

      @Override
      public String toString() {
        return String.format("CompleteFile: path=%s, options=%s", path, options);
      }
    });
  }

  @Override
  public CreateDirectoryTResponse createDirectory(final String path,
      final CreateDirectoryTOptions options) throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<CreateDirectoryTResponse>() {
      @Override
      public CreateDirectoryTResponse call() throws AlluxioException, IOException {
        mFileSystemMaster.createDirectory(new AlluxioURI(path),
            new CreateDirectoryOptions(options));
        return new CreateDirectoryTResponse();
      }

      @Override
      public String toString() {
        return String.format("CreateDirectory: path=%s, options=%s", path, options);
      }
    });
  }

  @Override
  public CreateFileTResponse createFile(final String path, final CreateFileTOptions options)
      throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<CreateFileTResponse>() {
      @Override
      public CreateFileTResponse call() throws AlluxioException, IOException {
        mFileSystemMaster.createFile(new AlluxioURI(path), new CreateFileOptions(options));
        //GameSystemMaster.addfile(path);
        return new CreateFileTResponse();
      }

      @Override
      public String toString() {
        return String.format("CreateFile: path=%s, options=%s", path, options);
      }
    });
  }

  @Override
  public FreeTResponse free(final String path, final boolean recursive, final FreeTOptions options)
      throws AlluxioTException {
    //GameSystemMaster.changeFileMode(path,false);
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<FreeTResponse>() {
      @Override
      public FreeTResponse call() throws AlluxioException, IOException {
        if (options == null) {
          // For Alluxio client v1.4 or earlier.
          // NOTE, we try to be conservative here so early Alluxio clients will not be able to force
          // freeing pinned items but see the error thrown.
          mFileSystemMaster.free(new AlluxioURI(path),
              FreeOptions.defaults().setRecursive(recursive));
        } else {
          mFileSystemMaster.free(new AlluxioURI(path), new FreeOptions(options));
        }
        return new FreeTResponse();
      }

      @Override
      public String toString() {
        return String.format("Free: path=%s, recursive=%s, options=%s", path, recursive, options);
      }
    });
  }

  @Override
  public GetNewBlockIdForFileTResponse getNewBlockIdForFile(final String path,
      final GetNewBlockIdForFileTOptions options) throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallable<GetNewBlockIdForFileTResponse>() {
      @Override
      public GetNewBlockIdForFileTResponse call() throws AlluxioException {
        return new GetNewBlockIdForFileTResponse(
            mFileSystemMaster.getNewBlockIdForFile(new AlluxioURI(path)));
      }

      @Override
      public String toString() {
        return String.format("GetNewBlockIdForFile: path=%s, options=%s", path, options);
      }
    });
  }

  @Override
  public GetStatusTResponse getStatus(final String path, final GetStatusTOptions options)
      throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<GetStatusTResponse>() {
      @Override
      public GetStatusTResponse call() throws AlluxioException, IOException {
        return new GetStatusTResponse(mFileSystemMaster
            .getFileInfo(new AlluxioURI(path), new GetStatusOptions(options)).toThrift());
      }

      @Override
      public String toString() {
        return String.format("GetStatus: path=%s, options=%s", path, options);
      }
      // getStatus is often used to check file existence, so we avoid logging all of its failures
    }, false);
  }

  @Override
  public ListStatusTResponse listStatus(final String path, final ListStatusTOptions options)
      throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<ListStatusTResponse>() {
      @Override
      public ListStatusTResponse call() throws AlluxioException, IOException {
        List<FileInfo> result = new ArrayList<>();
        for (alluxio.wire.FileInfo fileInfo : mFileSystemMaster
            .listStatus(new AlluxioURI(path), new ListStatusOptions(options))) {
          result.add(fileInfo.toThrift());
        }
        return new ListStatusTResponse(result);
      }

      @Override
      public String toString() {
        return String.format("ListStatus: path=%s, options=%s", path, options);
      }
    });
  }

  /**
   * {@inheritDoc}
   *
   * @deprecated since version 1.1 and will be removed in version 2.0
   */
  @Override
  @Deprecated
  public LoadMetadataTResponse loadMetadata(final String alluxioPath, final boolean recursive,
      final LoadMetadataTOptions options)
      throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<LoadMetadataTResponse>() {
      @Override
      public LoadMetadataTResponse call() throws AlluxioException, IOException {
        return new LoadMetadataTResponse(mFileSystemMaster.loadMetadata(new AlluxioURI(alluxioPath),
            LoadMetadataOptions.defaults().setCreateAncestors(true).setLoadDescendantType(
                DescendantType.ONE)));
      }

      @Override
      public String toString() {
        return String.format("LoadMetadata: alluxioPath=%s, recursive=%s, options=%s", alluxioPath,
            recursive, options);
      }
    });
  }

  @Override
  public MountTResponse mount(final String alluxioPath, final String ufsPath,
      final MountTOptions options) throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<MountTResponse>() {
      @Override
      public MountTResponse call() throws AlluxioException, IOException {
        mFileSystemMaster.mount(new AlluxioURI(alluxioPath), new AlluxioURI(ufsPath),
            new MountOptions(options));
        return new MountTResponse();
      }

      @Override
      public String toString() {
        return String.format("Mount: alluxioPath=%s, ufsPath=%s, options=%s", alluxioPath, ufsPath,
            options);
      }
    });
  }

  @Override
  public GetMountTableTResponse getMountTable() throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<GetMountTableTResponse>() {
      @Override
      public GetMountTableTResponse call() throws AlluxioException, IOException {
        Map<String, MountPointInfo> mountTableWire = mFileSystemMaster.getMountTable();
        Map<String, alluxio.thrift.MountPointInfo> mountTableThrift = new HashMap<>();
        for (Map.Entry<String, MountPointInfo> entry :
                mountTableWire.entrySet()) {
          MountPointInfo mMountPointInfo = entry.getValue();
          alluxio.thrift.MountPointInfo mountPointThrift = mMountPointInfo.toThrift();
          mountTableThrift.put(entry.getKey(), mountPointThrift);
        }
        return new GetMountTableTResponse(mountTableThrift);
      }

      @Override
      public String toString() {
        return String.format("GetMountTable: ");
      }
    });
  }

  @Override
  public DeleteTResponse remove(final String path, final boolean recursive,
      final DeleteTOptions options) throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<DeleteTResponse>() {
      @Override
      public DeleteTResponse call() throws AlluxioException, IOException {
        if (options == null) {
          // For Alluxio client v1.4 or earlier.
          // NOTE, we try to be conservative here so early Alluxio clients will not be able to
          // delete files in Alluxio only.
          mFileSystemMaster.delete(new AlluxioURI(path), DeleteOptions.defaults()
              .setRecursive(recursive).setUnchecked(options.isUnchecked()));
        } else {
          mFileSystemMaster.delete(new AlluxioURI(path), new DeleteOptions(options));
        }
        return new DeleteTResponse();
      }

      @Override
      public String toString() {
        return String.format("Remove: path=%s, recursive=%s, options=%s", path, recursive, options);
      }
    });
  }

  @Override
  public RegisterUserTResponse registerUser(String userId, String hostname, ClientNetAddress address, RegisterUserTOptions options) throws AlluxioTException, TException {
      return RpcUtils.call(LOG, new RpcUtils.RpcCallableThrowsIOException<RegisterUserTResponse>() {
        @Override
        public RegisterUserTResponse call() throws AlluxioException, AlluxioStatusException {

          GameSystemMaster.register(userId,hostname,address,options);
          return new RegisterUserTResponse();
        }

        @Override
        public String toString() {
          return String
                  .format("registerUser: userId=%s, address=%s, options=%s", userId, address, options);
        }
      });
  }

  @Override
  public RenameTResponse rename(final String srcPath, final String dstPath,
      final RenameTOptions options) throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<RenameTResponse>() {
      @Override
      public RenameTResponse call() throws AlluxioException, IOException {
        mFileSystemMaster
            .rename(new AlluxioURI(srcPath), new AlluxioURI(dstPath), new RenameOptions(options));
        return new RenameTResponse();
      }

      @Override
      public String toString() {
        return String
            .format("Rename: srcPath=%s, dstPath=%s, options=%s", srcPath, dstPath, options);
      }
    });
  }

  @Override
  public ScheduleAsyncPersistenceTResponse scheduleAsyncPersistence(final String path,
      final ScheduleAsyncPersistenceTOptions options) throws AlluxioTException {
    return RpcUtils.call(LOG,
        new RpcCallableThrowsIOException<ScheduleAsyncPersistenceTResponse>() {
          @Override
          public ScheduleAsyncPersistenceTResponse call() throws AlluxioException, IOException {
            mFileSystemMaster.scheduleAsyncPersistence(new AlluxioURI(path));
            return new ScheduleAsyncPersistenceTResponse();
          }

          @Override
          public String toString() {
            return String.format("ScheduleAsyncPersist: path=%s, options=%s", path, options);
          }
        });
  }

  @Override
  public SetAttributeTResponse setAttribute(final String path, final SetAttributeTOptions options)
      throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<SetAttributeTResponse>() {
      @Override
      public SetAttributeTResponse call() throws AlluxioException, IOException {
        mFileSystemMaster.setAttribute(new AlluxioURI(path), new SetAttributeOptions(options));
        return new SetAttributeTResponse();
      }

      @Override
      public String toString() {
        return String.format("SetAttribute: path=%s, options=%s", path, options);
      }
    });
  }

  @Override
  public UnmountTResponse unmount(final String alluxioPath, final UnmountTOptions options)
      throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<UnmountTResponse>() {
      @Override
      public UnmountTResponse call() throws AlluxioException, IOException {
        mFileSystemMaster.unmount(new AlluxioURI(alluxioPath));
        return new UnmountTResponse();
      }

      @Override
      public String toString() {
        return String.format("Unmount: alluxioPath=%s, options=%s", alluxioPath, options);
      }
    });
  }

  @Override
  public UpdateUfsModeTResponse updateUfsMode(final String ufsPath,
      final UpdateUfsModeTOptions options) throws AlluxioTException {
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<UpdateUfsModeTResponse>() {
      @Override
      public UpdateUfsModeTResponse call() throws AlluxioException, IOException {
        UnderFileSystem.UfsMode ufsMode;
        switch (options.getUfsMode()) {
          case NoAccess:
            ufsMode = UnderFileSystem.UfsMode.NO_ACCESS;
            break;
          case ReadOnly:
            ufsMode = UnderFileSystem.UfsMode.READ_ONLY;
            break;
          default:
            ufsMode = UnderFileSystem.UfsMode.READ_WRITE;
            break;
        }
        mFileSystemMaster.updateUfsMode(new AlluxioURI(ufsPath), ufsMode);
        return new UpdateUfsModeTResponse();
      }

      @Override
      public String toString() {
        return String.format("UpdateUfsMode: ufsPath=%s, options=%s", ufsPath, options);
      }
    });
  }

  @Override
  public RunGameTResponse runGame(final int fileNumber, final int quota)throws AlluxioTException{
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<RunGameTResponse>() {
      @Override
      public RunGameTResponse call() throws AlluxioException, IOException {
        mFileSystemMaster.runGame(fileNumber, quota);
        return new RunGameTResponse();
      }

      @Override
      public String toString() {
        return String.format("RunGame: file number=%s, quota=%s", fileNumber, quota);
      }
    });
  }

  @Override
  public UpdatePrefCompTResponse updatePrefComp(final int fileNumber, final int quota, final int updateNum, final int loopNum)throws AlluxioTException{
    return RpcUtils.call(LOG, new RpcCallableThrowsIOException<UpdatePrefCompTResponse>() {
      @Override
      public UpdatePrefCompTResponse call() throws AlluxioException, IOException {
        mFileSystemMaster.updatePrefComp(fileNumber, quota, updateNum,loopNum);
        return new UpdatePrefCompTResponse();
      }

      @Override
      public String toString() {
        return String.format("UpdatePrefComp: file number=%s, quota=%s", fileNumber, quota, updateNum, loopNum);
      }
    });
  }
}
