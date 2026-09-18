import java.math.*;
import java.util.*;

public class RSAAlgorithm {
    public static int getGCD(int mod, int num) {
        if (mod == 0) 
            return num;
        else
            return getGCD(num % mod, mod);
    }

    public static void main(String args[]) {
        int d = 0, e; //Initialization
        int message = 88;
        int prime1 = 11;
        int prime2 = 17;
        int primeMul = prime1 * prime2;
        int primeMul1 = (prime1 - 1) * (prime2 - 1);
        System.out.println("primeMul1 is equal to: " + primeMul1 + "\n");

        //Finding the valid public key
        for (e = 2; e < primeMul1; e++) {
            //Here e is public key
            if (getGCD(e, primeMul1) == 1) {
                break;
            }
        }

        // Printing the public key
        System.out.println("Public key e is = " + e);

        //Calculating the private key
        for (int m = 0; m <= 9; m++) {
            // get the value of temp
            int temp = 1 + (m * primeMul1);

            //private key
            if (temp % e == 0) {
                d = temp / e;
                break;
            }

        }
        System.out.println("d is: " + d);
        double cipher;
        BigInteger d_message;

        //getting the cipher text
        cipher = (Math.pow(message, e)) % primeMul;
        System.out.println("Cipher Text is: " + cipher);

        //Int to BigInteger
        BigInteger bigN = BigInteger.valueOf(primeMul);

        //Float to bigInt
        BigInteger bigC = BigDecimal.valueOf(cipher).toBigInteger();

        // decrypting the message
        d_message = (bigC.pow(d)).mod(bigN);

        //print the decrypted message
        System.out.println("Decrypted text is: " + d_message);
    }
}
