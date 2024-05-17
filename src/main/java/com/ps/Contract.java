package com.ps;

public abstract class Contract {

    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    private int vehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String dateOfContract, String customerName, String customerEmail, int vehicleSold, double totalPrice, double monthlyPayment) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(int vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "dateOfContract='" + dateOfContract + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", vehicleSold='" + vehicleSold + '\'' +
                ", totalPrice=" + totalPrice +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
