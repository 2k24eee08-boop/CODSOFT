import java.util.Scanner;

public class BankDashboardATM {

    static double balance = 10000;
    static int pin = 1234;
    static int transactionCount = 0;

    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionCount++;
            System.out.println("✓ Deposit Successful");
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            transactionCount++;
            System.out.println("✓ Withdrawal Successful");
        }
    }

    public static void changePin(Scanner sc) {
        System.out.print("Enter Current PIN: ");
        int oldPin = sc.nextInt();

        if (oldPin == pin) {
            System.out.print("Enter New PIN: ");
            pin = sc.nextInt();
            System.out.println("✓ PIN Changed Successfully");
        } else {
            System.out.println("Incorrect Current PIN");
        }
    }

    public static void showDashboard() {
        System.out.println("\n==================================");
        System.out.println("        DIGITAL BANK ATM");
        System.out.println("==================================");
        System.out.println("1 -> Deposit Money");
        System.out.println("2 -> Withdraw Money");
        System.out.println("3 -> Check Balance");
        System.out.println("4 -> Change PIN");
        System.out.println("5 -> Transaction Details");
        System.out.println("6 -> Exit");
        System.out.println("==================================");
        System.out.print("Select Option: ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("      WELCOME TO DIGITAL ATM");
        System.out.println("==================================");

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("Access Denied! Wrong PIN.");
            sc.close();
            return;
        }

        int choice;

        do {
            showDashboard();
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Amount to Deposit: ₹");
                    deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Amount to Withdraw: ₹");
                    withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Available Balance: ₹" + balance);
                    break;

                case 4:
                    changePin(sc);
                    break;

                case 5:
                    System.out.println("Total Transactions: " + transactionCount);
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 6:
                    System.out.println("Thank You For Banking With Us!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}