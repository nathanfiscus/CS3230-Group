import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Nathan on 9/4/2014.
 */
public class Lab3Cipher {
    private char[] cipher;

    public Lab3Cipher(String filename) throws IOException {
        try (Scanner fileInput = new Scanner(getClass().getResource(filename).openStream())) {
            int arraySize = Integer.parseInt(fileInput.nextLine().split("=")[1]);
            cipher = new char[arraySize];

            while(fileInput.hasNext()){
                String line = fileInput.nextLine();
                int index = Integer.parseInt(line.split("=")[0]);
                char value = line.split("=")[1].charAt(0);
                cipher[index] = value;
            }
        }
    }

    public char getCipher(int index){
        return cipher[index];
    }
}
