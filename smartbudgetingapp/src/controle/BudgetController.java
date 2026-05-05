package controle;

import model.Budget;
import repo.DatabaseManager;

public class BudgetController {
    private DatabaseManager db = new DatabaseManager();

    public boolean updateBudget(double newLimit) {
        if (newLimit < 0) {
            return false;
        }

        Budget budget = new Budget(newLimit);
        db.saveBudget(budget.toString());
        return true;
    }
}