package controller;

import database.DatabaseManager;
import model.UserAccount;
import view.RegistrationView;

public class AuthController {

    private final RegistrationView view;
    private final UserAccount userAccount;
    private final DatabaseManager dbManager;

    public AuthController(RegistrationView view) {
        this.view = view;

        this.dbManager = new DatabaseManager();
        this.userAccount = new UserAccount(dbManager);
    }

    public void handleRegistration(String name, String email, String password) {

        if (!validateInput(name, email, password)) {
            view.showError("the inputs is wrong");
            return;
        }

        if (dbManager.emailExists(email)) {
            view.showError("the email is already exist");
            return;
        }

        boolean success = userAccount.createAccount(name, email, password);

        if (success) {
            view.showSuccess();
            view.redirectToDashboard();
        } else {
            view.showError("there is something wrong");
        }
    }

    private boolean validateInput(String name, String email, String password) {

        if (name == null || name.trim().isEmpty()) return false;
        if (email == null || email.trim().isEmpty()) return false;
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) return false;
        if (password == null || password.trim().length() < 6) return false;

        return true;
    }
}