/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package alluxio.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-07-30")
public class PersistCommandOptions implements org.apache.thrift.TBase<PersistCommandOptions, PersistCommandOptions._Fields>, java.io.Serializable, Cloneable, Comparable<PersistCommandOptions> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PersistCommandOptions");

  private static final org.apache.thrift.protocol.TField PERSIST_FILES_FIELD_DESC = new org.apache.thrift.protocol.TField("persistFiles", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PersistCommandOptionsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PersistCommandOptionsTupleSchemeFactory());
  }

  public List<PersistFile> persistFiles; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PERSIST_FILES((short)1, "persistFiles");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PERSIST_FILES
          return PERSIST_FILES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PERSIST_FILES, new org.apache.thrift.meta_data.FieldMetaData("persistFiles", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "PersistFile"))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PersistCommandOptions.class, metaDataMap);
  }

  public PersistCommandOptions() {
  }

  public PersistCommandOptions(
    List<PersistFile> persistFiles)
  {
    this();
    this.persistFiles = persistFiles;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PersistCommandOptions(PersistCommandOptions other) {
    if (other.isSetPersistFiles()) {
      List<PersistFile> __this__persistFiles = new ArrayList<PersistFile>(other.persistFiles.size());
      for (PersistFile other_element : other.persistFiles) {
        __this__persistFiles.add(other_element);
      }
      this.persistFiles = __this__persistFiles;
    }
  }

  public PersistCommandOptions deepCopy() {
    return new PersistCommandOptions(this);
  }

  @Override
  public void clear() {
    this.persistFiles = null;
  }

  public int getPersistFilesSize() {
    return (this.persistFiles == null) ? 0 : this.persistFiles.size();
  }

  public java.util.Iterator<PersistFile> getPersistFilesIterator() {
    return (this.persistFiles == null) ? null : this.persistFiles.iterator();
  }

  public void addToPersistFiles(PersistFile elem) {
    if (this.persistFiles == null) {
      this.persistFiles = new ArrayList<PersistFile>();
    }
    this.persistFiles.add(elem);
  }

  public List<PersistFile> getPersistFiles() {
    return this.persistFiles;
  }

  public PersistCommandOptions setPersistFiles(List<PersistFile> persistFiles) {
    this.persistFiles = persistFiles;
    return this;
  }

  public void unsetPersistFiles() {
    this.persistFiles = null;
  }

  /** Returns true if field persistFiles is set (has been assigned a value) and false otherwise */
  public boolean isSetPersistFiles() {
    return this.persistFiles != null;
  }

  public void setPersistFilesIsSet(boolean value) {
    if (!value) {
      this.persistFiles = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PERSIST_FILES:
      if (value == null) {
        unsetPersistFiles();
      } else {
        setPersistFiles((List<PersistFile>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PERSIST_FILES:
      return getPersistFiles();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PERSIST_FILES:
      return isSetPersistFiles();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PersistCommandOptions)
      return this.equals((PersistCommandOptions)that);
    return false;
  }

  public boolean equals(PersistCommandOptions that) {
    if (that == null)
      return false;

    boolean this_present_persistFiles = true && this.isSetPersistFiles();
    boolean that_present_persistFiles = true && that.isSetPersistFiles();
    if (this_present_persistFiles || that_present_persistFiles) {
      if (!(this_present_persistFiles && that_present_persistFiles))
        return false;
      if (!this.persistFiles.equals(that.persistFiles))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_persistFiles = true && (isSetPersistFiles());
    list.add(present_persistFiles);
    if (present_persistFiles)
      list.add(persistFiles);

    return list.hashCode();
  }

  @Override
  public int compareTo(PersistCommandOptions other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPersistFiles()).compareTo(other.isSetPersistFiles());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPersistFiles()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.persistFiles, other.persistFiles);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("PersistCommandOptions(");
    boolean first = true;

    sb.append("persistFiles:");
    if (this.persistFiles == null) {
      sb.append("null");
    } else {
      sb.append(this.persistFiles);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PersistCommandOptionsStandardSchemeFactory implements SchemeFactory {
    public PersistCommandOptionsStandardScheme getScheme() {
      return new PersistCommandOptionsStandardScheme();
    }
  }

  private static class PersistCommandOptionsStandardScheme extends StandardScheme<PersistCommandOptions> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PersistCommandOptions struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PERSIST_FILES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list78 = iprot.readListBegin();
                struct.persistFiles = new ArrayList<PersistFile>(_list78.size);
                PersistFile _elem79;
                for (int _i80 = 0; _i80 < _list78.size; ++_i80)
                {
                  _elem79 = new PersistFile();
                  _elem79.read(iprot);
                  struct.persistFiles.add(_elem79);
                }
                iprot.readListEnd();
              }
              struct.setPersistFilesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, PersistCommandOptions struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.persistFiles != null) {
        oprot.writeFieldBegin(PERSIST_FILES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.persistFiles.size()));
          for (PersistFile _iter81 : struct.persistFiles)
          {
            _iter81.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PersistCommandOptionsTupleSchemeFactory implements SchemeFactory {
    public PersistCommandOptionsTupleScheme getScheme() {
      return new PersistCommandOptionsTupleScheme();
    }
  }

  private static class PersistCommandOptionsTupleScheme extends TupleScheme<PersistCommandOptions> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PersistCommandOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPersistFiles()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetPersistFiles()) {
        {
          oprot.writeI32(struct.persistFiles.size());
          for (PersistFile _iter82 : struct.persistFiles)
          {
            _iter82.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PersistCommandOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list83 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.persistFiles = new ArrayList<PersistFile>(_list83.size);
          PersistFile _elem84;
          for (int _i85 = 0; _i85 < _list83.size; ++_i85)
          {
            _elem84 = new PersistFile();
            _elem84.read(iprot);
            struct.persistFiles.add(_elem84);
          }
        }
        struct.setPersistFilesIsSet(true);
      }
    }
  }

}

