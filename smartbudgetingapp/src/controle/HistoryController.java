package controle;

import java.util.ArrayList;
import java.util.List;
import repo.DatabaseManager;

public class HistoryController {
    private DatabaseManager db = new DatabaseManager();

    public List<String> getTransactionHistory() {
        return db.getAllTransactions();
    }
    
    public List<String> filterByCategory(String category) {
        List<String> all      = db.getAllTransactions();
        List<String> filtered = new ArrayList<>();
         for (String line : all) {
            String[] data = line.split(",");
            if (data.length > 1 &&
                    data[1].trim().equalsIgnoreCase(category.trim())) {
                filtered.add(line);
            }
        }
        return filtered;
    }
    public List<String> filterByDate(String date) {
        List<String> all      = db.getAllTransactions();
        List<String> filtered = new ArrayList<>();

        for (String line : all) {
            String[] data = line.split(",");
            if (data.length > 2 &&
                    data[2].trim().equals(date.trim())) {
                filtered.add(line);
            }
        }
        return filtered;
    }
    public String getSummary(List<String> transactions) {
        double total = 0;
        for (String line : transactions) {
            String[] data = line.split(",");
            if (data.length > 0) {
                try {
                    total += Double.parseDouble(data[0]);
                } catch (NumberFormatException e) {
                    // skip malformed lines
                }
            }
        }
        return "Total Transactions: " + transactions.size()
                + " | Total Amount: " + total;
    }

}