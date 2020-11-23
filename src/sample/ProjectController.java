package sample;

import controller.NGO;
import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ProjectController {

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
    void buttonPressed(ActionEvent event) throws IOException {
        Stage loginWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (databaseHandler.login(username.getText(), password.getText())) {
            loginStatus.setText("Connected!");
            databaseHandler.databaseSetUp();





            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MenuController.fxml"));
            Parent menu = loader.load();

            Scene menuScene = new Scene(menu);

            MenuController controller = loader.getController();
            controller.setDatabaseHandler(databaseHandler);




            loginWindow.setScene(menuScene);
            loginWindow.show();

            //mc = new MenuController(databaseHandler);

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
