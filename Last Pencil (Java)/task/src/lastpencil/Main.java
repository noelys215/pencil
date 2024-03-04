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
            String input = scanner.nextLine().trim();
            try {
                pencils = Integer.parseInt(input);
                if (pencils <= 0) {
                    System.out.println("The number of pencils should be positive");
                } else {
                    return pencils;
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        } while (true);
    }

    private static String getFirstPlayerName() {
        String name;
        do {
            System.out.println("Who will be the first (John, Jack):");
            name = scanner.nextLine().trim();
            if (!"John".equalsIgnoreCase(name) && !"Jack".equalsIgnoreCase(name)) {
                System.out.println("Choose between 'John' and 'Jack'");
            } else {
                return name;
            }
        } while (true);
    }

    private static int getPlayerMove(int pencilsLeft) {
        int move;
        do {
            String input = scanner.nextLine().trim();
            try {
                move = Integer.parseInt(input);
                if (move >= 1 && move <= 3 && move <= pencilsLeft) {
                    return move;
                } else {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            } catch (NumberFormatException e) {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        } while (true);
    }

    private static int botMove(int pencils) {
        // If only one pencil is left, the bot must take it.
        if (pencils == 1) {
            return 1;
        }
        // If the bot is in a winning position, it takes enough pencils to leave
        // a multiple of 4 for the opponent, forcing a win.
        if (pencils % 4 != 1) {
            return (pencils - 1) % 4; // Take enough to leave a multiple of 4
        }
        // Otherwise, bot takes a random valid number of pencils.
        return random.nextInt(3) + 1;
    }
}
