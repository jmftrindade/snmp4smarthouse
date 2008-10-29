package br.ufrgs.inf.gar.smarthouse.snmpagent;
import com.ireasoning.protocol.snmp.SnmpTableEntry;
import com.ireasoning.protocol.snmp.SnmpTableMBean;

/**
 * Interface represents shFridgeProdTable MIB object in SMARTHOUSE
 */
public interface ShFridgeProdTableMBean extends SnmpTableMBean
{
    /**
     * Gets shFridgeProdTableProdId value
     * @param shFridgeProdEntry table entry object
     */
    public int getShFridgeProdTableProdId(SnmpTableEntry shFridgeProdEntry);
    
    /**
     * Gets shFridgeProdTableProdName value
     * @param shFridgeProdEntry table entry object
     */
    public String getShFridgeProdTableProdName(SnmpTableEntry shFridgeProdEntry);
    
    /**
     * Gets shFridgeProdTableProdExpDate value
     * @param shFridgeProdEntry table entry object
     */
    public String getShFridgeProdTableProdExpDate(SnmpTableEntry shFridgeProdEntry);
    
}
