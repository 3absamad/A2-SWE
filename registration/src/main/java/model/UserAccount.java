package model;

import database.DatabaseManager;

public class UserAccount {

    private DatabaseManager dbManager;

    public UserAccount(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public boolean createAccount(String name, String email, String password) {
        System.out.println("[UserAccount] createAccount: ");

        User user = new User(name, email, password);
        dbManager.saveRecord(user);
        saveUser(user);

        System.out.println("[UserAccount] accountCreated");
        return true;
    }

    private void saveUser(User user) {
        System.out.println("[UserAccount] saveUser: saved" + user.getEmail());
    }
}