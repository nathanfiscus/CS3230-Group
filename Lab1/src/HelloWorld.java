/**
 * Project: Lab 1
 * Course: CS 3230
 * Author: Nathan Fiscus
 * Due: 9/2/2014.
 */
public class HelloWorld {

    public static void main(String[] args) {

        //Initialize Only
        short myShort;
        long myLong;
        float myFloat;
        boolean myBool;

        //Initialize and assign 4 variables
        double myDouble = 56771234.54321235;
        int myInt = 15;
        byte myByte = 8;
        char myChar = 'N';

        // Make assignments
        myShort = 12;
        myLong = 2004;
        myFloat = 12.12121212f;
        myBool = true;

        //Create myString Object
        String myString = "This is my string.";

        //Converts the float up to a double no loss of information
        //no accurate representation of 1/10 though
        System.out.println(myDouble * myFloat);

        //Converts the byte up to a double no loss of information
        System.out.println(myFloat - myByte);

        //Converts the short to a long no information loss
        System.out.println(myLong / myShort);

        //Converts the byte to a integer, no information loss
        System.out.println(myInt % myByte);

        //Int is converted to a double, float is converted to a double no information loss
        //no accurate representation of 1/10 though
        System.out.println(Math.PI * Math.sin(myDouble) + Math.pow(myInt, myFloat));

        //Cast myDouble to a byte, a loss of information, no decimal places in bytes and limited to -127 to 127
        System.out.println((byte)myDouble);

        //Create as string with all my variables using string builder
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("int:")
                .append(myInt)
                .append(", short:")
                .append(myShort)
                .append(", long:")
                .append(myLong)
                .append(", boolean:")
                .append(myBool)
                .append(", byte:")
                .append(myByte)
                .append(", float:")
                .append(myFloat)
                .append(", double:")
                .append(myDouble);
        System.out.println(sBuilder);

        //Test if myString equals "Hello World!" (will be false)
        System.out.println(myString.equals("Hello World!"));

        //Coverts the string to uppercase
        System.out.println(myString.toUpperCase());

        //Converts the string to lowercase
        System.out.println(myString.toLowerCase());

        //Appends or concatenates an input string to the end of the string
        System.out.println(myString.concat("Another thing."));

        //Returns the character at the specified index
        System.out.println(myString.charAt(8));

        //Returns the last index(0 based) or the input string
        System.out.println(myString.lastIndexOf("my"));
    }
}
