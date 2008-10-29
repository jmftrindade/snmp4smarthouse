
    /**
     * WSSmartHouseWSSmartHouseHttpportCallbackHandler.java
     *
     * This file was auto-generated from WSDL
     * by the Apache Axis2 version: 1.2 Apr 27, 2007 (04:35:37 IST)
     */
    package br.ufrgs.inf.gar.smarthouse.clients;

    /**
     *  WSSmartHouseWSSmartHouseHttpportCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WSSmartHouseHttpportCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WSSmartHouseHttpportCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WSSmartHouseHttpportCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getShFridgeTemperature method
            * override this method for handling normal response from getShFridgeTemperature operation
            */
           public void receiveResultgetShFridgeTemperature(
                    br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShFridgeTemperatureResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getShFridgeTemperature operation
           */
            public void receiveErrorgetShFridgeTemperature(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getShSmokeDetected method
            * override this method for handling normal response from getShSmokeDetected operation
            */
           public void receiveResultgetShSmokeDetected(
                    br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShSmokeDetectedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getShSmokeDetected operation
           */
            public void receiveErrorgetShSmokeDetected(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getShIsOnTheFloor method
            * override this method for handling normal response from getShIsOnTheFloor operation
            */
           public void receiveResultgetShIsOnTheFloor(
                    br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShIsOnTheFloorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getShIsOnTheFloor operation
           */
            public void receiveErrorgetShIsOnTheFloor(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getShAirCondTemperature method
            * override this method for handling normal response from getShAirCondTemperature operation
            */
           public void receiveResultgetShAirCondTemperature(
                    br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShAirCondTemperatureResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getShAirCondTemperature operation
           */
            public void receiveErrorgetShAirCondTemperature(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getShFridgeProdTable method
            * override this method for handling normal response from getShFridgeProdTable operation
            */
           public void receiveResultgetShFridgeProdTable(
                    br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShFridgeProdTableResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getShFridgeProdTable operation
           */
            public void receiveErrorgetShFridgeProdTable(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getShAirCondStatus method
            * override this method for handling normal response from getShAirCondStatus operation
            */
           public void receiveResultgetShAirCondStatus(
                    br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShAirCondStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getShAirCondStatus operation
           */
            public void receiveErrorgetShAirCondStatus(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getShCurrentLocation method
            * override this method for handling normal response from getShCurrentLocation operation
            */
           public void receiveResultgetShCurrentLocation(
                    br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShCurrentLocationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getShCurrentLocation operation
           */
            public void receiveErrorgetShCurrentLocation(java.lang.Exception e) {
            }
                


    }
    