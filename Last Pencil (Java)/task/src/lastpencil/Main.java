package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pencils = 0;

        // Input validation for the number of pencils
        while (true) {
            System.out.println("How many pencils would you like to use:");
            String input = scanner.nextLine();
            try {
                pencils = Integer.parseInt(input);
                if (pencils > 0) {
                    break; // Valid number of pencils
                } else {
                    System.out.println("The number of pencils should be positive");
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        // Input validation for the first player
        String firstPlayer = "";
        while (!firstPlayer.equalsIgnoreCase("John") && !firstPlayer.equalsIgnoreCase("Jack")) {
            System.out.println("Who will be the first (John, Jack):");
            firstPlayer = scanner.nextLine().trim();
            if (!firstPlayer.equalsIgnoreCase("John") && !firstPlayer.equalsIgnoreCase("Jack")) {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }

        // Determine if Jack is the bot and who goes first
        boolean isJackTurn = firstPlayer.equalsIgnoreCase("Jack");
        int move;

        // Game loop
        while (pencils > 0) {
            printPencils(pencils); // Call method to print pencils
            if (isJackTurn) {
                move = bestMove(pencils);
                System.out.println("Jack's turn:");
                System.out.println("> " + move);
            } else {
                System.out.println("John's turn:");
                while (true) {
                    String input = scanner.nextLine();
                    try {
                        move = Integer.parseInt(input);
                        if (move < 1 || move > 3) {
                            System.out.println("Possible values: '1', '2', '3'");
                        } else if (move > pencils) {
                            System.out.println("too many pencils");
                        } else {
                            break; // Valid move
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Possible values: '1', '2', '3'");
                    }
                }
            }

            pencils -= move;
            isJackTurn = !isJackTurn; // Switch turns
        }

        // Determine and announce the winner
        if (isJackTurn) {
            System.out.println("John won!");
        } else {
            System.out.println("Jack won!");
        }

        scanner.close();
    }

    // Method to print the correct number of pencils
    private static void printPencils(int pencils) {
        System.out.println("|".repeat(pencils));
    }

    // Method to determine the best move for Jack (the bot)
    private static int bestMove(int pencils) {
        // If only one pencil is left, Jack must take it
        if (pencils == 1) {
            return 1;
        }
        // Otherwise, follow the winning strategy
        int move = (pencils - 1) % 4;
        return move == 0 ? 1 : move; // Prevent returning 0
    }
}

