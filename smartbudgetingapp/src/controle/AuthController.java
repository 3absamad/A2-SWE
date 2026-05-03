package controle;

import model.UserAccount;
import repo.DatabaseManager;
import app.Main;
import java.util.List;

public class AuthController {
    private DatabaseManager db = new DatabaseManager();

    public String register(String name, String email, String pass) {
        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            return "All fields are required!";
        }

        if (pass.length() < 6) {
            return "Error: Password must be at least 6 characters!";
        }

        List<String> users = db.getAllUsers();
        for (String line : users) {
            String[] data = line.split(",");
            if (data.length > 1 && data[1].equals(email)) {
                return "Error: Email already exists!";
            }
        }

        UserAccount newUser = new UserAccount(name, email, pass);
        db.saveUser(newUser);
        return "Success: Account created!";
    }

    public boolean login(String email, String pass) {
        List<String> users = db.getAllUsers();
        for (String line : users) {
            String[] data = line.split(",");

            if (data.length > 2 && data[1].equals(email) && data[2].equals(pass)) {
                Main.currentUser = new UserAccount(data[0], data[1], data[2]);
                return true;
            }
        }
        return false;
    }
}