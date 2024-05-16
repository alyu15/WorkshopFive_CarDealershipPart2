package com.ps;

public class SalesContract extends Contract {

    private float salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean financeChoice;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold, double totalPrice,
                         double monthlyPayment, float salesTaxAmount, int recordingFee, int processingFee, boolean financeChoice) {

        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeChoice = financeChoice;
    }

    @Override
    public double getTotalPrice() {
        Vehicle vehicle = null;
        double salesPrice = vehicle.getPrice() + getRecordingFee() + getProcessingFee() + getMonthlyPayment() + getSalesTaxAmount();
        return salesPrice;
    }

    @Override
    public double getMonthlyPayment() {
        Vehicle vehicle = null;
        double loanAmount;
        if(isFinanceChoice() == true) {
            if(vehicle.getPrice() > 10_000) {
                loanAmount = 0.0425 * 48;
                return loanAmount;
            } else {
                loanAmount = 0.0525 * 24;
                return loanAmount;
            }
        } else {
            return 0;
        }
    }

    public double getSalesTaxAmount() {
        Vehicle vehicle = null;
        double taxAmount = vehicle.getPrice() * 0.05f;
        return taxAmount;
    }

    public void setSalesTaxAmount(float salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getRecordingFee() {
        return 100;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        Vehicle vehicle = null;
        if(vehicle.getPrice() < 10_000) {
            return 295;
        } else {
            return 495;
        }
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceChoice() {
        return financeChoice;
    }

    public void setFinanceChoice(boolean financeChoice) {
        this.financeChoice = financeChoice;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "salesTaxAmount=" + salesTaxAmount +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", financeChoice=" + financeChoice +
                '}';
    }
}
