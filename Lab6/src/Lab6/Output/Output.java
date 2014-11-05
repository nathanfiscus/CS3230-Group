package Lab6.Output;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nathan on 9/22/2014.
 */
public class Output {

    public void toConsole(String output){
        System.out.print(output);
    }

    public void toFile(String filename, String output, Boolean append){
        try (PrintWriter fileOutput = new PrintWriter(new FileWriter(filename, append))) {

            fileOutput.print(output);

        } catch (IOException e) {
            System.out.println("Couldn't write to file " + filename + " for some reason!!!");
        }
    }

}
