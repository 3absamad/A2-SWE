package controle;

import java.util.List;
import repo.DatabaseManager;

/**
 * Generates financial reports by aggregating transaction data.
 * Computes total spending and formats a readable report string.
 *
 * @author Omar Abdelsamad Hassan 
 * @version 1.0
 */

public class ReportController {

    /** Database manager for fetching transaction records. */

    private DatabaseManager db = new DatabaseManager();
    
    /**
     * Generates a formatted financial report from all transactions.
     * Sums all amounts and lists each transaction by category and date.
     *
     * @return a formatted report string, or a message if no data exists
     */

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