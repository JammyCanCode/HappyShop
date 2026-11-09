package ci553.happyshop.clientLogin;

import ci553.happyshop.storageAccess.DatabaseRW;
import ci553.happyshop.storageAccess.DatabaseRWCreator;
import javafx.application.Application;
import javafx.stage.Stage;

public class LoginClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage window){
        DatabaseRW databaseRW = DatabaseRWCreator.createDatabaseRW();

        LoginView logView = new LoginView();
        LoginController logController = new LoginController();
        LoginModel logModel = new CustomerLoginModel();

        logView.logController = logController;
        logController.logModel = logModel;
        logModel.logView = logView;
        logView.start(window);
    }
}
