package controle;

import java.util.List;
import model.Transaction;
import repo.DatabaseManager;

/**
 * Coordinates the full lifecycle of adding a new transaction.
 * Validates the amount against the current budget limit,
 * saves the transaction to storage, and returns a result message.
 *
 * @author Omar Abdelsamad Hassan
 * @version 1.0
 */

public class TransactionController {

    /** Database manager for reading budgets and saving transactions. */
    
    private DatabaseManager db = new DatabaseManager();

    /**
     * Validates and saves a new financial transaction.
     * Checks the transaction amount against the current budget limit.
     * Saves to persistent storage if validation passes.
     *
     * @param amount   the monetary value of the transaction
     * @param category the spending category (e.g. Food, Transport)
     * @param date     the date of the transaction (dd-mm-yyyy)
     * @return a success message or a budget warning string
     */

    public String addTransaction(double amount, String category, String date) {

        List<String> budgets = db.getAllBudgets();
        double limit = 0;
        if (!budgets.isEmpty()) {
            limit = Double.parseDouble(budgets.get(0));
        }

        if (amount > limit && limit > 0) {
            return "Warning: Transaction exceeds your budget limit!";
        }


        Transaction t = new Transaction(amount, category, date);
        db.saveTransaction(t.toString());

        return "Transaction added successfully!";
    }
}