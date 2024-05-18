package com.ps;

public class LeaseContract extends Contract{

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {

        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.5;
        this.leaseFee = vehicleSold.getPrice() * 0.07;
    }

    @Override
    public double getTotalPrice() {
        return getExpectedEndingValue() + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        Vehicle vehicle = getVehicleSold();
        double loanAmount = vehicle.getPrice();
        double monthlyInterestRate = 0.04/12;
        int loanTermInMonths = 36;
        double exponent = Math.pow(1 + monthlyInterestRate, loanTermInMonths);
        double paymentPerMonth = (loanAmount * monthlyInterestRate * exponent) / (exponent - 1);

        return paymentPerMonth;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

}
