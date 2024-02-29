import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read K, N, and M from the input
        long K = scanner.nextLong();
        int N = scanner.nextInt();
        double M = scanner.nextDouble();

        // Variable to hold the current seed
        long seed = K;

        // Random number generator
        Random generator;

        // Iterate over the seeds starting from K
        while (true) {
            // Initialize the random generator with the current seed
            generator = new Random(seed);

            // To check if all N numbers are less than or equal to M
            boolean allLessOrEqual = true;

            // Generate N Gaussian numbers and check if they are all less than or equal to M
            for (int i = 0; i < N; i++) {
                if (generator.nextGaussian() > M) {
                    allLessOrEqual = false;
                    break;
                }
            }

            // If the condition is satisfied, break the loop
            if (allLessOrEqual) {
                break;
            }

            // Go to the next seed
            seed++;
        }

        // Print the seed that satisfies the condition
        System.out.println(seed);
    }

}