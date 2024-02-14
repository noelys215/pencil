import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // Read the input string
        StringBuilder doubledString = new StringBuilder();

        // Iterate over each character and append it twice to the StringBuilder
        for (char ch : input.toCharArray()) doubledString.append(ch).append(ch);
        // Output the doubled string
        System.out.println(doubledString.toString());
    }
}