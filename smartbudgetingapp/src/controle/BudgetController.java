package controle;

import model.Budget;
import repo.DatabaseManager;

/**
 * Manages the spending limit (budget) for the user.
 * Validates new budget values and persists them
 * through the DatabaseManager.
 *
 * @author Omar Abdelsamad Hassan
 * @version 1.0
 */

public class BudgetController {

    /** Database manager for saving budget data. */

    private DatabaseManager db = new DatabaseManager();
    
    /**
     * Updates the user's monthly budget limit.
     * Rejects negative or zero values.
     *
     * @param newLimit the new spending limit to set
     * @return true if the update succeeded, false if invalid
     */

    public boolean updateBudget(double newLimit) {
        if (newLimit < 0) {
            return false;
        }

        Budget budget = new Budget(newLimit);
        db.saveBudget(budget.toString());
        return true;
    }
}