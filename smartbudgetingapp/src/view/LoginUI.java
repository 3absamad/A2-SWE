package view;

import controle.AuthController;
import java.util.Scanner;

public class LoginUI {
    private AuthController controller = new AuthController();

    public void showLoginForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Login Screen ---");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (controller.login(email, pass)) {
            System.out.println("Login Successful! Welcome back.");
        } else {
            System.out.println("Error: Invalid email or password.");
        }
    }
}