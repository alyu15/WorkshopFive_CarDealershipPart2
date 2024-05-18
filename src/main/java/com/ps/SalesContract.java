package com.ps;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private int recordingFee = 100;
    private int processingFee;
    private boolean financeChoice;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeChoice) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05;
        if(vehicleSold.getPrice() < 10_000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }
        this.financeChoice = financeChoice;
    }

    @Override
    public double getTotalPrice() {
        Vehicle vehicle = getVehicleSold();
        double totalAmount = vehicle.getPrice() + getRecordingFee() + getProcessingFee()
                + getMonthlyPayment() + getSalesTaxAmount();
        return totalAmount;
    }

    @Override
    public double getMonthlyPayment() {

        double loanAmount;
        double monthlyInterestRate;
        double exponent;
        double paymentPerMonth;
        int loanTermInMonths;

        if(isFinanceChoice()) {
            Vehicle vehicle = getVehicleSold();
            if(vehicle.getPrice() > 10_000) {
                loanAmount = this.getVehicleSold().getPrice() * 0.0425;
                monthlyInterestRate = 0.0425/12;
                loanTermInMonths = 48;

            } else {
                loanAmount = vehicle.getPrice() * 0.0525;
                monthlyInterestRate = 0.0525 / 12;
                loanTermInMonths = 24;
            }
            exponent = Math.pow(1+monthlyInterestRate,loanTermInMonths);
            paymentPerMonth = (loanAmount*monthlyInterestRate*exponent)/(exponent-1);

            return paymentPerMonth * loanTermInMonths;
        } else {
            return 0;
        }
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public boolean isFinanceChoice() {
      return financeChoice;
    }

    public void setFinanceChoice(boolean financeChoice) {
        this.financeChoice = financeChoice;
    }

}
