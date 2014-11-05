package Lab6.Loan;

/**
 * Created by Nathan on 9/22/2014.
 */
public class LoanItem {
    private int paymentNum;
    private double principle,interest,totalPrinciple,totalInterest,balance;

    public LoanItem(int paymentNum,double principle,double interest,double totalPrinciple, double totalInterest, double balance){
        this.paymentNum = paymentNum;
        this.principle = principle;
        this.interest = interest;
        this.totalPrinciple = totalPrinciple;
        this.totalInterest = totalInterest;
        this.balance = balance;
    }

    public int getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(int paymentNum) {
        this.paymentNum = paymentNum;
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(double principle) {
        this.principle = principle;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getTotalPrinciple() {
        return totalPrinciple;
    }

    public void setTotalPrinciple(double totalPrinciple) {
        this.totalPrinciple = totalPrinciple;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
