package br.ufrgs.inf.gar.smarthouse.snmpagent;
import com.ireasoning.protocol.snmp.OIDTreeNode;
public class OIDTree
{
    private static OIDTreeNode _root = null;
    
    public static void resetTree()
    {
        _root = null;
    }
    
    public static OIDTreeNode getTree()
    {
        if(_root != null) return _root;
        OIDTreeNode node_SMARTHOUSE_0 = new OIDTreeNode("");
        node_SMARTHOUSE_0.setMibNodeName("SMARTHOUSE");
        OIDTreeNode node_iso_1 = (OIDTreeNode) node_SMARTHOUSE_0.addChild(".1");
        node_iso_1.setMibNodeName("Iso");
        OIDTreeNode node_org_2 = (OIDTreeNode) node_iso_1.addChild(".1.3");
        node_org_2.setMibNodeName("Org");
        OIDTreeNode node_dod_3 = (OIDTreeNode) node_org_2.addChild(".1.3.6");
        node_dod_3.setMibNodeName("Dod");
        OIDTreeNode node_internet_4 = (OIDTreeNode) node_dod_3.addChild(".1.3.6.1");
        node_internet_4.setMibNodeName("Internet");
        OIDTreeNode node_private_5 = (OIDTreeNode) node_internet_4.addChild(".1.3.6.1.4");
        node_private_5.setMibNodeName("Private");
        OIDTreeNode node_enterprises_6 = (OIDTreeNode) node_private_5.addChild(".1.3.6.1.4.1");
        node_enterprises_6.setMibNodeName("Enterprises");
        OIDTreeNode node_smartHouse_7 = (OIDTreeNode) node_enterprises_6.addChild(".1.3.6.1.4.1.7754");
        node_smartHouse_7.setMibNodeName("SmartHouse");
        node_smartHouse_7.setGroupNode(true);
        OIDTreeNode node_shSmokeDetected_8 = (OIDTreeNode) node_smartHouse_7.addChild(".1.3.6.1.4.1.7754.1.0");
        node_shSmokeDetected_8.setMibNodeName("ShSmokeDetected");
        node_shSmokeDetected_8.setScalarNode(true);
        node_shSmokeDetected_8.setRealSyntaxType( (byte) 2);
        node_shSmokeDetected_8.setObjectName("iReasoning:name=SmartHouseGroup,noPdu=true");
        node_shSmokeDetected_8.setAccess(2);
        OIDTreeNode node_shIsOnTheFloor_9 = (OIDTreeNode) node_smartHouse_7.addChild(".1.3.6.1.4.1.7754.2.0");
        node_shIsOnTheFloor_9.setMibNodeName("ShIsOnTheFloor");
        node_shIsOnTheFloor_9.setScalarNode(true);
        node_shIsOnTheFloor_9.setRealSyntaxType( (byte) 2);
        node_shIsOnTheFloor_9.setObjectName("iReasoning:name=SmartHouseGroup,noPdu=true");
        node_shIsOnTheFloor_9.setAccess(2);
        OIDTreeNode node_shAirCondTemperature_10 = (OIDTreeNode) node_smartHouse_7.addChild(".1.3.6.1.4.1.7754.3.0");
        node_shAirCondTemperature_10.setMibNodeName("ShAirCondTemperature");
        node_shAirCondTemperature_10.setScalarNode(true);
        node_shAirCondTemperature_10.setRealSyntaxType( (byte) 2);
        node_shAirCondTemperature_10.setObjectName("iReasoning:name=SmartHouseGroup,noPdu=true");
        node_shAirCondTemperature_10.setAccess(3);
        OIDTreeNode node_shFridgeTemperature_11 = (OIDTreeNode) node_smartHouse_7.addChild(".1.3.6.1.4.1.7754.4.0");
        node_shFridgeTemperature_11.setMibNodeName("ShFridgeTemperature");
        node_shFridgeTemperature_11.setScalarNode(true);
        node_shFridgeTemperature_11.setRealSyntaxType( (byte) 2);
        node_shFridgeTemperature_11.setObjectName("iReasoning:name=SmartHouseGroup,noPdu=true");
        node_shFridgeTemperature_11.setAccess(3);
        OIDTreeNode node_shCurrentLocation_12 = (OIDTreeNode) node_smartHouse_7.addChild(".1.3.6.1.4.1.7754.5.0");
        node_shCurrentLocation_12.setMibNodeName("ShCurrentLocation");
        node_shCurrentLocation_12.setScalarNode(true);
        node_shCurrentLocation_12.setRealSyntaxType( (byte) 1);
        node_shCurrentLocation_12.setObjectName("iReasoning:name=SmartHouseGroup,noPdu=true");
        node_shCurrentLocation_12.setAccess(2);
        OIDTreeNode node_shAirCondStatus_13 = (OIDTreeNode) node_smartHouse_7.addChild(".1.3.6.1.4.1.7754.6.0");
        node_shAirCondStatus_13.setMibNodeName("ShAirCondStatus");
        node_shAirCondStatus_13.setScalarNode(true);
        node_shAirCondStatus_13.setRealSyntaxType( (byte) 2);
        node_shAirCondStatus_13.setObjectName("iReasoning:name=SmartHouseGroup,noPdu=true");
        node_shAirCondStatus_13.setAccess(2);
        OIDTreeNode node_shFridgeProdTable_14 = addShFridgeProdTable((OIDTreeNode) node_smartHouse_7);
        _root = node_SMARTHOUSE_0 ;
        return node_SMARTHOUSE_0;
    }
    
    private static OIDTreeNode addShFridgeProdTable(OIDTreeNode parentNode)
    {
        OIDTreeNode node_shFridgeProdTable_14 = (OIDTreeNode) parentNode.addChild(".1.3.6.1.4.1.7754.7");
        node_shFridgeProdTable_14.setMibNodeName("ShFridgeProdTable");
        node_shFridgeProdTable_14.setObjectName("iReasoning:name=ShFridgeProdTable,noPdu=true");
        node_shFridgeProdTable_14.setTableNode(true);
        OIDTreeNode node_shFridgeProdEntry_15 = (OIDTreeNode) node_shFridgeProdTable_14.addChild(".1.3.6.1.4.1.7754.7.1");
        node_shFridgeProdEntry_15.setMibNodeName("ShFridgeProdEntry");
        node_shFridgeProdEntry_15.setIndice(new String[]{"shFridgeProdTableProdId"});
        
        OIDTreeNode node_shFridgeProdTableProdId_16 = (OIDTreeNode) node_shFridgeProdEntry_15.addChild(".1.3.6.1.4.1.7754.7.1.1");
        node_shFridgeProdTableProdId_16.setMibNodeName("ShFridgeProdTableProdId");
        node_shFridgeProdTableProdId_16.setTableColumnNode(true);
        node_shFridgeProdTableProdId_16.setRealSyntaxType( (byte) 2);
        node_shFridgeProdTableProdId_16.setIndexNode(true);
        node_shFridgeProdTableProdId_16.setAccess(2);
        OIDTreeNode node_shFridgeProdTableProdName_17 = (OIDTreeNode) node_shFridgeProdEntry_15.addChild(".1.3.6.1.4.1.7754.7.1.2");
        node_shFridgeProdTableProdName_17.setMibNodeName("ShFridgeProdTableProdName");
        node_shFridgeProdTableProdName_17.setTableColumnNode(true);
        node_shFridgeProdTableProdName_17.setRealSyntaxType( (byte) 1);
        node_shFridgeProdTableProdName_17.setAccess(2);
        OIDTreeNode node_shFridgeProdTableProdExpDate_18 = (OIDTreeNode) node_shFridgeProdEntry_15.addChild(".1.3.6.1.4.1.7754.7.1.3");
        node_shFridgeProdTableProdExpDate_18.setMibNodeName("ShFridgeProdTableProdExpDate");
        node_shFridgeProdTableProdExpDate_18.setTableColumnNode(true);
        node_shFridgeProdTableProdExpDate_18.setRealSyntaxType( (byte) 1);
        node_shFridgeProdTableProdExpDate_18.setAccess(2);
        
        return node_shFridgeProdTable_14;
    }
    
    public static final String ORG = ".1.3";
    public static final String SHISONTHEFLOOR = ".1.3.6.1.4.1.7754.2.0";
    public static final String SHSMOKEDETECTED = ".1.3.6.1.4.1.7754.1.0";
    public static final String SHFRIDGEPRODENTRY = ".1.3.6.1.4.1.7754.7.1";
    public static final String SHFRIDGETEMPERATURE = ".1.3.6.1.4.1.7754.4.0";
    public static final String PRIVATE = ".1.3.6.1.4";
    public static final String SHFRIDGEPRODTABLEPRODNAME = ".1.3.6.1.4.1.7754.7.1.2";
    public static final String SHFRIDGEPRODTABLEPRODID = ".1.3.6.1.4.1.7754.7.1.1";
    public static final String ENTERPRISES = ".1.3.6.1.4.1";
    public static final String SHFRIDGEPRODTABLEPRODEXPDATE = ".1.3.6.1.4.1.7754.7.1.3";
    public static final String SHCURRENTLOCATION = ".1.3.6.1.4.1.7754.5.0";
    public static final String ISO = ".1";
    public static final String INTERNET = ".1.3.6.1";
    public static final String SHAIRCONDSTATUS = ".1.3.6.1.4.1.7754.6.0";
    public static final String SHAIRCONDTEMPERATURE = ".1.3.6.1.4.1.7754.3.0";
    public static final String DOD = ".1.3.6";
    public static final String SMARTHOUSE = ".1.3.6.1.4.1.7754";
    public static final String SHFRIDGEPRODTABLE = ".1.3.6.1.4.1.7754.7";
}
