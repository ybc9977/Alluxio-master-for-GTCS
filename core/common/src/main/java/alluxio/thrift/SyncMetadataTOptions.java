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
public class SyncMetadataTOptions implements org.apache.thrift.TBase<SyncMetadataTOptions, SyncMetadataTOptions._Fields>, java.io.Serializable, Cloneable, Comparable<SyncMetadataTOptions> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SyncMetadataTOptions");

  private static final org.apache.thrift.protocol.TField COMMON_OPTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("commonOptions", org.apache.thrift.protocol.TType.STRUCT, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SyncMetadataTOptionsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SyncMetadataTOptionsTupleSchemeFactory());
  }

  public FileSystemMasterCommonTOptions commonOptions; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COMMON_OPTIONS((short)1, "commonOptions");

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
        case 1: // COMMON_OPTIONS
          return COMMON_OPTIONS;
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
  private static final _Fields optionals[] = {_Fields.COMMON_OPTIONS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COMMON_OPTIONS, new org.apache.thrift.meta_data.FieldMetaData("commonOptions", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FileSystemMasterCommonTOptions.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SyncMetadataTOptions.class, metaDataMap);
  }

  public SyncMetadataTOptions() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SyncMetadataTOptions(SyncMetadataTOptions other) {
    if (other.isSetCommonOptions()) {
      this.commonOptions = new FileSystemMasterCommonTOptions(other.commonOptions);
    }
  }

  public SyncMetadataTOptions deepCopy() {
    return new SyncMetadataTOptions(this);
  }

  @Override
  public void clear() {
    this.commonOptions = null;
  }

  public FileSystemMasterCommonTOptions getCommonOptions() {
    return this.commonOptions;
  }

  public SyncMetadataTOptions setCommonOptions(FileSystemMasterCommonTOptions commonOptions) {
    this.commonOptions = commonOptions;
    return this;
  }

  public void unsetCommonOptions() {
    this.commonOptions = null;
  }

  /** Returns true if field commonOptions is set (has been assigned a value) and false otherwise */
  public boolean isSetCommonOptions() {
    return this.commonOptions != null;
  }

  public void setCommonOptionsIsSet(boolean value) {
    if (!value) {
      this.commonOptions = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COMMON_OPTIONS:
      if (value == null) {
        unsetCommonOptions();
      } else {
        setCommonOptions((FileSystemMasterCommonTOptions)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COMMON_OPTIONS:
      return getCommonOptions();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COMMON_OPTIONS:
      return isSetCommonOptions();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SyncMetadataTOptions)
      return this.equals((SyncMetadataTOptions)that);
    return false;
  }

  public boolean equals(SyncMetadataTOptions that) {
    if (that == null)
      return false;

    boolean this_present_commonOptions = true && this.isSetCommonOptions();
    boolean that_present_commonOptions = true && that.isSetCommonOptions();
    if (this_present_commonOptions || that_present_commonOptions) {
      if (!(this_present_commonOptions && that_present_commonOptions))
        return false;
      if (!this.commonOptions.equals(that.commonOptions))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_commonOptions = true && (isSetCommonOptions());
    list.add(present_commonOptions);
    if (present_commonOptions)
      list.add(commonOptions);

    return list.hashCode();
  }

  @Override
  public int compareTo(SyncMetadataTOptions other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCommonOptions()).compareTo(other.isSetCommonOptions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommonOptions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commonOptions, other.commonOptions);
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
    StringBuilder sb = new StringBuilder("SyncMetadataTOptions(");
    boolean first = true;

    if (isSetCommonOptions()) {
      sb.append("commonOptions:");
      if (this.commonOptions == null) {
        sb.append("null");
      } else {
        sb.append(this.commonOptions);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (commonOptions != null) {
      commonOptions.validate();
    }
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

  private static class SyncMetadataTOptionsStandardSchemeFactory implements SchemeFactory {
    public SyncMetadataTOptionsStandardScheme getScheme() {
      return new SyncMetadataTOptionsStandardScheme();
    }
  }

  private static class SyncMetadataTOptionsStandardScheme extends StandardScheme<SyncMetadataTOptions> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SyncMetadataTOptions struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COMMON_OPTIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.commonOptions = new FileSystemMasterCommonTOptions();
              struct.commonOptions.read(iprot);
              struct.setCommonOptionsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SyncMetadataTOptions struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.commonOptions != null) {
        if (struct.isSetCommonOptions()) {
          oprot.writeFieldBegin(COMMON_OPTIONS_FIELD_DESC);
          struct.commonOptions.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SyncMetadataTOptionsTupleSchemeFactory implements SchemeFactory {
    public SyncMetadataTOptionsTupleScheme getScheme() {
      return new SyncMetadataTOptionsTupleScheme();
    }
  }

  private static class SyncMetadataTOptionsTupleScheme extends TupleScheme<SyncMetadataTOptions> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SyncMetadataTOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCommonOptions()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetCommonOptions()) {
        struct.commonOptions.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SyncMetadataTOptions struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.commonOptions = new FileSystemMasterCommonTOptions();
        struct.commonOptions.read(iprot);
        struct.setCommonOptionsIsSet(true);
      }
    }
  }

}

