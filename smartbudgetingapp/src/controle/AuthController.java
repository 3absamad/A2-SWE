package controle;

import app.Main;
import java.util.List;
import model.UserAccount;
import repo.DatabaseManager;

/**
 * Handles all authentication logic for the application.
 * Responsible for user registration and login validation.
 * Reads and writes user data through DatabaseManager.
 *
 * @author Omar Abdelsamad Hassan
 * @version 1.0
 */

public class AuthController {

    /** Database manager instance for reading and writing user data. */
    
    private DatabaseManager db = new DatabaseManager();

     /**
     * Registers a new user after validating all input fields.
     * Checks that the email is not already taken before saving.
     *
     * @param name  the full name of the new user
     * @param email the email address — must be unique in the system
     * @param pass  the password — must be at least 6 characters
     * @return a success or error message string
     */

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

    /**
     * Authenticates a user by checking email and password
     * against stored records. Sets Main.currentUser on success.
     *
     * @param email the user's email address
     * @param pass  the user's password
     * @return true if credentials are valid, false otherwise
     */

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