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

import java.io.IOException;

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
    private Button leads;

    @FXML
    private Button quitButton;

    @FXML
    private Text menuText;

    @FXML
    private Button help;

    @FXML
    private Button workon;






    @FXML
    void quitButtonPressed(ActionEvent event) {
        Stage currentWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        currentWindow.close();


    }


    @FXML
    void volunteerButtonPressed(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VolunteerMenuController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        VolunteerMenuController controller = loader.getController();
        controller.setDb(databaseHandler);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();
    }

    @FXML
    void directorButtonPressed(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DirectorMenuController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        DirectorMenuController controller = loader.getController();
        controller.setDb(databaseHandler);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();

    }

    @FXML
    void projectButtonPressed(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProjectMenuController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        ProjectMenuController controller = loader.getController();
        controller.setDb(databaseHandler);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();

    }

    @FXML
    void beneButtonPressed(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BeneficiaryMenuController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        BeneficiaryMenuController controller = loader.getController();
        controller.setDb(databaseHandler);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();

    }

    @FXML
    void leadsButtonPressed(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertLeadsController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        InsertLeadsController controller = loader.getController();
        controller.setDb(databaseHandler);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();

    }


    @FXML
    void helpButtonPressed(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertHelpController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        InsertHelpController controller = loader.getController();
        controller.setDb(databaseHandler);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();

    }

    @FXML
    void workonButtonPressed() {

    }



}
