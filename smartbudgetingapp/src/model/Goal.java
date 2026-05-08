package model;

/**
 * Represents a savings goal set by the user.
 * Stores the goal name and the target amount to save.
 *
 * @author Omar Abdelsamad Hassan 
 * @version 1.0
 */

public class Goal {
    private String goalName;
    private double targetAmount;

    public Goal(String goalName, double targetAmount) {
        this.goalName = goalName;
        this.targetAmount = targetAmount;
    }

    public String getGoalName() { return goalName; }
    public double getTargetAmount() { return targetAmount; }

    @Override
    public String toString() {
        return goalName + "," + targetAmount;
    }
}