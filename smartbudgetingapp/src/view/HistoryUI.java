package view;

import controle.HistoryController;
import java.util.List;
import java.util.Scanner;

public class HistoryUI {
    private HistoryController controller = new HistoryController();

    public void showHistory() {
    
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== Transaction History ==========");
        System.out.println("Filter options:");
        System.out.println("1. Show All");
        System.out.println("2. Filter by Category");
        System.out.println("3. Filter by Date");
        System.out.print("Choose filter: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        List<String> transactions;

        switch (choice) {
            case 2:
                System.out.print("Enter category "
                        + "(e.g. Food, Transport): ");
                String category = scanner.nextLine();
                transactions =
                        controller.filterByCategory(category);
                if (transactions.isEmpty()) {
                    System.out.println(
                        "No transactions found "
                        + "for category: " + category);
                    return;
                }
                break;
                case 3:
                System.out.print(
                        "Enter date (dd-mm-yyyy): ");
                String date = scanner.nextLine();
                transactions =
                        controller.filterByDate(date);
                if (transactions.isEmpty()) {
                    System.out.println(
                        "No transactions found "
                        + "for date: " + date);
                    return;
                }
                break;

            default:
                transactions =
                        controller.getTransactionHistory();
                if (transactions.isEmpty()) {
                    System.out.println(
                            "No transactions found.");
                    return;
                }
                break;
        }

        System.out.println(String.format("%-15s | %-15s | %-15s", "Amount", "Category", "Date"));
        System.out.println("----------------------------------------------");
        
        for (String line : transactions) {
            String[] data = line.split(",");
            if (data.length >= 3) {
                System.out.println(String.format("%-15s | %-15s | %-15s", data[0], data[1], data[2]));
            }
        }
        System.out.println("==========================================");
    }
}