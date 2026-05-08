package model;

/**
 * Represents the user's monthly spending limit.
 * Stores a single limit value used to validate transactions.
 *
 * @author Omar Abdelsamad Hassan
 * @version 1.0
 */

public class Budget {
    private double limit;

    public Budget(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return String.valueOf(limit);
    }
}