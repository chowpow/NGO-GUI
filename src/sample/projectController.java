package sample;

import controller.NGO;
import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class projectController {

    private DatabaseHandler databaseHandler = new DatabaseHandler();
    private int attempts = 0;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginStatus;

    @FXML
    void buttonPressed(ActionEvent event) {
        Stage loginWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (databaseHandler.login(username.getText(), password.getText())) {
            System.out.println("LOGIN SUCCESSFUL");
            loginStatus.setText("Connected!");
        } else {
            System.out.println("LOGIN FAILED");
            loginStatus.setText("Login Failed");
            attempts++;

            if (attempts == 3) {
                loginWindow.close();
            }
        }
    }

}
