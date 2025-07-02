import java.util.Scanner;

public class bankapp {
    private static double balance = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("****Welcome to ABC Bank!****");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using ABC Bank. GOODBYE!");
                    break;
                default:
                    System.out.println("INVALID Choice. Please choose 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void checkBalance() {
        System.out.printf("Your current balance is: RM %.2f\n", balance);
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to DEPOSIT: RM ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("RM %.2f deposited successfully.\n", amount);
        } else {
            System.out.println("INVALID Amount. Deposit must be more than RM 0.00");
        }
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to WITHDRAW: RM ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("RM %.2f WITHDRAWN successfully.\n", amount);
        } else if (amount > balance) {
            System.out.println("INSUFFICIENT Balance");
        } else {
            System.out.println("INVALID Amount. Withdrawal must be more than RM 0.00");
        }
    }
}
