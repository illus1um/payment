package Loan;

public class InstallmentPlan {
    private static final int MONTHS_IN_YEAR = 12;
    private double price;
    private double percentage;
    private int years;

    public InstallmentPlan (){}

    public InstallmentPlan(double price, double percentage, int years) {
        this.price = price;
        this.percentage = percentage;
        this.years = years;
    }


    public double calculateMonthlyPayment() {
        int totalMonths = years * MONTHS_IN_YEAR;
        double P = percentage/100;

        double monthlyPayment = price * (P+(P/(Math.pow((1+P), totalMonths)-1)));
        return monthlyPayment;
    }
}
