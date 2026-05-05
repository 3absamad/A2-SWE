package app;

import view.*;
import model.UserAccount;
import java.util.Scanner;

public class Main {

    public static UserAccount currentUser = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            if (currentUser == null) {
                System.out.println("\n========== Smart Budget App ==========");
                System.out.println("1. Register New User");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                int choice = input.nextInt();

                if (choice == 1) {
                    new RegistrationUI().showForm();
                } else if (choice == 2) {
                    new LoginUI().showLoginForm();
                } else if (choice == 0) {
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("\nWelcome, " + currentUser.getFullName());
                System.out.println("1. Add New Transaction");
                System.out.println("2. Set/Edit Budget");
                System.out.println("3. Manage Goals & Savings");
                System.out.println("4. View Financial Reports");
                System.out.println("5. Edit Profile Settings");
                System.out.println("6. View Transaction History");
                System.out.println("0. Logout");
                System.out.print("Choose an option: ");

                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        new TransactionUI().showAddTransactionForm();
                        break;
                    case 2:
                        new BudgetUI().showBudgetForm();
                        break;
                    case 3:
                        new GoalUI().showGoalForm();
                        break;
                    case 4:
                        new ReportUI().showReport();
                        break;
                    case 5:
                        new SettingsUI().showSettingsForm();
                        break;
                    case 6:
                        new HistoryUI().showHistory();
                        break;
                    case 0:
                        currentUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }
}