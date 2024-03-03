package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        int pencils = getPencils();
        String currentPlayer = getFirstPlayerName();
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
                pencilsTaken = getPlayerMove(pencils);
            }

            pencils -= pencilsTaken;
            isBotTurn = !isBotTurn; // Switch turns
        }

        String winner = isBotTurn ? "John" : "Jack";
        System.out.println(winner + " won!");
    }

    private static int getPencils() {
        int pencils;
        do {
            System.out.println("How many pencils would you like to use:");
            while (!scanner.hasNextInt()) {
                System.out.println("The number of pencils should be numeric");
                scanner.next(); // discard non-numeric input
            }
            pencils = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (pencils <= 0) {
                System.out.println("The number of pencils should be positive");
            }
        } while (pencils <= 0);
        return pencils;
    }

    private static String getFirstPlayerName() {
        String name;
        do {
            System.out.println("Who will be the first (John, Jack):");
            name = scanner.nextLine().trim();
            if (!"John".equalsIgnoreCase(name) && !"Jack".equalsIgnoreCase(name)) {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        } while (!"John".equalsIgnoreCase(name) && !"Jack".equalsIgnoreCase(name));
        return name;
    }

    private static int getPlayerMove(int pencilsLeft) {
        int move;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Possible values: '1', '2' or '3'");
                scanner.next(); // discard invalid input
            }
            move = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (move < 1 || move > 3) {
                System.out.println("Possible values: '1', '2' or '3'");
            } else if (move > pencilsLeft) {
                System.out.println("Too many pencils were taken");
                move = 0; // reset move to invalid so the loop continues
            }
        } while (move < 1 || move > 3);
        return move;
    }

    private static int botMove(int pencils) {
        if (pencils % 4 == 1) {
            // Bot takes a random number between 1 and 3
            return random.nextInt(3) + 1;
        } else {
            // Winning strategy: leave a number of pencils that is one more than a multiple of 4
            return (pencils - 1) % 4 == 0 ? 3 : (pencils - 1) % 4;
        }
    }
}
