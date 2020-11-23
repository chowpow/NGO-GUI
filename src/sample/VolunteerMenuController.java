package sample;

import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.IOException;

public class VolunteerMenuController {

    private DatabaseHandler db;

    private int firstTime = 0;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private Button insertVolunteer;

    @FXML
    private Button deleteVolunteer;

    @FXML
    private Button groupVolunteer;

    @FXML
    private Button volunteerJoin;

    @FXML
    private Button volunteerDivision;

    @FXML
    private Button volunteerExit;

    @FXML
    void exitButton(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MenuController.fxml"));
        Parent menu = loader.load();

        Scene menuScene = new Scene(menu);

//        MenuController controller = loader.getController();
//        controller.setDatabaseHandler(databaseHandler);

        loginWindow.setScene(menuScene);
        loginWindow.show();
    }

    @FXML
    void insertButton(ActionEvent e) throws IOException {

        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("InsertVolunteerController.fxml"));
        Parent menu = loader.load();

        InsertVolunteerController controller = loader.getController();

        controller.setDb(db);

        Scene menuScene = new Scene(menu);

        loginWindow.setScene(menuScene);
        loginWindow.show();
    }

    @FXML
    void deleteButton(ActionEvent e) throws IOException {

        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteVolunteerController.fxml"));
        Parent menu = loader.load();

        DeleteVolunteerController controller = loader.getController();

        controller.setDb(db);

        Scene menuScene = new Scene(menu);

        loginWindow.setScene(menuScene);
        loginWindow.show();
    }

    @FXML
    void groupButton(ActionEvent e) throws IOException {

        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupVolunteerController.fxml"));
        Parent menu = loader.load();

        GroupVolunteerController controller = loader.getController();

        controller.setDb(db);

        Scene menuScene = new Scene(menu);

        loginWindow.setScene(menuScene);
        loginWindow.show();
    }



}
