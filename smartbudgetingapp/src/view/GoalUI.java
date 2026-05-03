package view;

import controle.GoalController;
import java.util.Scanner;

public class GoalUI {
    private GoalController controller = new GoalController();

    public void showGoalForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Manage Goals & Savings ---");
        System.out.print("Enter Goal Name (e.g., New Car): ");
        String name = scanner.nextLine();
        System.out.print("Enter Target Amount: ");
        double amount = scanner.nextDouble();

        if (controller.addGoal(name, amount)) {
            System.out.println("Goal set successfully!");
        } else {
            System.out.println("Failed to set goal. Please check your data.");
        }
    }
}