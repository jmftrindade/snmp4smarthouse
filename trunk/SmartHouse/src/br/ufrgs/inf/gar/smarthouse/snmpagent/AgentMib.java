package br.ufrgs.inf.gar.smarthouse.snmpagent;
import com.ireasoning.core.jmx.MBeanManager;
import java.io.*;
import java.util.*;
import com.ireasoning.util.*;
import com.ireasoning.protocol.snmp.*;
import javax.management.*;


/**
 * Class for registering MBeans
 */
public class AgentMib
{
    private static MBeanManager _mgr = MBeanManager.getInstance();
    // Root node of OID tree
    private static OIDTreeNode _root;
    
    /**
     * Registers all necessary MBeans
     */
    public static void registerMBeans(MBeanServer server, OIDTreeNode root)
    {
        _root = root;
        try
        {
            registerSmartHouseGroup();
            registerShFridgeProdTable();
        }
        catch(Exception e)
        {
            Logger.error(e);
            throw new SnmpException(e.toString());
        }
    }
    
    /**
     * Unregisters MBeans
     */
    public static void unregisterMBeans()
    {
        try
        {
            unregisterSmartHouseGroup();
            unregisterShFridgeProdTable();
        }
        catch(Exception e)
        {
            Logger.error(e);
            throw new SnmpException(e.toString());
        }
    }
    
    /**
     * Creates instance and registers MBean
     */
    public static void registerSmartHouseGroup() throws Exception
    {
        if ( _smartHouseGroup == null )
        {
            _smartHouseGroup = new SmartHouseGroup(_root, ".1.3.6.1.4.1.7754", null);
        }
        ObjectName objName = new ObjectName("iReasoning:name=SmartHouseGroup,noPdu=true");
        if(!_mgr.isRegistered(objName))
        {
            _mgr.registerMBean(_smartHouseGroup, objName);
        }
    }
    
    /**
     * Unregisters MBean
     */
    public static void unregisterSmartHouseGroup() throws Exception
    {
        _mgr.unregisterMBean(new ObjectName("iReasoning:name=SmartHouseGroup,noPdu=true"));
        _smartHouseGroup = null;
    }
    
    /**
     * Creates instance and registers MBean
     */
    public static void registerShFridgeProdTable() throws Exception
    {
        if ( _shFridgeProdTable == null )
        {
            _shFridgeProdTable = new ShFridgeProdTable(_root, ".1.3.6.1.4.1.7754.7", null);
        }
        ObjectName objName = new ObjectName("iReasoning:name=ShFridgeProdTable,noPdu=true");
        if(!_mgr.isRegistered(objName))
        {
            _mgr.registerMBean(_shFridgeProdTable, objName);
        }
    }
    
    /**
     * Unregisters MBean
     */
    public static void unregisterShFridgeProdTable() throws Exception
    {
        _mgr.unregisterMBean(new ObjectName("iReasoning:name=ShFridgeProdTable,noPdu=true"));
        _shFridgeProdTable = null;
    }
    
    /**
     * Returns SmartHouseGroup object. If SmartHouseGroup is null, it 'll register the corresponding MBean first
     */
    public static SmartHouseGroup getSmartHouseGroup( )
    {
        if( _smartHouseGroup == null )
        {
            try
            {
                registerSmartHouseGroup();
            }
            catch(Exception e)
            {
                Logger.error(e);
            }
        }
        return _smartHouseGroup;
    }
    
    /**
     * Returns ShFridgeProdTable object. If ShFridgeProdTable is null, it 'll register the corresponding MBean first
     */
    public static ShFridgeProdTable getShFridgeProdTable( )
    {
        if( _shFridgeProdTable == null )
        {
            try
            {
                registerShFridgeProdTable();
            }
            catch(Exception e)
            {
                Logger.error(e);
            }
        }
        return _shFridgeProdTable;
    }
    
    
    static SmartHouseGroup _smartHouseGroup;
    static ShFridgeProdTable _shFridgeProdTable;
}
