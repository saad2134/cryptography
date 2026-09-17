import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class DES {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Take message
        System.out.print("Enter message to encrypt: ");
        String msg = sc.nextLine();
        byte[] message = msg.getBytes();

        // Take custom key
        System.out.print("Enter DES key (at least 8 characters): ");
        String key = sc.nextLine();
        byte[] keyData = key.getBytes();

        // Create DES Key
        DESKeySpec secretKey = new DESKeySpec(keyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey keyN = keyFactory.generateSecret(secretKey);

        // Encryption
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, keyN);
        byte[] encrypted = cipher.doFinal(message);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, keyN);

        // IMPORTANT: decrypt the encrypted data, not the original message
        byte[] decrypted = cipher.doFinal(encrypted);
        String decryptedMsg = new String(decrypted);

        // Output
        System.out.println("\nMessage: " + msg);
        System.out.println("Encrypted: " +
                Base64.getEncoder().encodeToString(encrypted));
        System.out.println("Decrypted: " + decryptedMsg);

        sc.close();
    }
}
