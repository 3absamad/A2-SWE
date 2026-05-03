package view;

import controller.AuthController;
import java.util.Scanner;

public class RegistrationView {

    private AuthController controller;

    public void setController(AuthController controller) {
        this.controller = controller;
    }

    public void showForm() {
        System.out.println("\n Registration Form ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("name:");
        String name = scanner.nextLine();

        System.out.print("email: ");
        String email = scanner.nextLine();

        System.out.print("password: ");
        String password = scanner.nextLine();

        controller.handleRegistration(name, email, password);
    }

    public void showSuccess() {
        System.out.println("[RegistrationView] show success ");
    }

    public void showError(String message) {
        System.out.println("[RegistrationView] Error: " + message);
    }

    public void redirectToDashboard() {
        System.out.println("[RegistrationView] Redirect to Dashboard!");
    }
}