package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public static void saveContract(Contract contract){

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Contracts.csv",true));

            if(contract instanceof SalesContract) {
            // SALE|phone number|Name|email|vin|year|make|model|type|color|mileage|price|
                // sales tax price|recording fee|processing fee|total price|monthly payments y/n|monthly payment amount



            } else {
            // LEASE|phone number|Name|email|vin|year|make|model|type|color|mileage|price|
                // ending value|lease fee|total price|monthly payment
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
