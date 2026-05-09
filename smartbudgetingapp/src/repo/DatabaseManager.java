package repo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.UserAccount;

/**
 * Central data persistence manager for the Smart Budget App.
 * Uses plain text files (.txt) as the storage backend.
 * Each entity type (users, transactions, budgets, goals)
 * has its own dedicated file.
 * This class is the only component that performs file I/O.
 *
 * @author Omar Abdelsamad Hassan 
 * @version 1.0
 */


public class DatabaseManager {

    /**
     * Saves a new user account to users.txt.
     * Appends the record so existing users are preserved.
     *
     * @param user the UserAccount object to save
     */

    public void saveUser(UserAccount user) {
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(user.getFullName() + "," + user.getEmail() + "," + user.getPassword() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving user.");
        }
    }

    /**
     * Updates an existing user's profile in users.txt.
     * Finds the record by old email and replaces it.
     *
     * @param oldEmail the current email used to locate the record
     * @param newName  the updated full name
     * @param newEmail the updated email address
     * @param newPass  the updated password
     */

    public boolean updateUserSettings(String oldEmail, String newName, String newEmail, String newPass) {
        List<String> users = getAllUsers();
        boolean userFound = false;

        try (FileWriter writer = new FileWriter("users.txt", false)) {
            for (String line : users) {
                String[] data = line.split(",");
                if (data.length > 1 && data[1].equals(oldEmail)) {
                    writer.write(newName + "," + newEmail + "," + newPass + "\n");
                    userFound = true;

                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating settings.");
            return false;
        }
        return userFound;
    }

    /**
     * Reads all user records from users.txt.
     * @return list of raw user data strings
     */

    public List<String> getAllUsers() {
        return readFile("users.txt");
    }

    /**
     * Saves a new transaction record to transactions.txt.
     * @param transactionData the formatted transaction string
     */

    public void saveTransaction(String transactionData) {
        try (FileWriter writer = new FileWriter("transactions.txt", true)) {
            writer.write(transactionData + "\n");
        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }

    /**
     * Reads all transaction records from transactions.txt.
     * @return list of raw transaction data strings
     */


    public List<String> getAllTransactions() {
        return readFile("transactions.txt");
    }

     /**
     * Saves the current budget limit to budgets.txt.
     * Overwrites the previous value.
     * @param budgetData the budget amount as a string
     */

    public void saveBudget(String budgetData) {
        try (FileWriter writer = new FileWriter("budgets.txt", false)) {
            writer.write(budgetData + "\n");
        } catch (IOException e) {
            System.out.println("Error saving budget.");
        }
    }

    /**
     * Reads the budget limit from budgets.txt.
     * @return list containing the budget value
     */

    public List<String> getAllBudgets() {
        return readFile("budgets.txt");
    }

    /**
     * Saves a new savings goal to goals.txt.
     * @param goalData the formatted goal string
     */

    public void saveGoal(String goalData) {
        try (FileWriter writer = new FileWriter("goals.txt", true)) {
            writer.write(goalData + "\n");
        } catch (IOException e) {
            System.out.println("Error saving goal.");
        }
    }

    /**
     * Reads all savings goals from goals.txt.
     * @return list of raw goal data strings
     */

    public List<String> getAllGoals() {
        return readFile("goals.txt");
    }

    /**
     * Generic file reader used by all get methods.
     * Returns an empty list if the file does not exist.
     *
     * @param fileName the name of the file to read
     * @return list of lines read from the file
     */

    private List<String> readFile(String fileName) {
        List<String> data = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return data;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
        }
        return data;
    }
}