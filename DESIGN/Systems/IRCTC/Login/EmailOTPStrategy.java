import java.util.Scanner;
class EmailOTPStrategy implements LoginStrategy {

    @Override
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter EMAIL : ");
        String userName = sc.next();
        System.out.println();

        System.out.println("Enter OTP : ");
        String passWord = sc.next();
        System.out.println();
        // VALIDATION LOGIC
        return true;
    }

    @Override
    public String getLoginStrategyName() {
        return "EMAIL/OTP";
    }
    
}