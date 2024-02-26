package lastpencil;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int numPencils = 0;
    final static String playerOne = "John";
    final static String playerTwo = "Jack";
    static String name;
    static boolean gameOver = false;

    public static void main(String[] args) {

        takeFirstInput();
        printPencils();

        while (Main.numPencils > 0) {
            printPlayerTurn();
            takePencils();
            if (Main.gameOver) {
                changePlayer();
                System.out.printf("%s won!%n", Main.name);
                break;
            }
            printPencils();
            changePlayer();
        }

    }



    public static void changePlayer() {
        Main.name = Main.name.equals(Main.playerOne) ? Main.playerTwo : Main.playerOne;
    }
    public static void printPlayerTurn() {
        System.out.printf("%s's turn!%n", Main.name);
    }

    public static void printPencils() {
        for (int i = 0; i < Main.numPencils; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    public static void takePencils() {
        int pencils = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
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
        Main.numPencils -= pencils;
        Main.gameOver = Main.numPencils == 0;
    }

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

    public static void takeFirstInput() {
        Main.numPencils = askPencils();
        Main.name = chooseFirstName();
    }


}
