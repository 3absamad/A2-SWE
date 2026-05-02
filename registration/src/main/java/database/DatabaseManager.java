package database;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class DatabaseManager {

    private static List<User> users = new ArrayList<>();

    public boolean emailExists(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public void saveRecord(User user) {
        users.add(user);
        System.out.println("[DatabaseManager] saveRecord -> " + user);
    }
}