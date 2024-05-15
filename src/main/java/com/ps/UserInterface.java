package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    static Scanner scanner = new Scanner(System.in);
    private static Dealership dealership;

    private static void init(){

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }

    public static void display(){

        init();

        System.out.println("\n********************** Welcome to the World Famous Car Dealership Application! **********************");
        System.out.println("                                   --  How may we help you?  --");
        System.out.println("*****************************************************************************************************");

        processMainMenu();
    }

    public static void processMainMenu() {

        String mainMenuInput;

        do {
            System.out.println("\n=====================================================================================================");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) View All Vehicles");
            System.out.println("~ (2) Browse Vehicles By Filter");
            System.out.println("~ (3) Manage Vehicles");
            System.out.println("~ (99) Exit");

            mainMenuInput = scanner.next();

            switch(mainMenuInput) {
                case "1":
                    processGetAllVehiclesRequest();
                    break;

                case "2":
                    processBrowseVehiclesByFilterRequest();
                    break;

                case "3":
                    processManagingVehiclesRequest();
                    break;

                case "99":
                    System.out.println("***************************************  Exiting program... ***************************************");
                    System.out.println("                                     --  Have a nice day!  --");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }

        } while (!mainMenuInput.equals("99"));
    }

    public static void processBrowseVehiclesByFilterRequest(){
        String subMenuInput;

        do{
            System.out.println("\n*****************************************************************************************************");
            System.out.println("=================================== Browse Vehicles By Filter =======================================\n");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) View Vehicles by Price");
            System.out.println("~ (2) View Vehicles by Make/Model");
            System.out.println("~ (3) View Vehicles by Year");
            System.out.println("~ (4) View Vehicles by Color");
            System.out.println("~ (5) View Vehicles by Mileage");
            System.out.println("~ (6) View Vehicles by Type");
            System.out.println("~ (0) Return to HOME menu");

            subMenuInput = scanner.next().trim();

            switch(subMenuInput){
                case "1":
                    processGetByPriceRequest();
                    break;

                case "2":
                    processGetByMakeModelRequest();
                    break;

                case "3":
                    processGetByYearRequest();
                    break;

                case "4":
                    processGetByColorRequest();
                    break;

                case "5":
                    processGetByMileageRequest();
                    break;

                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "0":
                    System.out.println("*****************************************************************************************************");
                    System.out.println("========================================  Welcome Back!  ============================================");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }
        } while (!subMenuInput.equals("0"));
    }

    public static void processManagingVehiclesRequest() {

        String managingVehiclesInput;

        do {
            System.out.println("\n*****************************************************************************************************");
            System.out.println("=======================================  Manage Vehicles  ===========================================\n");
            System.out.println("* Please select one of the following options:\n");
            System.out.println("~ (1) Add a Vehicle");
            System.out.println("~ (2) Remove a Vehicle");
            System.out.println("~ (3) Sell/Lease a Vehicle");
            System.out.println("~ (0) Return to HOME menu");

            managingVehiclesInput = scanner.next().trim();

            switch (managingVehiclesInput) {
                case "1":
                    processAddVehicleRequest();
                    break;

                case "2":
                    processRemoveVehicleRequest();
                    break;

                case "3":
                    processSalesAndLeaseRequest();
                    break;

                case "0":
                    System.out.println("*****************************************************************************************************");
                    System.out.println("========================================  Welcome Back!  ============================================");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }

        } while (!managingVehiclesInput.equals("0"));

    }

    private static void displayVehicles(ArrayList<Vehicle> vehicles) {
        for(Vehicle vehicle: vehicles) {
            System.out.printf("~ VIN: %d    Year: %d    %-8s %-10s   %-6s   %-8s  Mileage: %d   $%.2f\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );
        }
        if(vehicles.isEmpty()) {
            System.out.println("\n       ******************************** No vehicle founds ********************************");
        }
    }

    public static void processGetByPriceRequest() {

        System.out.println("\n===================================== View Vehicles By Price ========================================");
        System.out.println("\n* Please enter in the minimum price of the vehicle you are searching for:");
        double minPrice;
        while(true) {
            if (scanner.hasNextDouble()) {
                minPrice = scanner.nextDouble();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("* Please enter in the maximum price of the vehicle you are searching for:");
        double maxPrice;
        while(true) {
            if (scanner.hasNextDouble()) {
                maxPrice = scanner.nextDouble();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("\n******************************************  Vehicles  ***********************************************");

        ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehiclesByPrice);
    }

    public static void processGetByMakeModelRequest() {

        System.out.println("\n================================== View Vehicles By Make/Model ======================================");
        System.out.println("\n* Please enter in the make of the vehicle you are searching for:");
        String make;
        while (true) {
            make = scanner.next().trim();
            if (make.matches(".*\\d.*") || make.isEmpty()) {
                System.out.println("* Please enter in a vehicle make.");
            } else {
                break;
            }
        }

        System.out.println("* Please enter in the model of the vehicle you are searching for:");
        String model;
        while (true) {
            model = scanner.next().trim();
            if (model.matches(".*\\d.*") || model.isEmpty()) {
                System.out.println("* Please enter in a vehicle model.");
            } else {
                break;
            }
        }

        System.out.println("\n******************************************  Vehicles  ***********************************************");

        ArrayList<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehiclesByMakeModel);

    }

    public static void processGetByYearRequest() {

        System.out.println("\n===================================== View Vehicles By Year =========================================");
        System.out.println("\n* Please enter in the minimum year of the vehicle you are searching for:");
        int minYear;
        while(true) {
            if (scanner.hasNextInt()) {
                minYear = scanner.nextInt();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("* Please enter in the maximum year of the vehicle you are searching for:");
        int maxYear;
        while(true) {
            if (scanner.hasNextInt()) {
                maxYear = scanner.nextInt();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("\n******************************************  Vehicles  ***********************************************");

        ArrayList<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehiclesByYear);
    }

    public static void processGetByColorRequest() {

        System.out.println("\n==================================== View Vehicles By Color =========================================");
        System.out.println("* Please enter in the color of the vehicle you are searching for:");
        String color;
        while (true) {
            color = scanner.next().trim();
            if (color.matches(".*\\d.*") || color.isEmpty()) {
                System.out.println("* Please enter in a color.");
            } else {
                break;
            }
        }

        System.out.println("\n******************************************  Vehicles  ***********************************************");

        ArrayList<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
        displayVehicles(vehiclesByColor);
    }

    public static void processGetByMileageRequest() {

        System.out.println("\n==================================== View Vehicles By Mileage =======================================");
        System.out.println("\n* Please enter in the minimum mileage of the vehicle you are searching for:");
        int minMileage;
        while(true) {
            if (scanner.hasNextInt()) {
                minMileage = scanner.nextInt();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("* Please enter in the maximum mileage of the vehicle you are searching for:");
        int maxMileage;
        while(true) {
            if (scanner.hasNextInt()) {
                maxMileage = scanner.nextInt();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("\n******************************************  Vehicles  ***********************************************");

        ArrayList<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehiclesByMileage);
    }

    public static void processGetByVehicleTypeRequest() {

        System.out.println("\n================================== View Vehicles By Vehicle Type ====================================");
        System.out.println("\n* Please enter in the type of vehicle you are searching for:");
        String vehicleType;
        while (true) {
            vehicleType = scanner.next().trim();
            if (vehicleType.matches(".*\\d.*") || vehicleType.isEmpty()) {
                System.out.println("* Please enter in a vehicle type.");
            } else {
                break;
            }
        }

        System.out.println("\n******************************************  Vehicles  ***********************************************");

        ArrayList<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehiclesByType);
    }

    public static void processGetAllVehiclesRequest() {

        System.out.println("\n======================================= View All Vehicles ===========================================");
        System.out.println("\n******************************************  Vehicles  ***********************************************");

        displayVehicles(dealership.getAllVehicles());
    }

    public static void processAddVehicleRequest() {

        System.out.println("\n====================================== Add a Vehicle ======================================");

        System.out.println("\n* Please enter in the VIN of the vehicle:");
        int newVehicleVin;
        while(true) {
            if (scanner.hasNextInt()) {
                newVehicleVin = scanner.nextInt();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("* Please enter in the Year of the vehicle:");
        int newVehicleYear;
        while(true) {
            if (scanner.hasNextInt()) {
                newVehicleYear = scanner.nextInt();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("* Please enter in the Make of the vehicle:");
        String newVehicleMake;
        while (true) {
            newVehicleMake = scanner.next().trim();
            if (newVehicleMake.matches(".*\\d.*") || newVehicleMake.isEmpty()) {
                System.out.println("* Please enter in a vehicle make.");
            } else {
                break;
            }
        }

        String newVehicleMakeEntry = newVehicleMake.substring(0, 1).toUpperCase() + newVehicleMake.substring(1);

        System.out.println("* Please enter in the Model of the vehicle:");
        String newVehicleModel;
        while (true) {
            newVehicleModel = scanner.next().trim();
            if (newVehicleModel.matches(".*\\d.*") || newVehicleModel.isEmpty()) {
                System.out.println("* Please enter in a vehicle model.");
            } else {
                break;
            }
        }
        String newVehicleModelEntry = newVehicleModel.substring(0,1).toUpperCase() + newVehicleModel.substring(1);

        System.out.println("* Please enter in the Type of the vehicle:");
        String newVehicleType;
        while (true) {
            newVehicleType = scanner.next().trim();
            if (newVehicleType.matches(".*\\d.*") || newVehicleType.isEmpty()) {
                System.out.println("* Please enter in a vehicle type");
            } else {
                break;
            }
        }
        String newVehicleTypeEntry = newVehicleType.substring(0,1).toUpperCase() + newVehicleType.substring(1);

        System.out.println("* Please enter in the Color of the vehicle:");
        String newVehicleColor;
        while (true) {
            newVehicleColor = scanner.next().trim();
            if (newVehicleColor.matches(".*\\d.*") || newVehicleColor.isEmpty()) {
                System.out.println("* Please enter in a color.");
            } else {
                break;
            }
        }
        String newVehicleColorEntry = newVehicleColor.substring(0,1).toUpperCase() + newVehicleColor.substring(1);

        System.out.println("* Please enter in the Mileage of the vehicle:");
        int newVehicleMileage;
        while(true) {
            if (scanner.hasNextInt()) {
                newVehicleMileage = scanner.nextInt();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        System.out.println("* Please enter in the Price of the vehicle:");
        double newVehiclePrice;
        while(true) {
            if (scanner.hasNextDouble()) {
                newVehiclePrice = scanner.nextDouble();
                break;
            } else {
                System.out.println("* Please enter in a number.");
                scanner.next();
            }
        }

        Vehicle newVehicle = new Vehicle(newVehicleVin, newVehicleYear, newVehicleMakeEntry, newVehicleModelEntry,
                newVehicleTypeEntry, newVehicleColorEntry, newVehicleMileage, newVehiclePrice);

        dealership.addVehicle(newVehicle);

        DealershipFileManager.saveDealership(dealership);
        System.out.println("\n*************************** You have successfully added a new vehicle! ******************************");
    }

    public static void processRemoveVehicleRequest() {

        System.out.println("\n====================================== Remove a Vehicle ============================================");
        System.out.println("* Please enter the VIN of the vehicle you would like to remove:");
        int removeVehicleVin;
        while (true) {
            if (scanner.hasNextInt()) {
                removeVehicleVin = scanner.nextInt();
                break;
            } else {
                System.out.println("Please enter a number.");
                scanner.next();
            }
        }

        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == removeVehicleVin) {
                vehicleToRemove = vehicle;
                break;
            }
        }
        if (vehicleToRemove == null) {
            System.out.println("     ************************ No vehicle found with the provided VIN **************************");
            return;
        }
        dealership.removeVehicle(vehicleToRemove);
        DealershipFileManager.saveDealership(dealership);

        System.out.println("\n         ************************ Vehicle successfully removed! ******************************");
    }

    public static void processSalesAndLeaseRequest() {

    }

}

