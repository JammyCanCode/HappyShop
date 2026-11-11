package ci553.happyshop.clientLogin;

public class LoginModel {
    public LoginView logView;

    String user1 = "Mark";
    String pass1 = "123";

    void login() {
        String username = logView.tfUsername.getText();
        String password = logView.pfPassword.getText();

        /* Uses hardcoded values (Will be using database for login credentials in final)
        ** Checks to see if both username and/or password are empty, if user is empty but password
        ** contains input then it will ask for the user to input their username and password
        ** If both fields are filled, then it checks against user1 and pass1, if it matches then
        ** it will transition to onLoginSuccess, if not, the else statement will be executed. */

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
