package repo;

import model.UserAccount;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    public void saveUser(UserAccount user) {
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(user.getFullName() + "," + user.getEmail() + "," + user.getPassword() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving user.");
        }
    }

    public void updateUserSettings(String oldEmail, String newName, String newEmail, String newPass) {
        List<String> users = getAllUsers();
        try (FileWriter writer = new FileWriter("users.txt", false)) {
            for (String line : users) {
                String[] data = line.split(",");
                if (data.length > 1 && data[1].equals(oldEmail)) {
                    writer.write(newName + "," + newEmail + "," + newPass + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating settings.");
        }
    }

    public List<String> getAllUsers() {
        return readFile("users.txt");
    }

    public void saveTransaction(String transactionData) {
        try (FileWriter writer = new FileWriter("transactions.txt", true)) {
            writer.write(transactionData + "\n");
        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }

    public List<String> getAllTransactions() {
        return readFile("transactions.txt");
    }

    public void saveBudget(String budgetData) {
        try (FileWriter writer = new FileWriter("budgets.txt", false)) {
            writer.write(budgetData + "\n");
        } catch (IOException e) {
            System.out.println("Error saving budget.");
        }
    }

    public List<String> getAllBudgets() {
        return readFile("budgets.txt");
    }

    public void saveGoal(String goalData) {
        try (FileWriter writer = new FileWriter("goals.txt", true)) {
            writer.write(goalData + "\n");
        } catch (IOException e) {
            System.out.println("Error saving goal.");
        }
    }

    public List<String> getAllGoals() {
        return readFile("goals.txt");
    }

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