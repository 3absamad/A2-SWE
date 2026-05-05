package view;

import controle.HistoryController;
import java.util.List;

public class HistoryUI {
    private HistoryController controller = new HistoryController();

    public void showHistory() {
        System.out.println("========== Transaction History ==========");
        List<String> history = controller.getTransactionHistory();

        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println(String.format("%-15s | %-15s | %-15s", "Amount", "Category", "Date"));
            System.out.println("----------------------------------------------");
            for (String line : history) {
                String[] data = line.split(",");
                System.out.println(String.format("%-15s | %-15s | %-15s", data[0], data[1], data[2]));
            }
        }
        System.out.println("==========================================");
    }
}