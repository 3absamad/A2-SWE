package controle;

import repo.DatabaseManager;
import java.util.List;

public class ReportController {
    private DatabaseManager db = new DatabaseManager();

    public String generateReport() {
        List<String> transactions = db.getAllTransactions();
        if (transactions.isEmpty()) {
            return "No transactions found to generate report.";
        }

        double totalSpending = 0;
        StringBuilder reportDetails = new StringBuilder();
        reportDetails.append("--- Report Details ---\n");

        for (String line : transactions) {
            String[] data = line.split(",");
            double amount = Double.parseDouble(data[0]);
            totalSpending += amount;
            reportDetails.append("Category: ").append(data[1])
                    .append(" | Amount: ").append(amount)
                    .append(" | Date: ").append(data[2]).append("\n");
        }

        return reportDetails.toString() + "\nTotal Spending: " + totalSpending;
    }
}