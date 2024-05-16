package com.ps;

public class LeaseContract extends Contract{

    private float expectedEndingValue;
    private float leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold,
                         double totalPrice, double monthlyPayment, float expectedEndingValue, float leaseFee) {

        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

    public float getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(float expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public float getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(float leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "expectedEndingValue=" + expectedEndingValue +
                ", leaseFee=" + leaseFee +
                '}';
    }
}
