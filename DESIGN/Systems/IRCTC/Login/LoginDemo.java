
public class LoginDemo {
    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager();
        loginManager.setLoginStrategy(1);
        loginManager.isLoggedIn();
    }
}
