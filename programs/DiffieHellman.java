import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    private static final SecureRandom random = new SecureRandom();

    private BigInteger agreedPrimeP;
    private BigInteger agreedPrimitiveRootG;
    private BigInteger publicKey;
    private BigInteger privateKey;

    public DiffieHellman(int keySize, BigInteger base, BigInteger modulus) {

        agreedPrimeP = modulus;
        agreedPrimitiveRootG = base;

        // Generate private key
        privateKey = new BigInteger(keySize, random);

        // Calculate public key: G^privateKey mod P
        publicKey = agreedPrimitiveRootG.modPow(
                privateKey,
                agreedPrimeP
        );
    }

    BigInteger getPublicKey() {
        return publicKey;
    }

    BigInteger getSharedKey(BigInteger receivedPublicKey) {
        // Calculate shared secret:
        // receivedPublicKey^privateKey mod P
        return receivedPublicKey.modPow(
                privateKey,
                agreedPrimeP
        );
    }

    public static void main(String[] args) {

        // Publicly agreed values
        BigInteger primeP = new BigInteger("23");
        BigInteger baseG = new BigInteger("19");

        // Create Alice and Bob
        DiffieHellman alice =
                new DiffieHellman(512, baseG, primeP);

        DiffieHellman bob =
                new DiffieHellman(512, baseG, primeP);

        // Exchange public keys
        BigInteger alicePublicKey = alice.getPublicKey();
        BigInteger bobPublicKey = bob.getPublicKey();

        System.out.println("Alice Public Key: " + alicePublicKey);
        System.out.println("Bob Public Key: " + bobPublicKey);

        // Generate shared secret keys
        BigInteger aliceSharedSecretKey =
                alice.getSharedKey(bobPublicKey);

        BigInteger bobSharedSecretKey =
                bob.getSharedKey(alicePublicKey);

        // Compare shared secret keys
        if (aliceSharedSecretKey.equals(bobSharedSecretKey)) {

            System.out.println("\nShared secret keys match!");
            System.out.println(
                    "Shared Secret Key = " + aliceSharedSecretKey
            );

        } else {

            System.out.println("\nShared secret keys do not match!");
        }
    }
}
