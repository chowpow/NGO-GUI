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

import java.io.IOException;

public class ProjectMenuController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private Button insertProject;

    @FXML
    private Button deleteProject;

    @FXML
    private Button projectInfo;

    @FXML
    private Button projectNested;

    @FXML
    private Button projectExit;

    @FXML
    void deleteButton(ActionEvent event) {

    }

    @FXML
    void exitButton(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MenuController.fxml"));
        Parent menu = loader.load();

        Scene menuScene = new Scene(menu);

        MenuController controller = loader.getController();
        controller.setDatabaseHandler(db);

//        MenuController controller = loader.getController();
//        controller.setDatabaseHandler(databaseHandler);

        loginWindow.setScene(menuScene);
        loginWindow.show();

    }

    @FXML
    void infoButton(ActionEvent event) {

    }

    @FXML
    void insertButton(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertProjectController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        InsertProjectController controller = loader.getController();
        controller.setDb(db);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();

    }

    @FXML
    void nestedButton(ActionEvent event) {

    }

}
