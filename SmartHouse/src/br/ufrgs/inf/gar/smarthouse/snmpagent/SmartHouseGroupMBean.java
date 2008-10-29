package br.ufrgs.inf.gar.smarthouse.snmpagent;
import com.ireasoning.protocol.snmp.SnmpBaseGroupMBean;

/**
 * Interface represents smartHouse mib object in SMARTHOUSE
 */
public interface SmartHouseGroupMBean extends SnmpBaseGroupMBean
{
    /**
     * Gets new shSmokeDetected value
     */
    public int getShSmokeDetected();
    
    /**
     * Gets new shIsOnTheFloor value
     */
    public int getShIsOnTheFloor();
    
    /**
     * Gets new shAirCondTemperature value
     */
    public int getShAirCondTemperature();
    
    /**
     * Sets new shAirCondTemperature value
     * @param value the new value
     */
    public void setShAirCondTemperature(int value);
    
    /**
     * Gets new shFridgeTemperature value
     */
    public int getShFridgeTemperature();
    
    /**
     * Sets new shFridgeTemperature value
     * @param value the new value
     */
    public void setShFridgeTemperature(int value);
    
    /**
     * Gets new shCurrentLocation value
     */
    public String getShCurrentLocation();
    
    /**
     * Gets new shAirCondStatus value
     */
    public int getShAirCondStatus();
    
}
