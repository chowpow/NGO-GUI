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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuController {

    private DatabaseHandler databaseHandler;

    public void setDatabaseHandler(DatabaseHandler db) {
        databaseHandler = db;
    }

    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button volunteerButton;

    @FXML
    private Button directorButton;

    @FXML
    private Button projectButton;

    @FXML
    private Button beneficiaryButton;

    @FXML
    private Button donorButton;

    @FXML
    private Button quitButton;

    @FXML
    private Text menuText;

    @FXML
    void quitButtonPressed(ActionEvent event) {
        Stage currentWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        currentWindow.close();


    }


}
