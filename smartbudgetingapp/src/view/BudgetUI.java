package view;

import controle.BudgetController;
import java.util.Scanner;

public class BudgetUI {
    private BudgetController controller = new BudgetController();

    public void showBudgetForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Edit Budget Limit ---");
        System.out.print("Enter New Budget Limit: ");
        double limit = scanner.nextDouble();

        if (controller.updateBudget(limit)) {
            System.out.println("Budget updated successfully!");
        } else {
            System.out.println("Invalid limit! Please enter a positive number.");
        }
    }
}