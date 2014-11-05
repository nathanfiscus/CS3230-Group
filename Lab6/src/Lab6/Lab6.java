package Lab6;

import Lab6.LifeExpect.LifeExpectancy;
import Lab6.Loan.Loan;
import Lab6.Menu.Menu;

/**
 * Created by Nathan on 9/22/2014.
 */
public class Lab6 {

    public static void main(String[] args) {
        LifeExpectancy life = new LifeExpectancy();
        Loan loan = new Loan();
        Menu menu = new Menu(life, loan);

        menu.display();
    }
}
