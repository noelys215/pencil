package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        int pencils = 0;
        // Ask for the initial number of pencils, ensuring it is a positive number
        while (pencils <= 0) {
            System.out.println("How many pencils would you like to use:");
            String input = scanner.nextLine();
            try {
                pencils = Integer.parseInt(input);
                if (pencils <= 0) {
                    System.out.println("The number of pencils should be positive");
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

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
                while (!scanner.hasNextInt()) {
                    System.out.println("Possible values: '1', '2' or '3'");
                    scanner.next(); // consume the non-integer input
                }
                pencilsTaken = scanner.nextInt();
                scanner.nextLine(); // consume the newline after the number
            }

            pencils -= pencilsTaken;
            isBotTurn = !isBotTurn; // Switch turns
        }

        String winner = isBotTurn ? "John" : "Jack";
        System.out.println(winner + " won!");
    }

    private static int botMove(int pencils) {
        if (pencils % 4 == 1) {
            // Bot is in a losing position, takes a random number between 1 and 3
            return random.nextInt(3) + 1;
        } else {
            // Winning strategy: leave a number of pencils that is one more than a multiple of 4
            return (pencils - 1) % 4;
        }
    }
}
