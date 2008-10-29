package br.ufrgs.inf.gar.smarthouse.snmpagent;
import com.ireasoning.protocol.snmp.SnmpDataType;
import com.ireasoning.protocol.snmp.SnmpInt;
import com.ireasoning.protocol.snmp.SnmpOctetString;
import com.ireasoning.protocol.snmp.SnmpTable;
import com.ireasoning.protocol.snmp.SnmpTableEntry;

/**
 * Table entry class
 */
public class ShFridgeProdEntry extends SnmpTableEntry
{
    // SnmpOID: .1.3.6.1.4.1.7754.7.1.1
    protected int _shFridgeProdTableProdId = 0;
    // SnmpOID: .1.3.6.1.4.1.7754.7.1.2
    protected String _shFridgeProdTableProdName = "";
    // SnmpOID: .1.3.6.1.4.1.7754.7.1.3
    protected String _shFridgeProdTableProdExpDate = "";
    
    /**
     * Constructor
     * @param table the Table which contains this table entry class
     */
    public ShFridgeProdEntry(SnmpTable table)
    {
        super(table);
    }
    
    /**
     * Constructor. Initializes member variables
     * @param table the Table which contains this table entry class
     */
    public ShFridgeProdEntry( SnmpTable table, int shFridgeProdTableProdId, String shFridgeProdTableProdName, String shFridgeProdTableProdExpDate)
    {
        super(table);
        
        this._shFridgeProdTableProdId = shFridgeProdTableProdId;
        this._shFridgeProdTableProdName = shFridgeProdTableProdName;
        this._shFridgeProdTableProdExpDate = shFridgeProdTableProdExpDate;
        
    }
    
    /**
     * Returns the index string for this row
     * @return the index string for this row. Return null to indicate that this row will not be added
     */
    public String getIndexSuffix()
    {
        if(_suffix.length() == 0)
        {
            _suffix = "." + SnmpTableEntry.getIndexString("" + _shFridgeProdTableProdId, false);
        }
        return _suffix;
    }
    
    /**
     * Sets column value at specified index
     * @param index the index of column to be set new value, ordered by their corresponding OID values
     * @param value new value of the column
     */
    public void set(int index, SnmpDataType value)
    {
        switch(index)
        {
            case 0 :
                _shFridgeProdTableProdId = ((SnmpInt) value).getValue();
                break;
            case 1 :
                _shFridgeProdTableProdName = ((SnmpOctetString)value).toString2();
                break;
            case 2 :
                _shFridgeProdTableProdExpDate = ((SnmpOctetString)value).toString2();
                break;
        }
    }
    
}
