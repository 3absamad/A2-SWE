package model;

/**
 * Represents a registered user of the Smart Budget App.
 * Stores the user's full name, email, and password.
 *
 * @author Omar Abdelsamad Hassan
 * @version 1.0
 */

public class UserAccount {

    /** The user's full name. */
    private String fullName;

    /** The user's email address — used as login identifier. */
    private String email;
    
    /** The user's password. */
    private String password;

    public UserAccount(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }


    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}