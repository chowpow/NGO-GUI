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

public class DirectorMenuController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private Button insertDirector;

    @FXML
    private Button deleteDirector;

    @FXML
    private Button updateDirector;

    @FXML
    private Button directorSelection;

    @FXML
    private Button directorProject;

    @FXML
    private Button directorExit;

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

//        MenuController controller = loader.getController();
//        controller.setDatabaseHandler(databaseHandler);

        loginWindow.setScene(menuScene);
        loginWindow.show();

    }

    @FXML
    void insertButton(ActionEvent event) {

    }

    @FXML
    void projectionButton(ActionEvent event) {

    }

    @FXML
    void selectButton(ActionEvent event) {

    }

    @FXML
    void updateButton(ActionEvent event) {

    }

}
