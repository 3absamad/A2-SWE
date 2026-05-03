package controle;

import model.Goal;
import repo.DatabaseManager;

public class GoalController {
    private DatabaseManager db = new DatabaseManager();

    public boolean addGoal(String name, double amount) {
        if (name.isEmpty() || amount <= 0) {
            return false;
        }

        Goal newGoal = new Goal(name, amount);
        db.saveGoal(newGoal.toString());
        return true;
    }
}