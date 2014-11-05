package NathanFiscus.Lab5;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lab5 {
    //enumeration for the gender of a person
    private enum Sex {
        Male,
        Female
    }
    //main method.
    public static void main(String[] args) {
        //initialize a scanner object to acquire keyboard input from the console.
        Scanner scanner = new Scanner(System.in);
        //initializes a string for user input
        String userInput = "";

        //a loop that runs at least once.
        do {
            //method call to clear the console screen
            clearScreen();
            //Print a string to the console
            System.out.println("Please make a selection.");
            //Print a string to the console
            System.out.println("1 - Calculate life");
            //Print a string to the console
            System.out.println("2 - Amortization Chart");
            //Print a string to the console
            System.out.println("X - Exit");

            //set the string object userInput to the scanner objects next line that is read from the console after pressing return
            userInput = scanner.nextLine();

            //switch statement based on the input stored in user Input
            switch (userInput) {
                //if the input is "1" run this switch
                case "1":
                    //method call to run calculate life expectancy
                    calcLife();
                    //break out of this switch statement
                    break;
                //if the input is "2" run this case
                case "2":
                    //method call to calculate a loan amortization;
                    amortization();
                    //break out of this switch statement
                    break;
                //case if input is "x" or "X"
                case "x":
                case "X":
                    //print a string to the console
                    System.out.println("Goodbye!!!");
                    //break out of this switch statement
                    break;
                //if no other cases fit input, run this case
                default:
                    //print a string to the console
                    System.out.println("Unknown Command. Hit enter to continue");
                    //clear the scanner input, for next valid input
                    scanner.nextLine();
                    //break out of this switch statement
                    break;
            }
         //Execute the loop while the userInput string is not null and note equal to an X or x
        } while(null != userInput && !"X".equals(userInput.toUpperCase()));
    }

    //method declaration for clearing the screen
    private static void clearScreen() {
        //for loop from 0 to 99 increment by 1
        for(int i = 0; i < 100; i++) {
            //print empty line with a line break
            System.out.println();
        }
    }
    // method declaration for calculating life expectancy
    //Better method would be to create a new class to hold this function and some of its attributes
    private static void calcLife(){
        //create and initialize a new scanner object set up for keyboard input from the console
        Scanner scanner = new Scanner(System.in);
        //create and initialize a new string object
        String userInput = "";
        //declare a sex enumeration variable type
        Sex sex;
        //create a calendar object from the current system's calendar type for the user's birthday
        Calendar birthday = Calendar.getInstance();
        //create a calendar object from the current system's calendar type for the user's deathday
        Calendar deathday = Calendar.getInstance();
        //create an integer value for the number of years expected to live.
        int lifeExpectancy;

        //method call to clear the console screen
        clearScreen();
        //prints a string to the console
        System.out.println("Let's figure out how long you have to live.");

        //loop that has to be run at least once.
        do {
            //prints a string to the console
            System.out.println("Are you male or female?");
            //prints a string to the console
            System.out.println("M - Male");
            //prints a string to the console
            System.out.println("F - Female");
            //prints a string to the console
            System.out.println("X - Return");
            // Reads in the next line entered in the console by the user.
            userInput = scanner.nextLine();
            //if the input is X then exit the function and return to the main menu
            if(null != userInput && "X".equals(userInput.toUpperCase())) {
                //exits this function and returns to the main method
                return;
            }
            //If statement to check user input only allows M and F else displays an error message
            if(null != userInput && !"M".equals(userInput.toUpperCase()) && !"F".equals(userInput.toUpperCase())) {
                //prints an error message to the console with the input from the user as part of the string.
                System.out.printf("I am not sure what %s means\n", userInput);
            } else {
                //short hand if statement: the userinput is M then store Male else Female in the sex
                sex = "M".equals(userInput.toUpperCase()) ? Sex.Male : Sex.Female;
                //short hand if statement: if the sex is male then store 77 else 82 for life expectancy
                lifeExpectancy = sex.equals(Sex.Male) ? 77 : 82;
                //breaks out of the loop
                break;
            }
        // loop keeps executing until you break out
        } while(true);

        //loop that has to be run at least once.
        do {
            //Prints a string to the console
            System.out.println("When were you born? (Like: 'July 4, 1776') or 'X' to return");
            //Gets the next line of user input from the console
            userInput = scanner.nextLine();

            //if the input equals "X" then exit the function and return to the main method
            if("X".equals(userInput.toUpperCase())) {
                //exits the function and returns to the main method
                return;
            }
            //try to execute the statements within the try block
            try {
                //sets the calendar object for the birthday to a date parsed from the user input string, must be in "MMMM, d, YYYY" format
                birthday.setTime(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(userInput));
                //sets the calendar object for the deathdate to a date parsed from the user input string, must be in "MMMM, d, YYYY" format
                deathday.setTime(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(userInput));
                //adds the number of years expected to live to deathday object
                deathday.add(Calendar.YEAR, lifeExpectancy);
                // breaks out of the do-while loop
                break;

            //Catches any error thrown by the above code
            } catch (Exception ex) {
                //prints an error message to the console
                System.out.println("That doesn't seem to be a valid birthday!!!");
            }
            // loop keeps executing until reaching a break statement
        } while (true);

        //try to execute the statements within the try block and initialize the printerwriter with a filewriter stream, open to append
        try(PrintWriter fileOutput = new PrintWriter(new FileWriter("life_expectancy.txt",true))) {
            //print a string to the console with the name of the sex
            System.out.printf("\nYou are %s.\n", sex.name());
            //print a string to the console with the birthday calendar object formatted
            System.out.printf("Your birthday is %1$td-%1tb: %1$tY.\n", birthday);
            //print a string to the file with the name of the sex
            fileOutput.printf("You are %s.\n", sex.name());
            //print a string to the file with a formatted birthday calendar object
            fileOutput.printf("Your birthday is %1$td-%1tb: %1$tY.\n", birthday);

            //I would generate a function to do this math and return the value for cleanliness
            //Calculate the difference between the birthday and today
            long diff = Math.abs(birthday.getTime().getTime() - (new Date()).getTime());
            //calculate the number of days alive
            long daysAlive = diff / (24 * 60 * 60 * 1000);
            //Calculate the difference between the today and the death day
            diff = Math.abs((new Date()).getTime() - deathday.getTime().getTime());
            //calculate the number of days left to live
            long daysToLive = diff / (24 * 60 * 60 * 1000);

            //print a string to the console with the number of days alive
            System.out.printf("You are %d days old.\n", daysAlive);
            //print a string to the console with the number of days to live
            System.out.printf("You have %s days left to live.\n", daysToLive);
            //print as string to the console with the percentage of life left to live
            System.out.printf("You have %.1f%% of your life left.\n\n", (daysToLive / (365.25 * lifeExpectancy)) * 100);
            //print a string to the file with the number of days alive
            fileOutput.printf("You are %d days old.\n", daysAlive);
            //print a string to the file with the number of days to live
            fileOutput.printf("You have %s days left to live.\n", daysToLive);
            //print as string to the file with the percentage of life left to live
            fileOutput.printf("You have %.1f%% of your life left.\n\n", (daysToLive / (365.25 * lifeExpectancy)) * 100);

        //Catches any IOException generated from the file output
        } catch (IOException e) {
            //prints an error message to the console
            System.out.println("Couldn't write life expectancy to file for some reason!!!");
        }

        //prints a string to the console
        System.out.println("Hit enter to continue.");
        //gets the next line of input generated by the user - simulates a pause function
        scanner.nextLine();
    }

    //Better method would be to create a new class to hold this function and some of its attributes
    private static void amortization(){
        //initialize a scanner object for input from the console
        Scanner scanner = new Scanner(System.in);
        // userinput string object
        String userInput = "";
        // create double values
        double loanAmount, monthlyPayments, totalInterest=0, totalPrinciple=0;
        // create interest rate double
        double interestRate;
        // create integer values
        int loanYears, paymentNum=1;
        // creates a new number formatter for US Currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        // stores a string for formatting each line
        String formattedLine = "%1$-11s %2$-11s %3$-11s %4$-17s %5$-16s %6$-16s\n";

        //method call for the clear screen function
        clearScreen();

        //try to create a new printwriter object to write to a file
        try(PrintWriter fileOutput = new PrintWriter("loan_amortization.txt")) {
            //print a string to the console
            System.out.print("Please enter the amount to borrow or 'X' to return: ");
            //store the next line of user input from the console
            userInput = scanner.nextLine();
            // if the input equals X or x
            if("X".equals(userInput.toUpperCase())){
                //exit function and return to main method
                return;
            }
            //parse the input string as a double
            loanAmount = Double.parseDouble(userInput);

            //print message to the console
            System.out.print("Please enter the APR (as 0.xy) or 'X' to return: ");
            //read in the next line from the user input from the console
            userInput = scanner.nextLine();
            // if the input equals X or x
            if("X".equals(userInput.toUpperCase())){
                //exit function and return to main method
                return;
            }
            //parse the input string as a double
            interestRate = Double.parseDouble(userInput);
            //print message to the console
            System.out.print("Please enter the number of years or 'X' to return: ");
            //read in the next line from the user input from the console
            userInput = scanner.nextLine();
            // if the input equals X or x
            if("X".equals(userInput.toUpperCase())){
                //exit function and return to main method
                return;
            }
            //parse the input string as a integer
            loanYears = Integer.parseInt(userInput);

            //calculate the monthly payment, using raise to power power (Math.pow())
            monthlyPayments = loanAmount * Math.pow(1 + interestRate / 12, loanYears * 12) * (interestRate / 12) / (Math.pow(1 + interestRate / 12, loanYears * 12) - 1);

            //print new line to console
            System.out.print("\n");
            // print string to console
            System.out.println("Loan Details:");
            //print string to console with loan amount formatted as currency
            System.out.printf("  Loan Amount: %s\n", currencyFormat.format(loanAmount));
            //print string to console with the interest rate
            System.out.printf("  Annual Percentage Rate: %.3f%%\n", interestRate*100);
            //print string to the console with loan years
            System.out.printf("  Loan Term: %d Years\n", loanYears);
            //print string to the console with monthly payments formatted as a currency object
            System.out.printf("  Monthly payment: %s\n", currencyFormat.format(monthlyPayments));
            //print new line to the console
            System.out.print("\n");
            //print the column headers for to the console using the the format string declared earlier
            System.out.printf(formattedLine, "Payment #", "Principle", "Interest", "Total Principle", "Total Interest", "Balance");
            //print string to the file
            fileOutput.println("Loan Details:");
            //print string to file with loan amount formatted as currency
            fileOutput.printf("  Loan Amount: %s\n", currencyFormat.format(loanAmount));
            //print string to file with the interest rate
            fileOutput.printf("  Annual Percentage Rate: %.3f%%\n", interestRate*100);
            //print string to the file with loan years
            fileOutput.printf("  Loan Term: %d Years\n", loanYears);
            //print string to the file with monthly payments formatted as a currency object
            fileOutput.printf("  Monthly payment: %s\n", currencyFormat.format(monthlyPayments));
            //print new line to the file
            fileOutput.print("\n");
            //print the column headers for to the file using the the format string declared earlier
            fileOutput.printf(formattedLine,"Payment #","Principle","Interest", "Total Principle", "Total Interest", "Balance");

            //loop that runs at least once
            do {
                // update the total interest by adding the left hand side to right and storing it in the right hand variable
                totalInterest += monthlyPayments - (monthlyPayments - loanAmount * interestRate / 12);
                // update the total principle by adding the left hand side to right and storing it in the right hand variable
                totalPrinciple += monthlyPayments - loanAmount * interestRate / 12;

                //print a string to the console using the format string and for each of line of the amortization and uses currency formatter
                System.out.printf(formattedLine, paymentNum,
                        currencyFormat.format(monthlyPayments - loanAmount * interestRate / 12),
                        currencyFormat.format(monthlyPayments - (monthlyPayments - loanAmount * interestRate / 12)),
                        currencyFormat.format(totalPrinciple),
                        currencyFormat.format(totalInterest),
                        currencyFormat.format(Math.abs(loanAmount - (monthlyPayments - loanAmount * interestRate / 12))));
                //print a string to the file using the format string and for each of line of the amortization and uses currency formatter
                fileOutput.printf(formattedLine, paymentNum + ":",
                        currencyFormat.format(monthlyPayments - loanAmount * interestRate / 12),
                        currencyFormat.format(monthlyPayments - (monthlyPayments - loanAmount * interestRate / 12)),
                        currencyFormat.format(totalPrinciple),
                        currencyFormat.format(totalInterest),
                        currencyFormat.format(Math.abs(loanAmount - (monthlyPayments - loanAmount * interestRate / 12))));
                // update the loan amount by subtracting the left hand side to right and storing it in the right hand variable
                loanAmount -= monthlyPayments - loanAmount * interestRate / 12;
                //increment the payment num by 1
                paymentNum++;
            //loop until the loan amount is zero
            } while(Math.round(loanAmount)>0);

            //print a formatted string to the console with the total payments formatted as currency
            System.out.printf("\nTotal Payments: %1$-9s\n\n", currencyFormat.format(totalInterest + totalPrinciple));
            //print a formatted string to the file with the total payments formatted as currency
            fileOutput.printf("\nTotal Payments: %1$-9s", currencyFormat.format(totalInterest + totalPrinciple));
         //Catch invalid input
        } catch(InputMismatchException intFormatError){
            //displays error message on the console
            System.out.println("That doesn't seem to be a valid number and the program will close!");
        } catch (FileNotFoundException e) {
            //displays error message on the console
            System.out.println("Couldn't write loan amortization to file for some reason!!!");
        //catch number formatting errors
        } catch (NumberFormatException ex) {
            //display error message on the console
            System.out.println(("That isn't a valid number!!!"));
        }
        //print string to console
        System.out.println("Hit enter to continue.");

        //wait for user to press enter (simulate pause)
        scanner.nextLine();
    }
}