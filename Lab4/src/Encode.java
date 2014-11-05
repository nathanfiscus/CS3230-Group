import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Nathan on 9/16/2014.
 */
public class Encode {
    private String strEncrypt;
    private StringBuilder sb;

    public Encode(Lab4Cipher cipher, String message){
        sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < cipher.getChipherSize(); j++) {
                if(cipher.getCipher(j) == message.charAt(i)){
                    sb.append(String.format("%2d\n",j));
                    break;
                }
            }
        }
        strEncrypt = sb.toString();
    }

    public void sendMessage() throws FileNotFoundException
    {
        String file = new File("ssEncoded.txt").getAbsolutePath();
        try (PrintWriter fileOutput = new PrintWriter(file))
        {
            fileOutput.print(strEncrypt);
        }
    }

}
