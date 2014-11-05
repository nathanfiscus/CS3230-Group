package Lab6.LifeExpect;

import Lab6.Output.Output;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Nathan on 9/22/2014.
 */
public class LifeExpectancy {
    Scanner scanner;
    String userInput;
    Sex sex;
    Calendar birthday;
    Calendar deathday;
    int lifeExpectancy;

    public LifeExpectancy(){
        scanner = new Scanner(System.in);
        userInput = "";
        birthday = Calendar.getInstance();
        deathday = Calendar.getInstance();
    }

    public enum Sex {
        Male,
        Female
    }

    public void Calculate(){

        System.out.println("Let's figure out how long you have to live.");

        do {
            System.out.println("Are you male or female?");
            System.out.println("M - Male");
            System.out.println("F - Female");
            System.out.println("X - Return");
            userInput = scanner.nextLine();

            if(null != userInput && "X".equals(userInput.toUpperCase())) {
                return;
            }
            if(null != userInput && !"M".equals(userInput.toUpperCase()) && !"F".equals(userInput.toUpperCase())) {
                System.out.printf("I am not sure what %s means\n", userInput);
            } else {
                sex = "M".equals(userInput.toUpperCase()) ? Sex.Male : Sex.Female;
                lifeExpectancy = sex.equals(Sex.Male) ? 77 : 82;
                break;
            }

        } while(true);


        do {
            System.out.println("When were you born? (Like: 'July 4, 1776') or 'X' to return");
            userInput = scanner.nextLine();

            if("X".equals(userInput.toUpperCase())) {
                return;
            }
            try {
                birthday.setTime(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(userInput));
                deathday.setTime(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(userInput));
                deathday.add(Calendar.YEAR, lifeExpectancy);
                break;
            } catch (Exception ex) {
                System.out.println("That doesn't seem to be a valid birthday!!!");
            }

        } while (true);


        Output out = new Output();


        long diff = Math.abs(birthday.getTime().getTime() - (new Date()).getTime());
        long daysAlive = diff / (24 * 60 * 60 * 1000);
        diff = Math.abs((new Date()).getTime() - deathday.getTime().getTime());
        long daysToLive = diff / (24 * 60 * 60 * 1000);

        StringBuilder sb = new StringBuilder();
        String s = String.format("You are %s.\n", sex.name());
        sb.append(s);
        s = String.format("Your birthday is %1$td-%1tb: %1$tY.\n", birthday);
        sb.append(s);
        s = String.format("You are %d days old.\n", daysAlive);
        sb.append(s);
        s = String.format("You have %s days left to live.\n", daysToLive);
        sb.append(s);
        s = String.format("You have %.1f%% of your life left.\n\n", (daysToLive / (365.25 * lifeExpectancy)) * 100);
        sb.append(s);

        out.toConsole(sb.toString());
        out.toFile("life_expectancy.txt",sb.toString(),true);

        System.out.println("Hit enter to continue.");

        scanner.nextLine();
    }
}
