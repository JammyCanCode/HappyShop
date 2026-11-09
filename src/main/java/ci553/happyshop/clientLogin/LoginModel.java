package ci553.happyshop.clientLogin;

public class LoginModel {
    public LoginView logView;

    String user1 = "Mark";
    String pass1 = "123";

    void login() {
        String username = logView.tfUsername.getText();
        String password = logView.pfPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            logView.update("Please input your username and password");
        } else if (username.equals(user1) && password.equals(pass1)) {
            onLoginSuccess();
        } else {
            logView.update("Invalid username or password.");
        }
    }

    protected void onLoginSuccess(){
        logView.update("Login Successful");
    }

}
