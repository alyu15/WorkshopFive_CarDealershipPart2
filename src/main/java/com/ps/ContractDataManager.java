package com.ps;

import java.io.*;

public class ContractDataManager {

    public void saveContract(Contract contract){

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Contracts.csv",true));

            if(contract instanceof SalesContract) {

                Vehicle vehicle = contract.getVehicleSold();

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

                double taxAmount = ((SalesContract) contract).getSalesTaxAmount();
                int recordingFee = ((SalesContract) contract).getRecordingFee();
                int processingFee = ((SalesContract) contract).getProcessingFee();
                double totalPrice = contract.getTotalPrice();
                boolean financing = ((SalesContract) contract).isFinanceChoice();
                String financeChoice = financing ? "YES" : "NO";
                double monthlyPayment = contract.getMonthlyPayment();


                String soldVehicle = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%d|%d|%.2f|%s|%.2f\n",
                        dateOfContract, customerName, customerEmail, vehicleVin, vehicleYear,
                        vehicleMake, vehicleModel, vehicleType, vehicleColor,
                        vehicleMileage, vehiclePrice,
                        taxAmount, recordingFee, processingFee, totalPrice, financeChoice, monthlyPayment
                );
                buffWriter.write(soldVehicle);
            }
            if(contract instanceof LeaseContract){

                Vehicle vehicle = contract.getVehicleSold();

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

                double expectedValue = ((LeaseContract) contract).getExpectedEndingValue();
                double leaseFee = ((LeaseContract) contract).getLeaseFee();
                double totalPrice = contract.getTotalPrice();
                double monthlyPayment = contract.getMonthlyPayment();

                String leasedVehicle = String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f\n",
                        dateOfContract, customerName, customerEmail, vehicleVin, vehicleYear,
                        vehicleMake, vehicleModel, vehicleType, vehicleColor,
                        vehicleMileage, vehiclePrice,
                        expectedValue, leaseFee, totalPrice, monthlyPayment
                );
                buffWriter.write(leasedVehicle);
            }
            buffWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
