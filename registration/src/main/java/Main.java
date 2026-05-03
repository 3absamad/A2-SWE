import controller.AuthController;
import view.RegistrationView;
 
public class Main {
    public static void main(String[] args) {
        System.out.println("[New User] Click Sign Up");
 
        RegistrationView view = new RegistrationView();
        AuthController controller = new AuthController(view);
        view.setController(controller);
 
        view.showForm();
    }
}