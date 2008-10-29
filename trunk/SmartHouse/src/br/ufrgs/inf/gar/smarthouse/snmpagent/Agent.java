package br.ufrgs.inf.gar.smarthouse.snmpagent;
import javax.management.MBeanServer;

import com.ireasoning.protocol.snmp.SnmpBaseAgent;
import com.ireasoning.protocol.snmp.SnmpException;
import com.ireasoning.util.Logger;


/**
 * Agent main class
 */
public class Agent extends SnmpBaseAgent
{
    
    /**
     * Constructor. Create MBeanServer instance internally. Agent will be listening on port specified in config file, which can be retrieved by using SnmpAgentConfig.getPort().
     * @param configFileName Agent's config file name. If absolute path is not specified, the file will be assumed located under ./config directory or current directory
     */
    public Agent(String configFileName) throws Exception
    {
        super(configFileName);
    }
    
    /**
     * Constructor. Use MBeanServer object passed from caller
     * @param server MBeanServer object
     * @param configFileName Agent's config file name. If absolute path is not specified, the file will be assumed located under ./config directory or current directory
     */
    public Agent(MBeanServer server, String configFileName) throws Exception
    {
        super(server, configFileName);
    }
    
    public static void main(String[] args)
    {
        try
        {
            //String configFile = "C:\\Documents and Settings\\Joana\\Desktop\\MIB-Joana_Flavio\\ireasoning_mibgen_output\\config\\SnmpAgent.xml";
            String configFile = System.getProperty("user.dir") + "\\config\\SnmpAgent.xml";
            System.out.println(configFile);
            Agent agent = new Agent(configFile);
            // UnComment one of the following two lines if you want to send coldStart trap
            // sendV1ColdStartTrap();
            // sendV2ColdStartTrap();
        }
        catch(Exception e)
        {
            Logger.error(e);
        }
    }
    
    /**
     * Sets the MIB tree data structure. This method gets called by base class
     */
    protected void setOIDTree()
    {
        _root = OIDTree.getTree();
    }
    
    /**
     * Registers necessary MBeans
     */
    protected void registerMBeans() throws SnmpException
    {
        if(_root == null) setOIDTree();
        AgentMib.registerMBeans(_mbeanServer, _root);
    }
    
    /**
     * Unregisters necessary MBeans
     */
    protected void unregisterMBeans()
    {
        AgentMib.unregisterMBeans();
        OIDTree.resetTree();
    }
}
