import java.util.Scanner;

public class UserNamePassStrategy implements LoginStrategy {

    @Override
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter UserName : ");
        String userName = sc.next();
        System.out.println();

        System.out.println("Enter Password : ");
        String passWord = sc.next();
        System.out.println();
        // VALIDATION LOGIC
        return true;
    }

    @Override
    public String getLoginStrategyName() {
        return "USERNAME/PASSWORD";
    }
    
}
