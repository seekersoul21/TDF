package com.tdf.service;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        Map<String,Map<String, Set<String>>> accountAddressMapping=new HashMap<>();
        List<Map<String, String>> caisHolderAddressDetails = new ArrayList<>();

        List<String> addressList=new ArrayList<>();
        // First address entry
        Map<String, String> addressMap1 = new HashMap<>();
        addressMap1.put("First_Line_Of_Address_non_normalized", "B'HOUSE NO 1525 JAMLAPUR' B'BHIWANI BHIW");
        addressMap1.put("Second_Line_Of_Address_non_normalized", "ANI HR 127035' B''");
        addressMap1.put("Third_Line_Of_Address_non_normalized", "");
        addressMap1.put("City_non_normalized", "");
        addressMap1.put("Fifth_Line_Of_Address_non_normalized", "");
        addressMap1.put("State_non_normalized", "06");
        addressMap1.put("ZIP_Postal_Code_non_normalized", "127035");
        addressMap1.put("CountryCode_non_normalized", "IB");
        addressMap1.put("Address_indicator_non_normalized", "01");
        addressMap1.put("Residence_code_non_normalized", "");

        // Second address entry
        Map<String, String> addressMap2 = new HashMap<>();
        addressMap2.put("First_Line_Of_Address_non_normalized", "HOUSE NO 1525 JAMLAPUR BHIWANI BHIWANI H");
        addressMap2.put("Second_Line_Of_Address_non_normalized", "R 127035");
        addressMap2.put("Third_Line_Of_Address_non_normalized", "");
        addressMap2.put("City_non_normalized", "");
        addressMap2.put("Fifth_Line_Of_Address_non_normalized", "");
        addressMap2.put("State_non_normalized", "06");
        addressMap2.put("ZIP_Postal_Code_non_normalized", "127035");
        addressMap2.put("CountryCode_non_normalized", "IB");
        addressMap2.put("Address_indicator_non_normalized", "01");
        addressMap2.put("Residence_code_non_normalized", "");

        // Adding both addresses to addressDetails
        caisHolderAddressDetails.add(addressMap1);
        caisHolderAddressDetails.add(addressMap2);



        Map<String,Set<String>> addressTypeMap=new HashMap<>();
        for(Map<String,String> currentAddress:caisHolderAddressDetails){

            String firstLine = Objects.requireNonNullElse(currentAddress.get("First_Line_Of_Address_non_normalized"), "");
            String secondLine = Objects.requireNonNullElse(currentAddress.get("Second_Line_Of_Address_non_normalized"), "");
            String thirdLine = Objects.requireNonNullElse(currentAddress.get("Third_Line_Of_Address_non_normalized"), "");
            String city = Objects.requireNonNullElse(currentAddress.get("City_non_normalized"), "");
            String stateCode = Objects.requireNonNullElse(currentAddress.get("State_non_normalized"), "");
            String pinCode = Objects.requireNonNullElse(currentAddress.get("ZIP_Postal_Code_non_normalized"), "");
            String addressType = Objects.requireNonNullElse(currentAddress.get("Address_indicator_non_normalized"), "Unknown");
            String fullAddress = firstLine + " " + secondLine + " " + thirdLine + " " + city + " "
                    +stateCode + " " + pinCode;

            addressTypeMap.computeIfAbsent(addressType, k -> new HashSet<>()).add(fullAddress);
        }
        int index =0;
        accountAddressMapping.put(String.valueOf(index),addressTypeMap);
        index++;


    }
}
