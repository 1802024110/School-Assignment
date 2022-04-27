import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        String user = "admin";
        String pass = "admin";

        for (int i = 0; i < 3; i++) {
            System.out.println("Username: ");
            Scanner username = new Scanner(System.in);
             String username1 =  username.nextLine();
            System.out.println("Password: ");
            Scanner password = new Scanner(System.in);
            String password1 = password.nextLine();
            if (username1.equals(user) && password1.equals(pass)) {
                System.out.println("Login Successful");
                return ;
            }
            else {
                System.out.println("Login Failed");
            }
        }
        System.out.println("Too many failed attempts");
    }
}
