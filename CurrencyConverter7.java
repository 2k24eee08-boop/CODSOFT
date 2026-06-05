import java.util.Scanner;

public class CurrencyConverter7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] currencies = {
                "INR", "USD", "EUR", "GBP",
                "JPY", "AUD", "CAD"
        };

        // Rates with respect to USD
        double[] rates = {
                83.20,  // INR
                1.00,   // USD
                0.92,   // EUR
                0.79,   // GBP
                157.30, // JPY
                1.52,   // AUD
                1.37    // CAD
        };

        System.out.println("=================================");
        System.out.println("      CURRENCY CONVERTER");
        System.out.println("=================================");

        System.out.println("\nAvailable Currencies:");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i]);
        }

        System.out.print("\nSelect Base Currency (1-7): ");
        int base = sc.nextInt() - 1;

        System.out.print("Select Target Currency (1-7): ");
        int target = sc.nextInt() - 1;

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        // Convert to USD first
        double usdValue = amount / rates[base];

        // Convert USD to target currency
        double convertedAmount = usdValue * rates[target];

        System.out.println("\n========== RESULT ==========");
        System.out.println("Base Currency   : " + currencies[base]);
        System.out.println("Target Currency : " + currencies[target]);
        System.out.println("Amount Entered  : " + amount);
        System.out.printf("Converted Amount: %.2f %s%n",
                convertedAmount, currencies[target]);
        System.out.println("============================");

        sc.close();
    }
}