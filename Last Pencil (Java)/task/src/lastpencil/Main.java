package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("How many pencils would you like to use:");
        int pencils = scanner.nextInt();
        scanner.nextLine();  // Consume the rest of the line

        System.out.println("Who will be the first (John, Jack):");
        String currentPlayer = scanner.nextLine();
        boolean isBotTurn = "Jack".equalsIgnoreCase(currentPlayer);

        while (pencils > 0) {
            System.out.println("|".repeat(pencils));

            int pencilsTaken;
            if (isBotTurn) {
                pencilsTaken = botMove(pencils);
                System.out.println("Jack's turn:");
                System.out.println(pencilsTaken);
            } else {
                System.out.println(currentPlayer + "'s turn:");
                pencilsTaken = scanner.nextInt();
                scanner.nextLine();  // Consume the rest of the line
            }

            pencils -= pencilsTaken;
            isBotTurn = !isBotTurn; // Switch turns
        }

        String winner = isBotTurn ? "John" : "Jack";
        System.out.println(winner + " won!");
    }

    private static int botMove(int pencils) {
        // Bot is in a losing position if pencils modulo 4 equals 1.
        if (pencils % 4 == 1) {
            // Bot takes a random number between 1 and 3
            return random.nextInt(3) + 1;
        } else {
            // Winning strategy: leave a number of pencils that is one more than a multiple of 4
            // Bot takes enough pencils to make the total number of pencils left modulo 4 equals 1
            return (pencils - 1) % 4 == 0 ? 3 : (pencils - 1) % 4;
        }
    }
}
