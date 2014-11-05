/**
 * Created by Nathan on 9/4/2014.
 */
import java.io.IOException;

public class Lab4 {

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Lab4Cipher cipher = new Lab4Cipher("ssCipher.txt");
        Lab4Decrypt decrypt = new Lab4Decrypt("ssMessage.txt", cipher);
        Lab4Save save = new Lab4Save(decrypt.getDecryptedMessage());
        Encode encode = new Encode(cipher, "I do not like it so you cannot make me");
        encode.sendMessage();
    }

}
