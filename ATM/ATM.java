import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private TransactionHistory history;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account, TransactionHistory history) {
        this.account = account;
        this.history = history;
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    history.show();
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    if (account.withdraw(w)) {
                        history.add("Withdrawn: Rs " + w);
                        System.out.println("Withdraw successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    account.deposit(d);
                    history.add("Deposited: Rs " + d);
                    System.out.println("Deposit successful.");
                    break;

                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double t = sc.nextDouble();
                    if (account.transfer(t)) {
                        history.add("Transferred: Rs " + t);
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
