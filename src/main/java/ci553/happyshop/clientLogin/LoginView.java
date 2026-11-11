package ci553.happyshop.clientLogin;

import ci553.happyshop.SoundEffects.SoundEffect;
import ci553.happyshop.utility.UIStyle;
import ci553.happyshop.utility.WinPosManager;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    public LoginController logController;

    public String title = "Login Client";
    private final int WIDTH = UIStyle.LoginWinWidth;
    private final int HEIGHT = UIStyle.LoginWinHeight;
    private final int COLUMN_WIDTH = WIDTH / 2 - 10;

    TextField tfUsername; //User input for Username + Password.
    PasswordField pfPassword;

    private Label lbLogInvalid;
    private Stage viewWindow;

    public void start(Stage window) {

        VBox vbLoginPage = createLoginPage();
        Scene scene = new Scene(vbLoginPage, WIDTH, HEIGHT);
        window.setScene(scene);
        window.setTitle(title);
        WinPosManager.registerWindow(window, WIDTH, HEIGHT);
        window.show();
        viewWindow = window;
    }

    private VBox createLoginPage() {
        Label logPageTitle = new Label(title);
        logPageTitle.setStyle(UIStyle.labelTitleStyle);

        //User input text fields + styling.
        tfUsername = new TextField();
        tfUsername.setPromptText("e.g Username");
        tfUsername.setStyle(UIStyle.LoginTextFieldStyle);
        pfPassword = new PasswordField();
        pfPassword.setPromptText("e.g Password");
        pfPassword.setStyle(UIStyle.LoginTextFieldStyle);

        Button btnLogin = new Button("Login");
        btnLogin.setStyle(UIStyle.buttonStyle);
        btnLogin.setOnAction(this::buttonClicked);
        lbLogInvalid = new Label(" ");
        VBox vbLoginPage = new VBox(15, logPageTitle, tfUsername, pfPassword, btnLogin, lbLogInvalid);
        vbLoginPage.setPrefWidth(COLUMN_WIDTH);
        vbLoginPage.setAlignment(Pos.TOP_CENTER);
        vbLoginPage.setStyle("-fx-padding: 15px");

        return vbLoginPage;
    }

    private void buttonClicked(ActionEvent event) {
        Button btnLogin = (Button) event.getSource();
        String  action = btnLogin.getText();
        SoundEffect.playMedia();
        logController.doAction(action);
    }

    public void update(String message){
        lbLogInvalid.setText(message);
    }

    public void close(){
        viewWindow.close();
    }
}

