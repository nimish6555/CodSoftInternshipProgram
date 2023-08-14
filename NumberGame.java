import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yes;
        do {
            Random ran = new Random();
            int no = ran.nextInt(100);
            int n = 5;
            int i, guess, score = 10;
            System.out.println("The Random number is between 1 to 100 ");
            System.out.println("You have only 5 trials");
            for (i = 0; i < n; i++) {
                System.out.println("Guess the number:");
                guess = sc.nextInt();
                if (no == guess) {
                    System.out.println("Congratulations! You guessed the number.");
                    System.out.println("Your score is: " + score);
                    break;
                } else if (no > guess) {
                    System.out.println("The number is greater than " + guess);
                    score = score - 2;
                } else if (no < guess) {
                    System.out.println("The number is less than " + guess);
                    score = score - 2;
                }
            }
            if (i == n) {
                System.out.println("You have executed Only 5 trials");
                System.out.println("Your score is: " + score);
                System.out.println("The number was " + no);
            }
            System.out.println("Do you want to replay this game PRESS 'y' for yes");
            yes = sc.next();
        } while (yes.equalsIgnoreCase("y"));
    }

}
