package ci553.happyshop.clientLogin;

public class LoginController {
    public LoginModel logModel;

    public void doAction(String action){
        switch (action){
            case "Login":
                logModel.login();
        }
    }
}
