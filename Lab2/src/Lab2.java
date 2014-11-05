import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Nathan on 9/2/2014.
 */
public class Lab2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();

        //print date
        Date now = new Date();
        System.out.printf("Today is %1$tA, %1$tB %1$te, %1$tY and the time is %1$tl:%1$tM%1$tp\n",now);

        //prompt user name
        System.out.println("Username:");
        String username = scanner.nextLine();

        //prompt password
        System.out.println("Password:");
        //char[] password = console.readPassword();
        char[] password = scanner.nextLine().toCharArray();

        System.out.printf("Username: %s\n",username);
        System.out.print("Password: ");

        for(char character : password){
            System.out.print(character);
        }
        System.out.print("\n");
        password = null;

        // Get random integer
        Random rand = new Random();
        int myNumber = rand.nextInt(999) + 1;

        //Print out thinking of integer
        System.out.println("I am thinking of a number between 1 and 1000. Can you guess it?");
        int intGuess = 0;
        int intTries = 0;

        do{
            //Prompt for guess
            System.out.println("What is your guess?");

            if(scanner.hasNextInt()){
                intGuess = scanner.nextInt();
                //Check guess
                if(intGuess < myNumber)
                    System.out.println("Your guess is too low.");
                if(intGuess > myNumber)
                    System.out.println("Your guess is too high.");
                intTries++;
            }else{
                //Invalid input
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }

        }while(intGuess != myNumber);
        //Guess is correct
        System.out.printf("%d is the right number! It took you %d tries.\n\n",myNumber,intTries);


        //File IO
        Lab2 lab = new Lab2();
        try {
            lab.fileIO();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        //Print out a bunch of numbers
//        for (long i = 0; i <= 1000000000000L; i++) {
//            if (i % 10000000000L == 0 && i != 1000000000000L){
//                System.out.printf("I'm at %d\n", i);
//            }else if(i == 1000000000000L){
//                System.out.printf("Finished at %d\n", i);
//            }
//        }

        //Print out a bunch of numbers
        for (long i = 0; i <= 1000000000000L; i+=10000000000L) {
            if ( i != 1000000000000L){
                System.out.printf("I'm at %d\n", i);
            }else{
                System.out.printf("Finished at %d\n", i);
            }
        }
    }

    private void fileIO() throws IOException {
        try (Scanner fileInput = new Scanner(getClass().getResource("input.txt").openStream())) {
            int count =1;
            try(PrintWriter fileOutput = new PrintWriter("output.txt")) {
                while (fileInput.hasNext()) {
                    String strLine = fileInput.nextLine();
                    if (strLine.equals("One")) {
                        fileOutput.printf("Input File Line %d: %s\n", count, "1");
                        count++;
                    } else if (strLine.equals("Two")) {
                        fileOutput.printf("Input File Line %d: %s\n", count, "2");
                        count++;
                    } else if (strLine.equals("Three")) {
                        fileOutput.printf("Input File Line %d: %s\n", count, "3");
                        count++;
                    } else if (strLine.equals("Four")) {
                        fileOutput.printf("Input File Line %d: %s\n", count, "4");
                        count++;
                    } else if (strLine.equals("Five")) {
                        fileOutput.printf("Input File Line %d: %s\n", count, "5");
                        count++;
                    } else if (strLine.equals("Six")) {
                        fileOutput.printf("Input File Line %d: %s\n", count, "6");
                        count++;
                    } else {
                        //Do Nothing
                    }
                }
            }
        }
    }
}
