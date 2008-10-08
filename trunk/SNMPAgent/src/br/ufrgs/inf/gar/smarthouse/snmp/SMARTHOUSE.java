package br.ufrgs.inf.gar.smarthouse.snmp;
 
//--AgentGen BEGIN=_BEGIN
//--AgentGen END

import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.agent.MOAccess;
import org.snmp4j.agent.MOGroup;
import org.snmp4j.agent.MOServer;
import org.snmp4j.agent.mo.DefaultMOFactory;
import org.snmp4j.agent.mo.DefaultMOMutableRow2PC;
import org.snmp4j.agent.mo.DefaultMOMutableRow2PCFactory;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.agent.mo.MOColumn;
import org.snmp4j.agent.mo.MOFactory;
import org.snmp4j.agent.mo.MOMutableTableModel;
import org.snmp4j.agent.mo.MOScalar;
import org.snmp4j.agent.mo.MOTable;
import org.snmp4j.agent.mo.MOTableIndex;
import org.snmp4j.agent.mo.MOTableIndexValidator;
import org.snmp4j.agent.mo.MOTableModel;
import org.snmp4j.agent.mo.MOTableRow;
import org.snmp4j.agent.mo.MOTableSubIndex;
import org.snmp4j.agent.mo.MOValueValidationEvent;
import org.snmp4j.agent.mo.MOValueValidationListener;
import org.snmp4j.agent.request.SubRequest;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.log.LogFactory;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.SMIConstants;
import org.snmp4j.smi.Variable;


//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class SMARTHOUSE 
//--AgentGen BEGIN=_EXTENDS
//--AgentGen END
implements MOGroup 
//--AgentGen BEGIN=_IMPLEMENTS
//--AgentGen END
{

  private static final LogAdapter LOGGER = 
      LogFactory.getLogger(SMARTHOUSE.class);

//--AgentGen BEGIN=_STATIC
//--AgentGen END

  // Factory
  private MOFactory moFactory = 
    DefaultMOFactory.getInstance();

  // Constants 
  public static final OID oidShSmokeDetected = 
    new OID(new int[] { 1,3,6,1,4,1,7754,1,0 });
  public static final OID oidShIsOnTheFloor = 
    new OID(new int[] { 1,3,6,1,4,1,7754,2,0 });
  public static final OID oidShAirCondTemperature = 
    new OID(new int[] { 1,3,6,1,4,1,7754,3,0 });
  public static final OID oidShFridgeTemperature = 
    new OID(new int[] { 1,3,6,1,4,1,7754,4,0 });
  public static final OID oidShCurrentLocation = 
    new OID(new int[] { 1,3,6,1,4,1,7754,5,0 });
  public static final OID oidShAirCondStatus = 
    new OID(new int[] { 1,3,6,1,4,1,7754,6,0 });


  // Enumerations
  public static final class ShSmokeDetectedEnum {
    public static final int _true = 1;
    public static final int _false = 2;
  }
  public static final class ShIsOnTheFloorEnum {
    public static final int _true = 1;
    public static final int _false = 2;
  }
  public static final class ShAirCondStatusEnum {
    public static final int off = 1;
    public static final int on = 2;
  }




  // TextualConventions
  private static final String TC_MODULE_SNMPV2_TC = "SNMPv2-TC";
  private static final String TC_DISPLAYSTRING = "DisplayString";

  // Scalars
  private MOScalar shSmokeDetected;
  private MOScalar shIsOnTheFloor;
  private MOScalar shAirCondTemperature;
  private MOScalar shFridgeTemperature;
  private MOScalar shCurrentLocation;
  private MOScalar shAirCondStatus;

  // Tables
  public static final OID oidShFridgeProdEntry = 
    new OID(new int[] { 1,3,6,1,4,1,7754,7,1 });

  // Index OID definitions
  public static final OID oidShFridgeProdTableProdId =
    new OID(new int[] { 1,3,6,1,4,1,7754,7,1,1 });

  // Column TC definitions for shFridgeProdEntry:
  public static final String tcModuleSNMPv2Tc = "SNMPv2-TC";
  public static final String tcDefDisplayString = "DisplayString";
    
  // Column sub-identifer definitions for shFridgeProdEntry:
  public static final int colShFridgeProdTableProdId = 1;
  public static final int colShFridgeProdTableProdName = 2;
  public static final int colShFridgeProdTableProdExpDate = 3;

  // Column index definitions for shFridgeProdEntry:
  public static final int idxShFridgeProdTableProdId = 0;
  public static final int idxShFridgeProdTableProdName = 1;
  public static final int idxShFridgeProdTableProdExpDate = 2;

  private MOTableSubIndex[] shFridgeProdEntryIndexes;
  private MOTableIndex shFridgeProdEntryIndex;
  
  private MOTable      shFridgeProdEntry;
  private MOTableModel shFridgeProdEntryModel;


//--AgentGen BEGIN=_MEMBERS
//--AgentGen END

  /**
   * Constructs a SMARTHOUSE instance without actually creating its
   * <code>ManagedObject</code> instances. This has to be done in a
   * sub-class constructor or after construction by calling 
   * {@link #createMO(MOFactory moFactory)}. 
   */
  protected SMARTHOUSE() {
//--AgentGen BEGIN=_DEFAULTCONSTRUCTOR
//--AgentGen END
  }

  /**
   * Constructs a SMARTHOUSE instance and actually creates its
   * <code>ManagedObject</code> instances using the supplied 
   * <code>MOFactory</code> (by calling
   * {@link #createMO(MOFactory moFactory)}).
   * @param moFactory
   *    the <code>MOFactory</code> to be used to create the
   *    managed objects for this module.
   */
  public SMARTHOUSE(MOFactory moFactory) {
    createMO(moFactory);
//--AgentGen BEGIN=_FACTORYCONSTRUCTOR
//--AgentGen END
  }

//--AgentGen BEGIN=_CONSTRUCTORS
//--AgentGen END

  /**
   * Create the ManagedObjects defined for this MIB module
   * using the specified {@link MOFactory}.
   * @param moFactory
   *    the <code>MOFactory</code> instance to use for object 
   *    creation.
   */
  protected void createMO(MOFactory moFactory) {
    addTCsToFactory(moFactory);
    shSmokeDetected = 
      moFactory.createScalar(oidShSmokeDetected,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new Integer32());
    shIsOnTheFloor = 
      moFactory.createScalar(oidShIsOnTheFloor,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new Integer32());
    shAirCondTemperature = 
      new ShAirCondTemperature(oidShAirCondTemperature, 
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE));
    shAirCondTemperature.addMOValueValidationListener(new ShAirCondTemperatureValidator());
    shFridgeTemperature = 
      new ShFridgeTemperature(oidShFridgeTemperature, 
                              moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE));
    shFridgeTemperature.addMOValueValidationListener(new ShFridgeTemperatureValidator());
    shCurrentLocation = 
      moFactory.createScalar(oidShCurrentLocation,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new OctetString(),
                             TC_MODULE_SNMPV2_TC, TC_DISPLAYSTRING);
    shAirCondStatus = 
      moFactory.createScalar(oidShAirCondStatus,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new Integer32());
    createShFridgeProdEntry(moFactory);
  }

  public MOScalar getShSmokeDetected() {
    return shSmokeDetected;
  }
  public MOScalar getShIsOnTheFloor() {
    return shIsOnTheFloor;
  }
  public MOScalar getShAirCondTemperature() {
    return shAirCondTemperature;
  }
  public MOScalar getShFridgeTemperature() {
    return shFridgeTemperature;
  }
  public MOScalar getShCurrentLocation() {
    return shCurrentLocation;
  }
  public MOScalar getShAirCondStatus() {
    return shAirCondStatus;
  }


  public MOTable getShFridgeProdEntry() {
    return shFridgeProdEntry;
  }


  private void createShFridgeProdEntry(MOFactory moFactory) {
    // Index definition
    shFridgeProdEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidShFridgeProdTableProdId, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    shFridgeProdEntryIndex = 
      moFactory.createIndex(shFridgeProdEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=shFridgeProdEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] shFridgeProdEntryColumns = new MOColumn[3];
    shFridgeProdEntryColumns[idxShFridgeProdTableProdId] = 
      moFactory.createColumn(colShFridgeProdTableProdId, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    shFridgeProdEntryColumns[idxShFridgeProdTableProdName] = 
      moFactory.createColumn(colShFridgeProdTableProdName, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefDisplayString);
    shFridgeProdEntryColumns[idxShFridgeProdTableProdExpDate] = 
      moFactory.createColumn(colShFridgeProdTableProdExpDate, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefDisplayString);
    // Table model
    shFridgeProdEntryModel = 
      moFactory.createTableModel(oidShFridgeProdEntry,
                                 shFridgeProdEntryIndex,
                                 shFridgeProdEntryColumns);
    ((MOMutableTableModel)shFridgeProdEntryModel).setRowFactory(
      new ShFridgeProdEntryRowFactory());
    shFridgeProdEntry = 
      moFactory.createTable(oidShFridgeProdEntry,
                            shFridgeProdEntryIndex,
                            shFridgeProdEntryColumns,
                            shFridgeProdEntryModel);
  }



  public void registerMOs(MOServer server, OctetString context) 
    throws DuplicateRegistrationException 
  {
    // Scalar Objects
    server.register(this.shSmokeDetected, context);
    server.register(this.shIsOnTheFloor, context);
    server.register(this.shAirCondTemperature, context);
    server.register(this.shFridgeTemperature, context);
    server.register(this.shCurrentLocation, context);
    server.register(this.shAirCondStatus, context);
    server.register(this.shFridgeProdEntry, context);
//--AgentGen BEGIN=_registerMOs
//--AgentGen END
  }

  public void unregisterMOs(MOServer server, OctetString context) {
    // Scalar Objects
    server.unregister(this.shSmokeDetected, context);
    server.unregister(this.shIsOnTheFloor, context);
    server.unregister(this.shAirCondTemperature, context);
    server.unregister(this.shFridgeTemperature, context);
    server.unregister(this.shCurrentLocation, context);
    server.unregister(this.shAirCondStatus, context);
    server.unregister(this.shFridgeProdEntry, context);
//--AgentGen BEGIN=_unregisterMOs
//--AgentGen END
  }

  // Notifications

  // Scalars
  public class ShAirCondTemperature extends MOScalar {
    ShAirCondTemperature(OID oid, MOAccess access) {
      super(oid, access, new Integer32());
//--AgentGen BEGIN=shAirCondTemperature
//--AgentGen END
    }

    public int isValueOK(SubRequest request) {
      Variable newValue =
        request.getVariableBinding().getVariable();
      int valueOK = super.isValueOK(request);
      if (valueOK != SnmpConstants.SNMP_ERROR_SUCCESS) {
      	return valueOK;
      }
      long v = ((Integer32)newValue).getValue();
      if (!(((v >= 15L) && (v <= 30L)))) {
        valueOK = SnmpConstants.SNMP_ERROR_WRONG_VALUE;
      }    
     //--AgentGen BEGIN=shAirCondTemperature::isValueOK
     //--AgentGen END
      return valueOK; 
    }

    public Variable getValue() {
     //--AgentGen BEGIN=shAirCondTemperature::getValue
     //--AgentGen END
      return super.getValue();    
    }

    public int setValue(Variable newValue) {
     //--AgentGen BEGIN=shAirCondTemperature::setValue
     //--AgentGen END
      return super.setValue(newValue);    
    }

     //--AgentGen BEGIN=shAirCondTemperature::_METHODS
     //--AgentGen END

  }

  public class ShFridgeTemperature extends MOScalar {
    ShFridgeTemperature(OID oid, MOAccess access) {
      super(oid, access, new Integer32());
//--AgentGen BEGIN=shFridgeTemperature
//--AgentGen END
    }

    public int isValueOK(SubRequest request) {
      Variable newValue =
        request.getVariableBinding().getVariable();
      int valueOK = super.isValueOK(request);
      if (valueOK != SnmpConstants.SNMP_ERROR_SUCCESS) {
      	return valueOK;
      }
      long v = ((Integer32)newValue).getValue();
      if (!(((v >= -20L) && (v <= 0L)))) {
        valueOK = SnmpConstants.SNMP_ERROR_WRONG_VALUE;
      }    
     //--AgentGen BEGIN=shFridgeTemperature::isValueOK
     //--AgentGen END
      return valueOK; 
    }

    public Variable getValue() {
     //--AgentGen BEGIN=shFridgeTemperature::getValue
     //--AgentGen END
      return super.getValue();    
    }

    public int setValue(Variable newValue) {
     //--AgentGen BEGIN=shFridgeTemperature::setValue
     //--AgentGen END
      return super.setValue(newValue);    
    }

     //--AgentGen BEGIN=shFridgeTemperature::_METHODS
     //--AgentGen END

  }


  // Value Validators
  /**
   * The <code>ShAirCondTemperatureValidator</code> implements the value
   * validation for <code>ShAirCondTemperature</code>.
   */
  static class ShAirCondTemperatureValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
      long v = ((Integer32)newValue).getValue();
      if (!(((v >= 15L) && (v <= 30L)))) {
        validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_VALUE);
        return;
      }
     //--AgentGen BEGIN=shAirCondTemperature::validate
     //--AgentGen END
    }
  }
  /**
   * The <code>ShFridgeTemperatureValidator</code> implements the value
   * validation for <code>ShFridgeTemperature</code>.
   */
  static class ShFridgeTemperatureValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
      long v = ((Integer32)newValue).getValue();
      if (!(((v >= -20L) && (v <= 0L)))) {
        validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_VALUE);
        return;
      }
     //--AgentGen BEGIN=shFridgeTemperature::validate
     //--AgentGen END
    }
  }


  // Rows and Factories

  public class ShFridgeProdEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=shFridgeProdEntry::RowMembers
     //--AgentGen END

    public ShFridgeProdEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=shFridgeProdEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getShFridgeProdTableProdId() {
     //--AgentGen BEGIN=shFridgeProdEntry::getShFridgeProdTableProdId
     //--AgentGen END
      return (Integer32) super.getValue(idxShFridgeProdTableProdId);
    }  
    
    public void setShFridgeProdTableProdId(Integer32 newValue) {
     //--AgentGen BEGIN=shFridgeProdEntry::setShFridgeProdTableProdId
     //--AgentGen END
      super.setValue(idxShFridgeProdTableProdId, newValue);
    }
    
    public OctetString getShFridgeProdTableProdName() {
     //--AgentGen BEGIN=shFridgeProdEntry::getShFridgeProdTableProdName
     //--AgentGen END
      return (OctetString) super.getValue(idxShFridgeProdTableProdName);
    }  
    
    public void setShFridgeProdTableProdName(OctetString newValue) {
     //--AgentGen BEGIN=shFridgeProdEntry::setShFridgeProdTableProdName
     //--AgentGen END
      super.setValue(idxShFridgeProdTableProdName, newValue);
    }
    
    public OctetString getShFridgeProdTableProdExpDate() {
     //--AgentGen BEGIN=shFridgeProdEntry::getShFridgeProdTableProdExpDate
     //--AgentGen END
      return (OctetString) super.getValue(idxShFridgeProdTableProdExpDate);
    }  
    
    public void setShFridgeProdTableProdExpDate(OctetString newValue) {
     //--AgentGen BEGIN=shFridgeProdEntry::setShFridgeProdTableProdExpDate
     //--AgentGen END
      super.setValue(idxShFridgeProdTableProdExpDate, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=shFridgeProdEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxShFridgeProdTableProdId: 
        	return getShFridgeProdTableProdId();
        case idxShFridgeProdTableProdName: 
        	return getShFridgeProdTableProdName();
        case idxShFridgeProdTableProdExpDate: 
        	return getShFridgeProdTableProdExpDate();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=shFridgeProdEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxShFridgeProdTableProdId: 
        	setShFridgeProdTableProdId((Integer32)value);
        	break;
        case idxShFridgeProdTableProdName: 
        	setShFridgeProdTableProdName((OctetString)value);
        	break;
        case idxShFridgeProdTableProdExpDate: 
        	setShFridgeProdTableProdExpDate((OctetString)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=shFridgeProdEntry::Row
     //--AgentGen END
  }
  
  class ShFridgeProdEntryRowFactory 
        extends DefaultMOMutableRow2PCFactory 
  {
    public synchronized MOTableRow createRow(OID index, Variable[] values) 
        throws UnsupportedOperationException 
    {
      ShFridgeProdEntryRow row = 
        new ShFridgeProdEntryRow(index, values);
     //--AgentGen BEGIN=shFridgeProdEntry::createRow
     //--AgentGen END
      return row;
    }
    
    public synchronized void freeRow(MOTableRow row) {
     //--AgentGen BEGIN=shFridgeProdEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=shFridgeProdEntry::RowFactory
     //--AgentGen END
  }


//--AgentGen BEGIN=_METHODS
//--AgentGen END

  // Textual Definitions of MIB module SMARTHOUSE
  protected void addTCsToFactory(MOFactory moFactory) {
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_BEGIN
//--AgentGen END

  // Textual Definitions of other MIB modules
  protected void addImportedTCsToFactory(MOFactory moFactory) {
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_END
//--AgentGen END

//--AgentGen BEGIN=_CLASSES
//--AgentGen END

//--AgentGen BEGIN=_END
//--AgentGen END
}


