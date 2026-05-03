package controle;

import model.Transaction;
import repo.DatabaseManager;
import java.util.List;

public class TransactionController {
    private DatabaseManager db = new DatabaseManager();

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