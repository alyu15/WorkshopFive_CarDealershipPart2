package com.ps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private static Scanner scanner = new Scanner(System.in);
    private static Dealership dealership;

    private static void init(){
        dealership = DealershipFileManager.getDealership();
    }

    public static void display(){

        init();

        System.out.println("\n************************** Welcome to the World Famous Car Dealership Application! **************************");
        System.out.println("                                       --  How may we help you?  --");
        System.out.println("*************************************************************************************************************");

        processMainMenu();
    }

    private static void processMainMenu() {

        String mainMenuInput;

        do {
            System.out.println("\n=============================================================================================================");
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
                    System.out.println("********************************************  Exiting program... ********************************************");
                    System.out.println("                                          --  Have a nice day!  --");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }

        } while (!mainMenuInput.equals("99"));
    }

    private static void processBrowseVehiclesByFilterRequest(){
        String subMenuInput;

        do{
            System.out.println("\n*************************************************************************************************************");
            System.out.println("======================================= Browse Vehicles By Filter ===========================================\n");
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
                    System.out.println("*************************************************************************************************************");
                    System.out.println("============================================  Welcome Back!  ================================================");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }
        } while (!subMenuInput.equals("0"));
    }

    private static void processManagingVehiclesRequest() {

        String managingVehiclesInput;

        do {
            System.out.println("\n*************************************************************************************************************");
            System.out.println("===========================================  Manage Vehicles  ===============================================\n");
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
                    System.out.println("*************************************************************************************************************");
                    System.out.println("============================================  Welcome Back!  ================================================");
                    break;

                default:
                    System.out.println("********************* Command not found *********************");
                    System.out.println("                    -- Please try again --");
                    break;
            }

        } while (!managingVehiclesInput.equals("0"));

    }

    private static void displayVehicles(ArrayList<Vehicle> vehicles) {

        System.out.println("\n**********************************************  Vehicles  ***************************************************");

            for(Vehicle vehicle: vehicles) {
                System.out.printf("~ VIN: %d    Year: %d    %-14s %-14s   %-6s   %-10s  Mileage: %d   $%.2f\n",
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
                System.out.println("\n           ******************************** No vehicle founds ********************************");
            }
    }

    private static void processGetByPriceRequest() {

        System.out.println("\n========================================= View Vehicles By Price ============================================");
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

        ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehiclesByPrice);
    }

    private static void processGetByMakeModelRequest() {

        System.out.println("\n====================================== View Vehicles By Make/Model ==========================================");
        System.out.println("\n* Please enter in the make of the vehicle you are searching for:");
            String make;
                while (true) {
                    make = scanner.next().trim();
                    if (make.isEmpty()) {
                        System.out.println("* Please enter in a vehicle make.");
                    } else {
                        break;
                    }
                }

        System.out.println("* Please enter in the model of the vehicle you are searching for:");
            String model;
                while (true) {
                    model = scanner.next().trim();
                    if (model.isEmpty()) {
                        System.out.println("* Please enter in a vehicle model.");
                    } else {
                        break;
                    }
                }

        ArrayList<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehiclesByMakeModel);

    }

    private static void processGetByYearRequest() {

        System.out.println("\n========================================= View Vehicles By Year =============================================");
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

        ArrayList<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehiclesByYear);
    }

    private static void processGetByColorRequest() {

        System.out.println("\n======================================== View Vehicles By Color =============================================");
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

        ArrayList<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
        displayVehicles(vehiclesByColor);
    }

    private static void processGetByMileageRequest() {

        System.out.println("\n======================================== View Vehicles By Mileage ===========================================");
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

        ArrayList<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehiclesByMileage);
    }

    private static void processGetByVehicleTypeRequest() {

        System.out.println("\n====================================== View Vehicles By Vehicle Type ========================================");
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

        ArrayList<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehiclesByType);
    }

    private static void processGetAllVehiclesRequest() {

        System.out.println("\n=========================================== View All Vehicles ===============================================");
        System.out.println("\n**********************************************  Vehicles  ***************************************************");

        displayVehicles(dealership.getAllVehicles());
    }

    private static void processAddVehicleRequest() {

        System.out.println("\n============================================== Add a Vehicle ==============================================");

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
                    if (newVehicleMake.isEmpty()) {
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
                    if (newVehicleModel.isEmpty()) {
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
                    if (newVehicleType.isEmpty()) {
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
        System.out.println("\n    *************************** You have successfully added a new vehicle! ******************************");
    }

    private static void processRemoveVehicleRequest() {

        displayVehicles(dealership.getAllVehicles());

        System.out.println("\n========================================== Remove a Vehicle ================================================");
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

        System.out.println("\n             ************************ Vehicle successfully removed! ******************************");
    }

    private static void processSalesAndLeaseRequest() {

        displayVehicles(dealership.getAllVehicles());
        ContractDataManager contractDataManager = new ContractDataManager();
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = dateNow.format(dateFormat);

        System.out.println("\n========================================== Sell/Lease a Vehicle ================================================");

        System.out.println("* Please enter in the customer's first name:");
            String firstName;
                while (true) {
                    firstName = scanner.next().trim();
                    if (firstName.isEmpty()) {
                        System.out.println("* Please enter in a first name.");
                    } else {
                        break;
                    }
                }
        String capFirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

        System.out.println("* Please enter in the customer's last name:");
            String lastName;
                while (true) {
                    lastName = scanner.next().trim();
                    if (lastName.isEmpty()) {
                        System.out.println("* Please enter in a last name.");
                    } else {
                        break;
                    }
                }
        String capLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
                String fullName = capFirstName + " " + capLastName;

        System.out.println("* Please enter in the customer's email address:");
            String emailAddress;
                while (true) {
                    emailAddress = scanner.next().trim();
                    if (emailAddress.isEmpty()) {
                        System.out.println("* Please enter in an email address.");
                    } else {
                        break;
                    }
                }
                scanner.nextLine();
        System.out.println("* Please enter in the VIN of the vehicle you would like to sell/lease:");
            int vehicleVin;
                while (true) {
                    if (scanner.hasNextInt()) {
                        vehicleVin = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Please enter a number.");
                        scanner.next();
                    }
                }
        Vehicle vehicleFound = dealership.getVehiclesByVin(vehicleVin);

        String sellLeaseChoice;

        while (true) {
            System.out.println("* Would you like to sell or lease a vehicle?");

            while (true) {
                sellLeaseChoice = scanner.next().toLowerCase().trim();
                if (sellLeaseChoice.isEmpty()) {
                    System.out.println("* Please enter in one of the choices.");
                } else {
                    break;
                }
            }

            switch (sellLeaseChoice) {
                case "sell":
                    System.out.println("* Would the customer like to finance their vehicle?");
                    boolean isFinancing = false;
                    boolean validInput = false;

                    do {

                        String financingChoice = scanner.next().toLowerCase().trim();
                        switch (financingChoice) {
                            case "yes":
                                isFinancing = true;
                                validInput = true;
                                break;

                            case "no":
                                validInput = true;
                                break;

                            default:
                                System.out.println("Invalid input.");
                        }

                    } while (!validInput);

                    SalesContract salesContract = new SalesContract(formattedDate, fullName, emailAddress, vehicleFound, isFinancing);
                    contractDataManager.saveContract(salesContract);
                    return;

                case "lease":
                    LeaseContract leaseContract = new LeaseContract(formattedDate, fullName, emailAddress, vehicleFound);
                    contractDataManager.saveContract(leaseContract);

                    return;

                default:
                    System.out.println("Invalid input");
            }

        }

    }

}

