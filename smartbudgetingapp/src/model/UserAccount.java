package model;

public class UserAccount {
    private String fullName;
    private String email;
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