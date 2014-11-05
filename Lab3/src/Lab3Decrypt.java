/**
 * Created by Nathan on 9/16/2014.
 */

import java.io.IOException;
import java.util.Scanner;

public class Lab3Decrypt
{

    private StringBuilder sb = new StringBuilder();
    private String decryptedMessage;

    public Lab3Decrypt(String message, Lab4Cipher cipher) throws IOException {

        try (Scanner fileInput = new Scanner(getClass().getResource(message).openStream()))
        {
            while(fileInput.hasNext())
            {
                int line = Integer.parseInt(fileInput.nextLine());
                sb.append(cipher.getCipher(line));
            }

            decryptedMessage = sb.toString();
        }
    }


    public String getDecryptedMessage() {
        return decryptedMessage;
    }

}