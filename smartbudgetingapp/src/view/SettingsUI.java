package view;

import controle.SettingsController;
import java.util.Scanner;

public class SettingsUI {
    private SettingsController controller = new SettingsController();

    public void showSettingsForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Edit Profile Settings ---");

        System.out.print("Enter your CURRENT email: ");
        String oldEmail = scanner.nextLine();

        System.out.print("Enter New Full Name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter New Email: ");
        String newEmail = scanner.nextLine();

        System.out.print("Enter New Password: ");
        String newPass = scanner.nextLine();

        if (controller.updateProfile(oldEmail, newName, newEmail, newPass)) {
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Update failed! Please check your inputs.");
        }
    }
}