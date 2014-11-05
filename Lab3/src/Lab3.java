/**
 * Created by Nathan on 9/4/2014.
 */
import java.io.IOException;

public class Lab3 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Lab4Cipher cipher = new Lab4Cipher("ssCipher.txt");
        Lab4Decrypt decrypt = new Lab4Decrypt("ssMessage.txt", cipher);
        Lab4Save save = new Lab4Save(decrypt.getDecryptedMessage());
    }

}
