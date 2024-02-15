import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt(); // Number of uppercase letters
        int B = scanner.nextInt(); // Number of lowercase letters
        int C = scanner.nextInt(); // Number of digits
        int N = scanner.nextInt(); // Total length of the password

        System.out.println(generatePassword(A, B, C, N));
    }

    public static String generatePassword(int A, int B, int C, int N) {
        StringBuilder password = new StringBuilder(N);
        int totalUsed = 0;

        // Function to add a character from a given pool to the password
        BiConsumer<StringBuilder, char[]> addChar = (sb, pool) -> {
            char lastChar = sb.length() > 0 ? sb.charAt(sb.length() - 1) : '\u0000';
            char newChar;

            do {
                newChar = pool[new Random().nextInt(pool.length)];
            } while (newChar == lastChar);

            sb.append(newChar);
        };

        // Character pools
        char[] upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digits = "0123456789".toCharArray();

        // Add the minimum required characters first
        for (int i = 0; i < A; i++, totalUsed++) {
            addChar.accept(password, upperCaseLetters);
        }
        for (int i = 0; i < B; i++, totalUsed++) {
            addChar.accept(password, lowerCaseLetters);
        }
        for (int i = 0; i < C; i++, totalUsed++) {
            addChar.accept(password, digits);
        }

        // Fill the rest of the password with a mix of characters, still avoiding repetitions
        while (totalUsed < N) {
            if (totalUsed % 3 == 0) {
                addChar.accept(password, upperCaseLetters);
            } else if (totalUsed % 3 == 1) {
                addChar.accept(password, lowerCaseLetters);
            } else {
                addChar.accept(password, digits);
            }
            totalUsed++;
        }

        return password.toString();
    }
}