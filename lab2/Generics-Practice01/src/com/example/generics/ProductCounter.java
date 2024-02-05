package com.example.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

    public class ProductCounter {

        private Map<String, Long> productCountMap = new HashMap<>();
        private Map<String, String> productNames = new TreeMap<>();

        public ProductCounter(Map productNames) {
            this.productNames = productNames;
        }

        public void processList(String[] list) {
            long curVal = 0;
            for(String itemNumber:list){
                if (productCountMap.containsKey(itemNumber)){
                    curVal = productCountMap.get(itemNumber);
                    curVal++;
                    productCountMap.put(itemNumber, new Long(curVal));
                }else{
                    productCountMap.put(itemNumber, new Long(1));
                }
            }
        }

        public void printReport() {
        System.out.println("=== Product Report ===");
        for (String key : productNames.keySet()) {
            System.out.println("Name: " + key);
            System.out.println("\t\tCount: " + productCountMap.get(productNames.get(key)));
        }
    }

    public static void main(String[] args) {
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug", "1M02");

        String[] parts = {"1S01", "1S02", "1H01", "1M02", "1S01", "1H01", 
                          "1S02", "1S01", "1S01", "1S01", "1S01", "1S01", 
                          "1S02", "1S02", "1S02", "1S02", "1H01", "1H01",
                          "1H01", "1M02", "1M02"};

        ProductCounter pc1 = new ProductCounter(productNames);
        pc1.processList(parts);
        pc1.printReport();
    }
    }