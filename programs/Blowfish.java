import java.util.*;
import java.security.GeneralSecurityException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Blowfish {
    public static void main(String args[]) throws GeneralSecurityException {
        Scanner sc = new Scanner(System.in);

        //Input: Message
        System.out.print("Enter message to encrypt: ");
        String msg = sc.nextLine();
        byte[] message = msg.getBytes();

        //Input: Key
        System.out.print("Enter custom key: ");
        String key = sc.nextLine();
        byte[] keyData = key.getBytes();

        //Create secret key spec for blowfish
        SecretKeySpec secretKey = new SecretKeySpec(keyData, "Blowfish");

        //Encryption 
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(message);

        //Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        String decryptedMsg = new String(decrypted);

        //Output
        System.out.println("Message: " + msg);
        System.out.println("Encryption: " + encrypted);
        System.out.println("Decrypted: " + decryptedMsg);

        sc.close();
    }
}
