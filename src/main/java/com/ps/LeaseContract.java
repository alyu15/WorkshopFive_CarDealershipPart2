package com.ps;

public class LeaseContract extends Contract{

    private float expectedEndingValue;
    private float leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold,
                         float totalPrice, float monthlyPayment, float expectedEndingValue, float leaseFee) {

        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    @Override
    public float getTotalPrice() {
        return 0;
    }

    @Override
    public float getMonthlyPayment() {
        return 0;
    }
}
