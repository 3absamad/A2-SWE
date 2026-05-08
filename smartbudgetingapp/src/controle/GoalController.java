package controle;

import model.Goal;
import repo.DatabaseManager;

/**
 * Handles the creation and persistence of savings goals.
 * Validates goal name and target amount before saving.
 *
 * @author Omar Abdelsamad Hassan
 * @version 1.0
 */

public class GoalController {

    /** Database manager for saving goal data. */

    private DatabaseManager db = new DatabaseManager();
    
    /**
     * Creates and saves a new savings goal.
     *
     * @param name   the name of the goal (e.g. New Car)
     * @param amount the target amount to save — must be positive
     * @return true if the goal was saved, false if input is invalid
     */

    public boolean addGoal(String name, double amount) {
        if (name.isEmpty() || amount <= 0) {
            return false;
        }

        Goal newGoal = new Goal(name, amount);
        db.saveGoal(newGoal.toString());
        return true;
    }
}