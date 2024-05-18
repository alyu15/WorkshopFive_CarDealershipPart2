package com.ps;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        ArrayList<Vehicle> vehiclesFilteredByPrice = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                vehiclesFilteredByPrice.add(vehicle);
            }
        }
        return vehiclesFilteredByPrice;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehiclesFilteredByMakeModel = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehiclesFilteredByMakeModel.add(vehicle);
            }
        }
        return vehiclesFilteredByMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear){
        ArrayList<Vehicle> vehiclesFilteredByYear = new ArrayList<>();
        for(Vehicle vehicle: this.inventory) {
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                vehiclesFilteredByYear.add(vehicle);
            }
        }
        return vehiclesFilteredByYear;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> vehiclesFilteredByColor = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehiclesFilteredByColor.add(vehicle);
            }
        }
        return vehiclesFilteredByColor;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage){
        ArrayList<Vehicle> vehiclesFilteredByMileage = new ArrayList<>();
        for(Vehicle vehicle: this.inventory) {
            if(vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                vehiclesFilteredByMileage.add(vehicle);
            }
        }
        return vehiclesFilteredByMileage;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> vehiclesFilteredByType = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehiclesFilteredByType.add(vehicle);
            }
        }
        return vehiclesFilteredByType;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

    public Vehicle getVehiclesByVin(int vehicleVin){
        for(Vehicle vehicle: this.inventory) {
            if(vehicle.getVin() == vehicleVin){
                return vehicle;
            }
        }
        return null;
    }

}