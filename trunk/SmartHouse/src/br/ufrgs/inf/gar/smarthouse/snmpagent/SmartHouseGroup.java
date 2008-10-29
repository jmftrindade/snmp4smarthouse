package br.ufrgs.inf.gar.smarthouse.snmpagent;
import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub;
import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShAirCondStatusResponse;
import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShAirCondTemperatureResponse;
import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShCurrentLocationResponse;
import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShFridgeTemperatureResponse;
import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShIsOnTheFloorResponse;
import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShSmokeDetectedResponse;
import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.SetShAirCondTemperature;
import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.SetShFridgeTemperature;

import com.ireasoning.protocol.snmp.OIDTreeNode;
import com.ireasoning.protocol.snmp.SnmpBaseGroup;

/**
 * Class represents smartHouse mib object in SMARTHOUSE
 */
public class SmartHouseGroup extends SnmpBaseGroup implements SmartHouseGroupMBean
{
    // SnmpOID: .1.3.6.1.4.1.7754.1.0
    protected int _shSmokeDetected = 0;
    // SnmpOID: .1.3.6.1.4.1.7754.2.0
    protected int _shIsOnTheFloor = 0;
    // SnmpOID: .1.3.6.1.4.1.7754.3.0
    protected int _shAirCondTemperature = 0;
    // SnmpOID: .1.3.6.1.4.1.7754.4.0
    protected int _shFridgeTemperature = 0;
    // SnmpOID: .1.3.6.1.4.1.7754.5.0
    protected String _shCurrentLocation = "";
    // SnmpOID: .1.3.6.1.4.1.7754.6.0
    protected int _shAirCondStatus = 0;
    
    
    /* Joana and Flavio, web service smarthouse client (custom code) */
    // web service client
    private WSSmartHouseHttpportStub smartHouseStub;

    // get smoke detector response message
    private GetShSmokeDetectedResponse smokeDetectedResponse;
 
    // get is on the floor detector response message
    private GetShIsOnTheFloorResponse isOnTheFloorResponse;
    
    // get air conditioner temperature response message
    private GetShAirCondTemperatureResponse airCondTemperatureResponse;

    // set air conditioner temperature request message
    private SetShAirCondTemperature airCondTemperatureRequest;
    
    // get fridge temperature response message
    private GetShFridgeTemperatureResponse fridgeTemperatureResponse;

    // set fridge temperature request message
    private SetShFridgeTemperature fridgeTemperatureRequest;
    
    // location of the elderly person response message
    private GetShCurrentLocationResponse currentLocationResponse;

    // air conditioner status response message
    private GetShAirCondStatusResponse airCondStatusResponse;    
    /* Joana and Flavio, custom code */
    
    
    /**
     * Constructor
     * @param root SnmpOID tree root
     * @param oid the SnmpOID of this group
     * @param args the objects passed from caller for Initialization purpose
     */
    public SmartHouseGroup(OIDTreeNode root, String oid, Object [] args)
    {
        super(root, oid);
        
        /* Joana and Flavio, custom code - initialization */
        try {
            smartHouseStub = new WSSmartHouseHttpportStub("http://localhost:8080/axis2/services/WSSmartHouse");
        } catch (AxisFault e) {
            System.err.println("Unable to connect to web service");
            e.printStackTrace();
        }   
    }
    
    /**
     * Gets new shSmokeDetected value
     */
    public synchronized int getShSmokeDetected()
    {
        /* Joana and Flavio, custom code */
        try {
            smokeDetectedResponse = smartHouseStub.getShSmokeDetected();
            this._shSmokeDetected = smokeDetectedResponse.get_return();
        } catch (RemoteException e) {
            System.err.println("Unable to retrieve smoke detector value");
            System.err.println("Returning previous value");
            e.printStackTrace();
        }
        return this._shSmokeDetected;
    }
       
    /**
     * Gets new shIsOnTheFloor value
     */
    public synchronized int getShIsOnTheFloor()
    {
        /* Joana and Flavio, custom code */
        try {
            isOnTheFloorResponse = smartHouseStub.getShIsOnTheFloor();
            this._shIsOnTheFloor = isOnTheFloorResponse.get_return();
        } catch (RemoteException e) {
            System.err.println("Unable to retrieve 'is on the floor' value");
            System.err.println("Returning previous value");
            e.printStackTrace();
        }
        return this._shIsOnTheFloor;
    }
    
    /**
     * Gets new shAirCondTemperature value
     */
    public synchronized int getShAirCondTemperature()
    {
        /* Joana and Flavio, custom code */
        try {
            if (this._shAirCondTemperature != 0) {
                return this._shAirCondTemperature;
            }
            airCondTemperatureResponse = smartHouseStub.getShAirCondTemperature();
            this._shAirCondTemperature = airCondTemperatureResponse.get_return();
        } catch (RemoteException e) {
            System.err.println("Unable to retrieve air conditioner temperature");
            System.err.println("Returning previous value");
            e.printStackTrace();
        }
        return this._shAirCondTemperature;
    }
    
    /**
     * Sets new shAirCondTemperature value
     * @param value the new value
     */
    public synchronized void setShAirCondTemperature(int newValue)
    {
        /* Joana and Flavio, custom code */
        // our web service is stateless...
        airCondTemperatureRequest = new SetShAirCondTemperature();
        airCondTemperatureRequest.setShAirCondTemperature(newValue);
        try {
            smartHouseStub.setShAirCondTemperature(airCondTemperatureRequest);
        } catch (RemoteException e) {
            System.err.println("Unable to set air conditioner temperature");
            e.printStackTrace();
        }        
        // if we reach this point, it means we successfully set the temperature
        this._shAirCondTemperature = newValue;
    }
    
    /**
     * Gets new shFridgeTemperature value
     */
    public synchronized int getShFridgeTemperature()
    {
        /* Joana and Flavio, custom code */
        try {
            if (this._shFridgeTemperature != 0) {
                return this._shFridgeTemperature;
            }
            fridgeTemperatureResponse = smartHouseStub.getShFridgeTemperature();
            this._shFridgeTemperature = fridgeTemperatureResponse.get_return();
        } catch (RemoteException e) {
            System.err.println("Unable to retrieve fridge temperature");
            System.err.println("Returning previous value");
            e.printStackTrace();
        }
        return this._shFridgeTemperature;
    }
    
    /**
     * Sets new shFridgeTemperature value
     * @param value the new value
     */
    public synchronized void setShFridgeTemperature(int newValue)
    {
        /* Joana and Flavio, custom code */
        fridgeTemperatureRequest = new SetShFridgeTemperature();
        fridgeTemperatureRequest.setShFridgeTemperature(newValue);
        try {
            smartHouseStub.setShFridgeTemperature(fridgeTemperatureRequest);
        } catch (RemoteException e) {
            System.err.println("Unable to set fridge temperature");
            e.printStackTrace();
        }        
        this._shFridgeTemperature = newValue;
    }
    
    /**
     * Gets new shCurrentLocation value
     */
    public synchronized String getShCurrentLocation()
    {
        /* Joana and Flavio, custom code */
        try {
            currentLocationResponse = smartHouseStub.getShCurrentLocation();
            this._shCurrentLocation = currentLocationResponse.get_return();
        } catch (RemoteException e) {
            System.err.println("Unable to retrieve current location");
            System.err.println("Returning previous value");
            e.printStackTrace();
        }
        return this._shCurrentLocation;
    }
    
    /**
     * Gets new shAirCondStatus value
     */
    public synchronized int getShAirCondStatus()
    {
        /* Joana and Flavio, custom code */
        try {
            airCondStatusResponse = smartHouseStub.getShAirCondStatus();
            this._shAirCondStatus = airCondStatusResponse.get_return();
        } catch (RemoteException e) {
            System.err.println("Unable to retrieve air conditioner status");
            System.err.println("Returning previous value");
            e.printStackTrace();
        }
        return this._shAirCondStatus;
    }
    
}
