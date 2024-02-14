import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        String s = parts[0];
        int n = Integer.parseInt(parts[1]);

        if (n > s.length()) {
            System.out.println(s); // n is greater than the length of s, print s unchanged
        } else {
            String moved = s.substring(n) + s.substring(0, n); // Move the first n characters
            System.out.println(moved);
        }
    }
}