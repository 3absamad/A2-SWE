package view;

import controle.AuthController;
import java.util.Scanner;

public class RegistrationUI {
    private AuthController controller = new AuthController();

    public void showForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== User Registration ===");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();

        String result = controller.register(name, email, pass);
        System.out.println(result);
    }
}