import java.util.Scanner;

class AtbashCipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word to encrypt (lowercase only): ");
        String word = sc.nextLine();

        String encryptedWord = "";
        String decryptedWord = "";

        // ---------------- Encryption ----------------
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z') {

                int pos = ch - 'a';
                int newPos = 25 - pos;

                char enc = (char) (newPos + 'a');

                encryptedWord += enc;

            } else {

                // Keep non-lowercase characters unchanged
                encryptedWord += ch;
            }
        }

        // ---------------- Decryption ----------------
        for (int i = 0; i < encryptedWord.length(); i++) {

            char ch = encryptedWord.charAt(i);

            if (ch >= 'a' && ch <= 'z') {

                int pos = ch - 'a';
                int newPos = 25 - pos;

                char dec = (char) (newPos + 'a');

                decryptedWord += dec;

            } else {

                // Keep non-lowercase characters unchanged
                decryptedWord += ch;
            }
        }

        System.out.println("Encrypted Word: " + encryptedWord);
        System.out.println("Decrypted Word: " + decryptedWord);

        sc.close();
    }
}
