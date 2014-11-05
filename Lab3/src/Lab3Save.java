/**
 * Created by Nathan on 9/16/2014.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab3Save
{
    public Lab3Save (String message) throws FileNotFoundException
    {

        String file = new File("Message.txt").getAbsolutePath();

        try (PrintWriter fileOutput = new PrintWriter(file))
        {
            fileOutput.print(message);
        }
    }

}