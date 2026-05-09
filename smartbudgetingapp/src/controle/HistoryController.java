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

}