package view;

import controle.TransactionController;
import java.util.Scanner;

public class TransactionUI {
    private TransactionController controller = new TransactionController();

    public void showAddTransactionForm() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Add New Transaction ---");
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Category (e.g. Food, Transport): ");
        String category = scanner.nextLine();

        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = scanner.nextLine();

        String result = controller.addTransaction(amount, category, date);
        System.out.println(result);
    }
}