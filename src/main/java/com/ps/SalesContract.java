package com.ps;

public class SalesContract extends Contract {

    private int recordingFee = 100;
    private boolean financeChoice;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, int vehicleSold, double totalPrice,
                         double monthlyPayment, boolean financeChoice) {

        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.financeChoice = financeChoice;
    }

    @Override
    public double getTotalPrice() {
        Vehicle vehicle = new Vehicle();
        return vehicle.getPrice() + getRecordingFee() + getProcessingFee() + getMonthlyPayment() + getSalesTaxAmount();
    }

    @Override
    public double getMonthlyPayment() {
        Vehicle vehicle = new Vehicle();
        double loanAmount;
        if(isFinanceChoice()) {
            if(vehicle.getPrice() > 10_000) {
                loanAmount = (vehicle.getPrice() * 0.0425) * 48;
            } else {
                loanAmount = (vehicle.getPrice() * 0.0525) * 24;
            }
            return loanAmount;
        } else {
            return 0;
        }
    }

    public double getSalesTaxAmount() {
        Vehicle vehicle = new Vehicle();
        return vehicle.getPrice() * 0.05f;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public int getProcessingFee() {
        Vehicle vehicle = new Vehicle();
        if(vehicle.getPrice() < 10_000) {
            return 295;
        } else {
            return 495;
        }
    }

    public boolean isFinanceChoice() {
        return financeChoice;
    }

    public void setFinanceChoice(boolean financeChoice) {
        this.financeChoice = financeChoice;
    }

}
