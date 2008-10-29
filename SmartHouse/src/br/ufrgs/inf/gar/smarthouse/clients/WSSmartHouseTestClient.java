/*
 * Copyright 2008 Universidade Federal do Rio Grande do Sul
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.ufrgs.inf.gar.smarthouse.clients;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.ufrgs.inf.gar.smarthouse.clients.WSSmartHouseHttpportStub.GetShAirCondTemperatureResponse;

/**
 * SmartHouse web service client. 
 *
 * @version 0.1 28/10/2008
 * @author Joana Trindade (jmftrindade@gmail.com)
 * @author Flavio Brun (fkbrun@gmail.com)
 */
public class WSSmartHouseTestClient {

    public static void main(String args[]) {
        try {
            WSSmartHouseHttpportStub stub = new WSSmartHouseHttpportStub("http://localhost:8080/axis2/services/WSSmartHouse");
            GetShAirCondTemperatureResponse airCondTemperatureResponse = stub.getShAirCondTemperature();
            System.out.println("airCondTemperature: " + airCondTemperatureResponse.get_return());
  
            System.out.println("currentLocation: " + stub.getShCurrentLocation().get_return());
            System.out.println("airCondStatus: " + stub.getShAirCondStatus().get_return());
            
            
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
}
