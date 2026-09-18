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
            if (getGCD(e, primeMul1) == 1) {
                break;
            }
        }

        System.out.println("Public key e is = " + e);

        for (int m = 0; m <= 9; m++) {
            int temp = 1 + (m * primeMul1);
            if (temp % e == 0) {
                d = temp / e;
                break;
            }
        }

        System.out.println("d is: " + d);
        double cipher;
        BigInteger d_message;

        cipher = (Math.pow(message, e)) % primeMul;
        System.out.println("Cipher Text is: " + cipher);

        BigInteger bigN = BigInteger.valueOf(primeMul);
        BigInteger bigC = BigDecimal.valueOf(cipher).toBigInteger();
        d_message = (bigC.pow(d)).mod(bigN);

        System.out.println("Decrypted text is: " + d_message);
    }
}
