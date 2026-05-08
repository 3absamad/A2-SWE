package controle;

import repo.DatabaseManager;

/**
 * Handles user profile update operations.
 * Validates new profile fields and delegates
 * the update to DatabaseManager.
 *
 * @author Omar Abdelsamad Hassan 
 * @version 1.0
 */

public class SettingsController {

    /** Database manager for updating user profile records. */

    private DatabaseManager db = new DatabaseManager();
    
    /**
     * Updates the user's profile with new information.
     * Validates that name and email are not empty and
     * that the password meets the minimum length requirement.
     *
     * @param oldEmail the user's current email (used to find the record)
     * @param newName  the new full name
     * @param newEmail the new email address
     * @param newPass  the new password — must be at least 6 characters
     * @return true if update succeeded, false if validation failed
     */

    public boolean updateProfile(String oldEmail, String newName, String newEmail, String newPass) {
        if (newName.isEmpty() || newEmail.isEmpty() || newPass.length() < 6) {
            return false;
        }

        db.updateUserSettings(oldEmail, newName, newEmail, newPass);
        return true;
    }
}