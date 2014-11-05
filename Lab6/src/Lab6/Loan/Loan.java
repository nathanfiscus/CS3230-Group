package Lab6.Loan;

import java.text.NumberFormat;
import java.util.*;
import Lab6.Output.*;

/**
 * Created by Nathan Fiscus
 * Tim Starr
 * Trevor Anderson
 * 22 August, 2014
 */

public class Loan {
    Scanner scanner;

    private String userInput;
    private double loanAmount, monthlyPayments, totalInterest, totalPrinciple;
    private double interestRate;
    private int loanYears, paymentNum;
    private double balance;
    LoanItem[] items;

    public Loan() {
        scanner = new Scanner(System.in);
        String userInput = "";
        totalInterest = 0;
        totalPrinciple = 0;
        paymentNum=0;
        balance = 0;
    }

    public void Amortization(){

        try {
            System.out.print("Please enter the amount to borrow or 'X' to return: ");
            userInput = scanner.nextLine();
            if("X".equals(userInput.toUpperCase())){
                return;
            }
            loanAmount = Double.parseDouble(userInput);

            System.out.print("Please enter the APR (as 0.xy) or 'X' to return: ");
            userInput = scanner.nextLine();
            if("X".equals(userInput.toUpperCase())){
                return;
            }
            interestRate = Double.parseDouble(userInput);
            System.out.print("Please enter the number of years or 'X' to return: ");
            userInput = scanner.nextLine();
            if("X".equals(userInput.toUpperCase())){
                return;
            }
            loanYears = Integer.parseInt(userInput);
            monthlyPayments = loanAmount * Math.pow(1 + interestRate / 12, loanYears * 12) * (interestRate / 12) / (Math.pow(1 + interestRate / 12, loanYears * 12) - 1);
            items = new LoanItem[loanYears * 12];
            double temp = loanAmount;

            for (int i = 0; i < items.length; i++){
                items[i] = new LoanItem(0,0,0,0,0,0);
            }

            do {
                totalPrinciple += monthlyPayments - loanAmount * interestRate / 12;
                totalInterest += monthlyPayments - (monthlyPayments - loanAmount * interestRate / 12);
                items[paymentNum].setPaymentNum(paymentNum+1);
                items[paymentNum].setPrinciple(monthlyPayments - loanAmount * interestRate / 12);
                items[paymentNum].setInterest(monthlyPayments - (monthlyPayments - loanAmount * interestRate / 12));
                items[paymentNum].setTotalInterest(totalInterest);
                items[paymentNum].setTotalPrinciple(totalPrinciple);
                items[paymentNum].setBalance(Math.abs(loanAmount - (monthlyPayments - loanAmount * interestRate / 12)));
                loanAmount -= monthlyPayments - loanAmount * interestRate / 12;

                paymentNum++;

            } while(paymentNum < items.length);

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
            String formattedLine = "%1$-11s %2$-11s %3$-11s %4$-17s %5$-16s %6$-16s\n";
            StringBuilder sb = new StringBuilder();
            String s = "Loan Details:\n";
            sb.append(s);

            s = String.format("  Loan Amount: %s\n", currencyFormat.format(temp));
            sb.append(s);
            s = String.format("  Annual Percentage Rate: %.3f%%\n", interestRate*100);
            sb.append(s);
            s = String.format("  Loan Term: %d Years\n", loanYears);
            sb.append(s);
            s = String.format("  Monthly payment: %s\n", currencyFormat.format(monthlyPayments));
            sb.append(s);
            s ="\n";
            sb.append(s);
            s = String.format(formattedLine, "Payment #", "Principle", "Interest", "Total Principle", "Total Interest", "Balance");
            sb.append(s);
            for (int i = 0; i < items.length ; i++) {

                s = String.format(formattedLine, items[i].getPaymentNum(),
                        currencyFormat.format(items[i].getPrinciple()),
                        currencyFormat.format(items[i].getInterest()),
                        currencyFormat.format(items[i].getTotalPrinciple()),
                        currencyFormat.format(items[i].getTotalInterest()),
                        currencyFormat.format(items[i].getBalance()));
                sb.append(s);
            }


            s = String.format("\nTotal Payments: %1$-9s\n\n", currencyFormat.format(items[items.length - 1].getTotalInterest() + items[items.length - 1].getTotalPrinciple()));
            sb.append(s);
            Output out = new Output();

            out.toConsole(sb.toString());
            out.toFile("loan_amortization.txt",sb.toString(),false);

        } catch(InputMismatchException intFormatError){
            System.out.println("That doesn't seem to be a valid number and the program will close!");
        } catch (NumberFormatException ex) {
            System.out.println(("That isn't a valid number!!!"));
        }




        System.out.println("Hit enter to continue.");

        scanner.nextLine();
    }

}
