package controle;

import repo.DatabaseManager;

public class SettingsController {
    private DatabaseManager db = new DatabaseManager();

    public boolean updateProfile(String oldEmail, String newName, String newEmail, String newPass) {
        if (newName.isEmpty() || newEmail.isEmpty() || newPass.length() < 6) {
            return false;
        }

        db.updateUserSettings(oldEmail, newName, newEmail, newPass);
        return true;
    }
}