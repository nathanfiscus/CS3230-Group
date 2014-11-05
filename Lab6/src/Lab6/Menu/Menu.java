package Lab6.Menu;

import Lab6.LifeExpect.LifeExpectancy;
import Lab6.Loan.Loan;

import java.util.Scanner;

/**
 * Created by Nathan on 9/22/2014.
 */
public class Menu {

    Scanner scanner = new Scanner(System.in);
    String userInput = "";
    LifeExpectancy life;
    Loan loan;

    public Menu(LifeExpectancy life, Loan loan){
        this.life = life;
        this.loan = loan;

    }

    public void display(){
    do {
        clearScreen();
        System.out.println("Please make a selection.");
        System.out.println("1 - Calculate life");
        System.out.println("2 - Amortization Chart");
        System.out.println("X - Exit");

        userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                life.Calculate();
                break;
            case "2":
                loan.Amortization();
                break;
            case "x":
            case "X":
                System.out.println("Goodbye!!!");
                break;
            default:
                System.out.println("Unknown Command. Hit enter to continue");
                scanner.nextLine();
                break;
        }

    } while(null != userInput && !"X".equals(userInput.toUpperCase()));
}

    private static void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
