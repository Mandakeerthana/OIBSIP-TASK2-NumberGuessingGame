import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int round = 1;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You need to guess a number between " + minNumber + " and " + maxNumber);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        do {
            int targetNumber = random.nextInt(maxNumber) + 1;
            System.out.println("\n=== Round " + round + " ===");
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    int roundScore = maxAttempts - attempts + 1;
                    score += roundScore;
                    System.out.println("Round Score: " + roundScore + " | Total Score: " + score);
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is lower than the target number.");
                } else {
                    System.out.println("Your guess is higher than the target number.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The target number was: " + targetNumber);
                }
            }

            System.out.print("Do you want to play another round? (y/n): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }

            round++;
        } while (true);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
