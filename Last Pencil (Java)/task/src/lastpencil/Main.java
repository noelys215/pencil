package lastpencil;

import java.util.Scanner;

public class Main {
    // Class-wide scanner to read from the console
    static Scanner scanner = new Scanner(System.in);
    // Number of pencils in the game
    static int numPencils = 0;
    // Names of the players as constants
    final static String playerOne = "John";
    final static String playerTwo = "Jack";
    // Current player's name
    static String name;
    // Flag to check if the game is over
    static boolean gameOver = false;

    public static void main(String[] args) {
        // Initialize the game with the first inputs from the player
        takeFirstInput();
        // Print the initial state of pencils
        printPencils();

        // Main game loop, runs until pencils are finished
        while (Main.numPencils > 0) {
            // Print the current player's turn
            printPlayerTurn();
            // Prompt the player to take pencils and apply the game rules
            takePencils();
            if (Main.gameOver) {
                // If game over, change player to announce the winner and break the loop
                changePlayer();
                System.out.printf("%s won!%n", Main.name);
                break;
            }
            // Print the current state of pencils
            printPencils();
            // Change turn to the next player
            changePlayer();
        }
    }

    // Method to switch the current player
    public static void changePlayer() {
        Main.name = Main.name.equals(Main.playerOne) ? Main.playerTwo : Main.playerOne;
    }

    // Method to print the current player's turn
    public static void printPlayerTurn() {
        System.out.printf("%s's turn!%n", Main.name);
    }

    // Method to print the visual representation of pencils left
    public static void printPencils() {
        for (int i = 0; i < Main.numPencils; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    // Method to handle the player's action of taking pencils
    public static void takePencils() {
        int pencils = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                // Read and validate the number of pencils the player wants to take
                pencils = Integer.parseInt(Main.scanner.nextLine().trim());
                if (!(pencils >= 1 && pencils <= 3)) {
                    System.out.println("Possible values: '1', '2' or '3'");
                    continue;
                }
                if (pencils > Main.numPencils) {
                    System.out.println("Too many pencils were taken");
                    continue;
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
        // Update the number of pencils left and check if the game is over
        Main.numPencils -= pencils;
        Main.gameOver = Main.numPencils == 0;
    }

    // Method to choose who will be the first player
    public static String chooseFirstName() {
        String name;
        System.out.printf("Who will be the first (%s, %s)%n", Main.playerOne, Main.playerTwo);
        while (true) {
            name = scanner.nextLine();
            if (name.equals(Main.playerOne) || name.equals(Main.playerTwo)) {
                break;
            }
            System.out.printf("Choose between %s or %s%n", Main.playerOne, Main.playerTwo);
        }
        return name;
    }

    // Method to ask the player for the initial number of pencils
    public static int askPencils() {
        int pencils = 0;
        boolean validInput = false;

        System.out.println("How many pencils would you like to use:");
        while (!validInput) {
            try {
                pencils = Integer.parseInt(Main.scanner.nextLine().trim());

                if (pencils <= 0) {
                    System.out.println("The number of pencils should be positive");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }
        return pencils;
    }

    // Method to take the first input: number of pencils and first player's name
    public static void takeFirstInput() {
        Main.numPencils = askPencils();
        Main.name = chooseFirstName();
    }
}
