import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("user123", "1234");

        System.out.print("Enter User ID: ");
        String id = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (user.validate(id, pin)) {
            System.out.println("Login Successful!");

            BankAccount account = new BankAccount();
            TransactionHistory history = new TransactionHistory();
            ATM atm = new ATM(account, history);

            atm.start();
        } else {
            System.out.println("Invalid User ID or PIN!");
        }
    }
}
