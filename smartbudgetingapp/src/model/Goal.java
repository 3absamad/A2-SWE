package model;

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