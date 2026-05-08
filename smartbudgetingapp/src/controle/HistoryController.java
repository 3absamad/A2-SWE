package controle;

import java.util.ArrayList;
import java.util.List;
import repo.DatabaseManager;

/**
 * Retrieves and filters transaction history records.
 * Supports filtering by category name or by date.
 * Implements US#9 from the SRS.
 *
 * @author Omar Abdelsamad Hassan
 * @version 1.0
 */

public class HistoryController {

    /** Database manager for reading transaction records. */

    private DatabaseManager db = new DatabaseManager();

    /**
     * Returns all recorded transactions without any filter.
     * @return list of raw transaction strings
     */

    public List<String> getTransactionHistory() {
        return db.getAllTransactions();
    }

    /**
     * Filters transactions by a specific category name.
     * Case-insensitive comparison.
     *
     * @param category the category name to filter by
     * @return list of transactions matching the category
     */

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

    /**
     * Filters transactions by a specific date string.
     *
     * @param date the date to filter by in dd-mm-yyyy format
     * @return list of transactions matching the date
     */
    
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

     /**
     * Returns a summary of a given transaction list.
     * Shows total count and total amount spent.
     *
     * @param transactions list of transaction strings to summarize
     * @return formatted summary string
     */

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