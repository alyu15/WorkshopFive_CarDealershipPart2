package com.ps;

public class LeaseContract extends Contract{

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, int vehicleSold,
                         double totalPrice, double monthlyPayment, double expectedEndingValue, double leaseFee) {

        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return getExpectedEndingValue() + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        Vehicle vehicle = new Vehicle();
        return (vehicle.getPrice() * 0.04) * 36;
    }

    public double getExpectedEndingValue() {
        Vehicle vehicle = new Vehicle();
        return vehicle.getPrice() * 0.5;
    }

    public double getLeaseFee() {
        Vehicle vehicle = new Vehicle();
        return vehicle.getPrice() * 0.07;
    }

}
