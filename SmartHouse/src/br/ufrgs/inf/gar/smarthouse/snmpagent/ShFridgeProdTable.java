package br.ufrgs.inf.gar.smarthouse.snmpagent;

import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub;

import com.ireasoning.protocol.snmp.OIDTreeNode;
import com.ireasoning.protocol.snmp.SnmpTable;
import com.ireasoning.protocol.snmp.SnmpTableEntry;

/**
 * Class represents shFridgeProdTable MIB object in SMARTHOUSE
 */
public class ShFridgeProdTable extends SnmpTable implements ShFridgeProdTableMBean
{

    /* Joana and Flavio, web service smarthouse client (custom code) */
    // web service client
    private WSSmartHouseHttpportStub smartHouseStub;
      
    /**
     * Constructor
     * @param root SnmpOID tree root
     * @param oid the SnmpOID of this table. For example, ".1.3.6.1.2.1.2.2" for IfTable in RFC1213  
     * @param args the objects passed from caller for Initialization purpose
     */
    public ShFridgeProdTable (OIDTreeNode root, String oid, Object[] args)
    {
        super(root, oid);
        // TODO: Add your implementation
        
        /* Joana and Flavio, custom code - initialization */
        // retrieve fridge products from web service
/*        
        try {
            smartHouseStub = new WSSmartHouseHttpEndpointStub("http://localhost:8080/axis2/services/WSSmartHouse");
            WSSmartHouse_ProductEntry[] fridgeProducts = smartHouseStub.getShFridgeProdTable().get_return();
            
            ShFridgeProdEntry prodEntry;
            for (WSSmartHouse_ProductEntry p : fridgeProducts) {
                prodEntry = new ShFridgeProdEntry(
                        this, 
                        p.get_shFridgeProdTableProdId(), 
                        p.get_shFridgeProdTableProdName(), 
                        p.get_shFridgeProdTableProdExpDate()
                );
                this.addRow(prodEntry);
            }
        } catch (AxisFault e) {
            System.err.println("Unable to connect to web service");
            e.printStackTrace();
        } catch (RemoteException e) {
            System.err.println("Unable to retrieve fridge products");
            e.printStackTrace();
        }
  */      
        this.initTable();
    }
    
    /**
     * Creates a new instance of table entry object
     */
    public SnmpTableEntry newEntryInstance()
    {
        return new ShFridgeProdEntry (this);
    }
    
    /**
     * Gets shFridgeProdTableProdId value
     * @param shFridgeProdEntry table entry object
     */
    public int getShFridgeProdTableProdId(SnmpTableEntry shFridgeProdEntry)
    {
        synchronized (shFridgeProdEntry)
        {
            ShFridgeProdEntry entry = (ShFridgeProdEntry) shFridgeProdEntry;
            // TODO: Add your implementation
            return entry._shFridgeProdTableProdId;
        }
    }
    
    /**
     * Sets new shFridgeProdTableProdId value
     * @param shFridgeProdEntry table entry object
     * @param newValue new value to be set
     */
    public void setShFridgeProdTableProdId(SnmpTableEntry shFridgeProdEntry, int newValue)
    {
        // This MIB node is not writeable, so ShFridgeProdTableMBean does not have this method
        synchronized (shFridgeProdEntry)
        {
            ShFridgeProdEntry entry = (ShFridgeProdEntry) shFridgeProdEntry;
            entry._shFridgeProdTableProdId = newValue;
            // TODO: Add your implementation
        }
    }
    
    /**
     * Gets shFridgeProdTableProdName value
     * @param shFridgeProdEntry table entry object
     */
    public String getShFridgeProdTableProdName(SnmpTableEntry shFridgeProdEntry)
    {
        synchronized (shFridgeProdEntry)
        {
            ShFridgeProdEntry entry = (ShFridgeProdEntry) shFridgeProdEntry;
            // TODO: Add your implementation
            return entry._shFridgeProdTableProdName;
        }
    }
    
    /**
     * Sets new shFridgeProdTableProdName value
     * @param shFridgeProdEntry table entry object
     * @param newValue new value to be set
     */
    public void setShFridgeProdTableProdName(SnmpTableEntry shFridgeProdEntry, String newValue)
    {
        // This MIB node is not writeable, so ShFridgeProdTableMBean does not have this method
        synchronized (shFridgeProdEntry)
        {
            ShFridgeProdEntry entry = (ShFridgeProdEntry) shFridgeProdEntry;
            entry._shFridgeProdTableProdName = newValue;
            // TODO: Add your implementation
        }
    }
    
    /**
     * Gets shFridgeProdTableProdExpDate value
     * @param shFridgeProdEntry table entry object
     */
    public String getShFridgeProdTableProdExpDate(SnmpTableEntry shFridgeProdEntry)
    {
        synchronized (shFridgeProdEntry)
        {
            ShFridgeProdEntry entry = (ShFridgeProdEntry) shFridgeProdEntry;
            // TODO: Add your implementation
            return entry._shFridgeProdTableProdExpDate;
        }
    }
    
    /**
     * Sets new shFridgeProdTableProdExpDate value
     * @param shFridgeProdEntry table entry object
     * @param newValue new value to be set
     */
    public void setShFridgeProdTableProdExpDate(SnmpTableEntry shFridgeProdEntry, String newValue)
    {
        // This MIB node is not writeable, so ShFridgeProdTableMBean does not have this method
        synchronized (shFridgeProdEntry)
        {
            ShFridgeProdEntry entry = (ShFridgeProdEntry) shFridgeProdEntry;
            entry._shFridgeProdTableProdExpDate = newValue;
            // TODO: Add your implementation
        }
    }
    
    /**
     * Initializes table with a set of products.
     */
    private void initTable() {        
        this.addRow(new ShFridgeProdEntry(this, 1, "leite", "31-10-2008"));
        this.addRow(new ShFridgeProdEntry(this, 2, "ovos", "15-11-2008"));
        this.addRow(new ShFridgeProdEntry(this, 3, "manteiga", "29-11-2008"));
        this.addRow(new ShFridgeProdEntry(this, 4, "queijo", "5-11-2008"));
        this.addRow(new ShFridgeProdEntry(this, 5, "presunto", "5-11-2008"));
        this.addRow(new ShFridgeProdEntry(this, 6, "iogurte", "10-11-2008"));
        this.addRow(new ShFridgeProdEntry(this, 7, "molho_tomate", "7-11-2008"));
        this.addRow(new ShFridgeProdEntry(this, 8, "suco_laranja", "5-11-2008"));
    }
    
}
