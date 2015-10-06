
import java.math.BigInteger;
import java.util.Random;

public class LimerickPrime {
    // End of lines 1, 2, and 5.
    static byte[] X = { '1', '3', '9' };

    // End of lines 3 and 4.
    static byte[] Y = { '1', '2', '3', '4', '5', '6', '8', '9' };

    // Inner digits. Could in principle use 0 or 7, but that would
    // require shortening the number. The number would sound better, though.
    static byte[] INNER = { '1', '2', '3', '4', '5', '6', '8', '9' };

    public static void main(String[] args) {
        // Deterministic.
        Random random = new Random(1);

        byte[] digits = new byte[34];

        while (true) {
            // Make the initial number with random contents.
            for (int i = 0; i < digits.length; i++) {
                digits[i] = INNER[random.nextInt(INNER.length)];
            }

            // Try all valid values for x and y.
            for (byte x : X) {
                digits[7] = x;
                digits[15] = x;
                digits[33] = x;

                for (byte y : Y) {
                    digits[20] = y;
                    digits[25] = y;

                    BigInteger number = new BigInteger(new String(digits));
                    if (number.isProbablePrime(30)) {
                        // Found one.
                        System.out.println(number);
                    }
                }
            }
        }
    }
}
