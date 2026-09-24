import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {

        // Create Scanner object to read input
        Scanner sc = new Scanner(System.in);

        // Ask user for input string (plaintext)
        System.out.print("Enter String to Encrypt: ");
        String word = sc.nextLine();

        // Ask user for shift value (key K)
        System.out.print("Enter K: ");
        int k = sc.nextInt();

        // Normalize key to the range 0-25
        k = k % 26;

        // ---------------- Encryption ----------------
        String encryptedWord = "";

        // Loop through each character of the word
        for (int i = 0; i < word.length(); i++) {

            // Convert character into 0-25 range
            int r = word.charAt(i) - 'a';

            // Apply Caesar Cipher formula: (position + k) mod 26
            r = (r + k) % 26;

            // Convert back to character
            encryptedWord += (char) (r + 'a');
        }

        System.out.println("Encrypted Text: " + encryptedWord);

        // ---------------- Decryption ----------------
        String decryptedWord = "";

        for (int i = 0; i < encryptedWord.length(); i++) {

            // Convert character into 0-25 range
            int r = encryptedWord.charAt(i) - 'a';

            // Apply reverse shift
            r = (r - k + 26) % 26;

            // Convert back to character
            decryptedWord += (char) (r + 'a');
        }

        System.out.println("Decrypted Text: " + decryptedWord);

        sc.close();
    }
}
