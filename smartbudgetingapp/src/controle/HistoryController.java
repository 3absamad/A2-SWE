package controle;

import repo.DatabaseManager;
import java.util.List;

public class HistoryController {
    private DatabaseManager db = new DatabaseManager();

    public List<String> getTransactionHistory() {
        return db.getAllTransactions();
    }
}