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
package br.ufrgs.inf.gar.smarthouse.webservices;

import java.util.Random;

/**
 * SmartHouse web service. 
 *
 * @version 0.1 28/10/2008
 * @author Joana Trindade (jmftrindade@gmail.com)
 * @author Flavio Brun (fkbrun@gmail.com)
 */
public class WSSmartHouse {
    
    /** 
     * Boolean whether smoke has been detected or not.
     * true = 1, false = 2 
     */
    private int shSmokeDetected = 2;
    
    /** 
     * Boolean whether the elder person is on the floor 
     * (e.g., elderly person has fainted and needs medical 
     * assistance). true = 1, false = 2 
     */
    private int shIsOnTheFloor = 2;
    
    /** 
     * Current air conditioner temperature in the smart house, 
     * in Celsius degrees. Allowed range is 15 to 30 degrees.
     */    
    private int shAirCondTemperature = 20;
    
    /** 
     * Air conditioner status. Off (1) or On (2).
     */    
    private int shAirCondStatus = 2;
    
    /** 
     * Current fridge temperature in the smart house, in Celsius 
     * degrees. Allowed range is -20 to 0 degrees.
     */    
    private int shFridgeTemperature = -10;
    
    /**
     * Table containing current products stored in the fridge.
     */        
    private ProductEntry[] shFridgeProdTable = {
            new ProductEntry(1, "leite", "31-10-2008"),
            new ProductEntry(2, "ovos", "15-11-2008"),
            new ProductEntry(3, "manteiga", "29-11-2008"),
            new ProductEntry(4, "queijo", "5-11-2008"),
            new ProductEntry(5, "presunto", "5-11-2008"),
            new ProductEntry(6, "iogurte", "10-11-2008"),
            new ProductEntry(7, "molho_tomate", "7-11-2008"),
            new ProductEntry(8, "suco_laranja", "5-11-2008")
    };
    
    public int getShIsOnTheFloor() {
        return shIsOnTheFloor;
    }

    public int getShAirCondTemperature() {
        return shAirCondTemperature;
    }

    public void setShAirCondTemperature(int shAirCondTemperature) {
        this.shAirCondTemperature = shAirCondTemperature;
    }

    public int getShAirCondStatus() {
        return shAirCondStatus;
    }

    public int getShFridgeTemperature() {
        return shFridgeTemperature;
    }

    public void setShFridgeTemperature(int shFridgeTemperature) {
        this.shFridgeTemperature = shFridgeTemperature;
    }

    /**
     * Current location of the elder person in the smart house. 
     * Format is -XX:-YY, where XX represents latitude and YY 
     * represents longitude.
     */ 
    public String getShCurrentLocation() {
        Random generator = new Random();
        String location = Integer.toString(generator.nextInt(3) + 15) + ":" + 
            Integer.toString(generator.nextInt(3) + 15);
        return location;
    }

    public int getShSmokeDetected() {
        return this.shSmokeDetected;
    }

    public ProductEntry[] getShFridgeProdTable() {
        return this.shFridgeProdTable;
    }

    public class ProductEntry {
        public int _shFridgeProdTableProdId = 0;
        public String _shFridgeProdTableProdName = "";
        public String _shFridgeProdTableProdExpDate = "";
        
        public ProductEntry(int prodId, String prodName, String prodExpDate) {
            this._shFridgeProdTableProdId = prodId;
            this._shFridgeProdTableProdName = prodName;
            this._shFridgeProdTableProdExpDate = prodExpDate;
        }
    }
    
}
