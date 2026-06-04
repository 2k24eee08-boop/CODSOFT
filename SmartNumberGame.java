import java.util.*;

public class SmartNumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("================================");
        System.out.println("      SMART NUMBER CHALLENGE");
        System.out.println("================================");

        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        int totalScore = 0;
        char playAgain;

        do {

            System.out.println("\nChoose Difficulty");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");

            int choice = sc.nextInt();

            int range = 100;
            int attempts = 7;

            switch(choice) {
                case 1:
                    range = 50;
                    attempts = 10;
                    break;
                case 2:
                    range = 100;
                    attempts = 7;
                    break;
                case 3:
                    range = 200;
                    attempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice. Medium selected.");
            }

            int secret = random.nextInt(range) + 1;

            System.out.println("\nGuess the number between 1 and " + range);

            long startTime = System.currentTimeMillis();
            boolean win = false;

            for(int i = 1; i <= attempts; i++) {

                System.out.print("Attempt " + i + ": ");
                int guess = sc.nextInt();

                if(guess == secret) {

                    long endTime = System.currentTimeMillis();
                    long seconds = (endTime - startTime) / 1000;

                    int score = (attempts - i + 1) * 20;
                    score += Math.max(0, 50 - (int)seconds);

                    totalScore += score;

                    System.out.println("\nCorrect!");
                    System.out.println("Time Taken : " + seconds + " sec");
                    System.out.println("Round Score: " + score);

                    win = true;
                    break;
                }

                if(guess < secret)
                    System.out.println("Too Low");
                else
                    System.out.println("Too High");

                // Special Hint after half attempts
                if(i == attempts / 2) {
                    System.out.println("\n*** BONUS HINT ***");

                    if(secret % 2 == 0)
                        System.out.println("Number is EVEN");
                    else
                        System.out.println("Number is ODD");

                    if(isPrime(secret))
                        System.out.println("Number is PRIME");
                    else
                        System.out.println("Number is NOT PRIME");
                }
            }

            if(!win) {
                System.out.println("\nGame Over!");
                System.out.println("Correct Number: " + secret);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nPlay Again (Y/N)? ");
            playAgain = sc.next().charAt(0);

        } while(playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n================================");
        System.out.println("Player : " + name);
        System.out.println("Final Score : " + totalScore);
        System.out.println("Thank You For Playing!");
        System.out.println("================================");

        sc.close();
    }

    static boolean isPrime(int n) {

        if(n < 2)
            return false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
}