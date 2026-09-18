import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class RC4Encryption {
    public static void main(String[] args) {
        try {
            // Step 1: Generate a Secret Key for RC4
            KeyGenerator keyGen = KeyGenerator.getInstance("RC4");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Step 2
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Generated Secret Key (Base64): " + encodedKey);

            // Step 3
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Step 4
            String plaintext = "Hello world";
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Text: " + encryptedText);

            // Step 5 Initialize the cipher 
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Step 6 decrypt the ciphertext
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decryptedBytes);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
}
