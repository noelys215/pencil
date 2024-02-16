package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the initial number of pencils
        System.out.println("How many pencils would you like to use:");
        int pencils = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line

        // Ask who will be the first player
        System.out.println("Who will be the first (John, Jack):");
        String currentPlayer = scanner.nextLine();

        // Game loop
        while (pencils > 0) {
            // Print the current number of pencils
            System.out.println("|".repeat(pencils));

            // Prompt for the current player's move
            System.out.println(currentPlayer + "'s turn:");
            int taken = scanner.nextInt();
            scanner.nextLine(); // Consume the rest of the line

            // Update the number of pencils
            pencils -= taken;

            // Switch to the next player
            currentPlayer = currentPlayer.equals("John") ? "Jack" : "John";
        }
    }
}
