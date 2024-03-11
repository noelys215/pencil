package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] participants = new String[3];
        Scanner scanner = new Scanner(System.in);
        String howManyPencils;
        String whoWillBe;
        int user = -1;
        int boot = 0;
        String takenPencils;
        participants[0] = "John";
        participants[1] = "Jack";

        System.out.println("How many pencils would you like to use:");
        do {
            howManyPencils = scanner.nextLine();
        } while (!howManyPencilsValidate(howManyPencils));

        System.out.println("Who will be the first (" + participants[0] + ", " + participants[1] + "):");
        do {
            whoWillBe = scanner.nextLine();
        } while (!participantValidate(whoWillBe, participants));

        if (whoWillBe.equals(participants[0])) {
            user = 0;
            boot = 1;
        }
        if (whoWillBe.equals(participants[1])) {
            user = 1;
            boot = 1;
        }

        do {
            for (int i = 0; i < Integer.parseInt(howManyPencils); i++) System.out.print("|");
            System.out.println("\n" + participants[user] + "'s turn!");
            if (user == boot) takenPencils = playBoot(howManyPencils);
            else do {
                takenPencils = scanner.nextLine();
            } while (!takenPencilsValidate(takenPencils, howManyPencils));

            howManyPencils = String.valueOf(Integer.parseInt(howManyPencils) - Integer.parseInt(takenPencils));
            if (user == 0) user = 1;
            else user = 0;
        } while (Integer.parseInt(howManyPencils) > 0);

        if (user == 0) System.out.println(participants[0] + " won!");
        else System.out.println(participants[1] + " won!");

    }

    public static boolean participantValidate(String string, String[] participants) {
        if (string.equals(participants[0]) || string.equals(participants[1])) {
            return true;
        } else {
            System.out.println("Choose between 'John' and 'Jack'");
            return false;
        }
    }


    private static boolean howManyPencilsValidate(String howManyPencils) {
        if (isNumber(howManyPencils)) {
            System.out.println("The number of pencils should be numeric");
            return false;
        }

        if (howManyPencils.equals("0")) {
            System.out.println("The number of pencils should be positive");
            return false;
        }

        if (Integer.parseInt(howManyPencils) < 0) {
            System.out.println("The number of pencils should be numeric");
            return false;
        }

        return true;
    }

    private static boolean takenPencilsValidate(String takenPencils, String howManyPencils) {
        if (
                isNumber(takenPencils) ||
                        Integer.parseInt(takenPencils) > 3 ||
                        Integer.parseInt(takenPencils) < 0 ||
                        takenPencils.equals("0")) {
            System.out.println("Possible values: '1', '2' or '3'");
            return false;
        }

        if (Integer.parseInt(takenPencils) > Integer.parseInt(howManyPencils)) {
            System.out.println("Too many pencils were taken");
            return false;
        }

        return true;
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    static String playBoot(String howManyPencils) {
        String takenPencils = "0";
        if (((Integer.parseInt(howManyPencils) - 5) % 4) == 0) {
            takenPencils = String.valueOf(new Random().nextInt(1, 4));
        }
        if (howManyPencils.equals("1")) {
            takenPencils = String.valueOf(1);
        }
        if ((Integer.parseInt(howManyPencils) % 4) == 0) {
            takenPencils = String.valueOf(3);
        }
        if (((Integer.parseInt(howManyPencils) + 1) % 4) == 0) {
            takenPencils = String.valueOf(2);
        }
        if (((Integer.parseInt(howManyPencils) + 2) % 4) == 0) {
            takenPencils = String.valueOf(1);
        }
        System.out.println(takenPencils);
        return takenPencils;
    }

}