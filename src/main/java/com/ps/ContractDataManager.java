package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public static void saveContract(Contract contract, Vehicle vehicle, SalesContract salesContract, LeaseContract leaseContract){

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Contracts.csv",true));

            if(contract instanceof SalesContract) {
            // SALE|date|Name|email|vin|year|make|model|type|color|mileage|price|
                // sales tax price|recording fee|processing fee|total price|monthly payments y/n|monthly payment amount

                String dateOfContract = contract.getDateOfContract();
                String customerName = contract.getCustomerName();
                String customerEmail = contract.getCustomerEmail();
                int vehicleVin = vehicle.getVin();
                int vehicleYear = vehicle.getYear();
                String vehicleMake = vehicle.getMake();
                String vehicleModel = vehicle.getModel();
                String vehicleType = vehicle.getVehicleType();
                String vehicleColor = vehicle.getColor();
                int vehicleMileage = vehicle.getOdometer();
                double vehiclePrice = vehicle.getPrice();

                double taxAmount = salesContract.getSalesTaxAmount();
                int recordingFee = salesContract.getRecordingFee();
                int processingFee = salesContract.getProcessingFee();
                double totalPrice = salesContract.getTotalPrice();
                boolean financing = salesContract.isFinanceChoice();
                double monthlyPayment = salesContract.getMonthlyPayment();


                String soldVehicle = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%d|%d|%.2f|%b|%.2f\n",
                        dateOfContract, customerName, customerEmail, vehicleVin, vehicleYear,
                        vehicleMake, vehicleModel, vehicleType, vehicleColor,
                        vehicleMileage, vehiclePrice,
                        taxAmount, recordingFee, processingFee, totalPrice, financing, monthlyPayment
                );
                buffWriter.write(soldVehicle);

            } else {
            // LEASE|date|Name|email|vin|year|make|model|type|color|mileage|price|
                // ending value|lease fee|total price|monthly payment

                String dateOfContract = contract.getDateOfContract();
                String customerName = contract.getCustomerName();
                String customerEmail = contract.getCustomerEmail();
                int vehicleVin = vehicle.getVin();
                int vehicleYear = vehicle.getYear();
                String vehicleMake = vehicle.getMake();
                String vehicleModel = vehicle.getModel();
                String vehicleType = vehicle.getVehicleType();
                String vehicleColor = vehicle.getColor();
                int vehicleMileage = vehicle.getOdometer();
                double vehiclePrice = vehicle.getPrice();

                double expectedValue = leaseContract.getExpectedEndingValue();
                double leaseFee = leaseContract.getLeaseFee();
                double totalPrice = leaseContract.getTotalPrice();
                double monthlyPayment = leaseContract.getMonthlyPayment();

                String leasedVehicle = String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f\n",
                        dateOfContract, customerName, customerEmail, vehicleVin, vehicleYear,
                        vehicleMake, vehicleModel, vehicleType, vehicleColor,
                        vehicleMileage, vehiclePrice,
                        expectedValue, leaseFee, totalPrice, monthlyPayment
                );
                buffWriter.write(leasedVehicle);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
