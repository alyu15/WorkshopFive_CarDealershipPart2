package com.ps;

import java.io.*;

public class DealershipFileManager {

    public static Dealership getDealership() {

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("DB_Dealership.csv"));

            String[] dealershipData = buffReader.readLine().split("\\|");
            String dealershipName = dealershipData[0];
            String dealershipAddress = dealershipData[1];
            String dealershipPhone = dealershipData[2];

            Dealership dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhone);

            String vehicleData;
            while((vehicleData = buffReader.readLine()) != null) {
                String[] splitFile = vehicleData.split("\\|");
                int vin = Integer.parseInt(splitFile[0]);
                int year = Integer.parseInt(splitFile[1]);
                String make = splitFile[2];
                String model = splitFile[3];
                String vehicleType = splitFile[4];
                String color = splitFile[5];
                int odometer = Integer.parseInt(splitFile[6]);
                double price = Double.parseDouble(splitFile[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);
            }
            buffReader.close();
            return dealership;

        } catch (IOException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
            return null;
        }
    }

    public static void saveDealership(Dealership dealership) {

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("DB_Dealership.csv"));

            String dealershipName = dealership.getName();
            String dealershipAddress = dealership.getAddress();
            String dealershipPhone = dealership.getPhone();

            String dealershipData = String.format("%s|%s|%s\n",
                    dealershipName,
                    dealershipAddress,
                    dealershipPhone
            );

            buffWriter.write(dealershipData);

            for(Vehicle vehicle: dealership.getAllVehicles()) {
                int vehicleVin = vehicle.getVin();
                int vehicleYear = vehicle.getYear();
                String vehicleMake = vehicle.getMake();
                String vehicleModel = vehicle.getModel();
                String vehicleType = vehicle.getVehicleType();
                String vehicleColor = vehicle.getColor();
                int vehicleOdometer = vehicle.getOdometer();
                double vehiclePrice = vehicle.getPrice();

                String vehicleData = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        vehicleVin, vehicleYear, vehicleMake, vehicleModel,
                        vehicleType, vehicleColor, vehicleOdometer, vehiclePrice
                );
                buffWriter.write(vehicleData);
            }
            buffWriter.close();

        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
