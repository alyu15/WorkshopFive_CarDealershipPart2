package com.ps;

public class SalesContract extends Contract {

    private float salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean financeChoice;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold, float totalPrice,
                         float monthlyPayment, float salesTaxAmount, int recordingFee, int processingFee, boolean financeChoice) {

        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeChoice = financeChoice;
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
