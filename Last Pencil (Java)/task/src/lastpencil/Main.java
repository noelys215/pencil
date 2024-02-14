package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Step 1: Ask for the number of pencils
//        System.out.println("How many pencils would you like to use:");
//        int numberOfPencils = scanner.nextInt();
//
//        // Clear the newline from the buffer after reading an int
//        scanner.nextLine();
//
//        // Step 2: Ask who will go first
//        System.out.println("Who will be the first (John, Jack):");
//        String firstPlayer = scanner.nextLine();
//
//        // Validation for the player's name
//        while (!(firstPlayer.equals("John") || firstPlayer.equals("Jack"))) {
//            System.out.println("Choose between John and Jack");
//            firstPlayer = scanner.nextLine();
//        }
//
//        // Step 3: Print the pencils and who is going first
//        for (int i = 0; i < numberOfPencils; i++) System.out.print("|");
//
//        // Move to the next line after printing pencils
//        System.out.println();
//
//        System.out.println(firstPlayer + " is going first!");
//
        char[] chars = {'H', 'Y', 'P', 'E', 'R', '-', 'S', 'K', 'I', 'L', 'L'};

        String stringFromChars = String.valueOf(chars);

        String[] strings = stringFromChars.split("-");

        System.out.println(strings[1]);
    }
}
