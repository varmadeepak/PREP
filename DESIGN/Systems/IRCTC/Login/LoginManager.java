
public class LoginManager {
    private LoginStrategy loginStrategy;

    public LoginManager() {
        this.loginStrategy = null;
    }
    public void setLoginStrategy(int loginMethod) {
        if(LoginMethods.USERNAME_PASSWORD.ordinal() == loginMethod) {
            loginStrategy = new UserNamePassStrategy();
        }
        else if(LoginMethods.EMAIL_OTP.ordinal() == loginMethod) {
            loginStrategy = new EmailOTPStrategy();
        }
        else {
            loginStrategy = new UserNamePassStrategy();
        }
    }

    public boolean isLoggedIn() {
        boolean hasLoggedIn = loginStrategy.login();
        if(hasLoggedIn) {
            System.out.println("LOGIN SUCCESSFULL");
        }
        else {
            System.out.println("LOGIN_FAILED");
        }
        return hasLoggedIn;
    }

}
