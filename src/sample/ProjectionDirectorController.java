package sample;

import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProjectionDirectorController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private Text projectionOutput;

    @FXML
    private Button quitButton;

    @FXML
    private Button dProject;

    @FXML
    private Text joinOutput;

    @FXML
    void projectDirector(ActionEvent event) {
        joinOutput.setText("");
//        String directorCity = d_city.getText();
//
//        ArrayList<String> arr = db.getDirectorInfo("'" + d_city.getText() + "'");
//
//        for (String s : arr) {
//            update.setText(update.getText() + s);
//
//        }
//
//        d_city.clear();

        ArrayList<String> arr = db.getDirectorInfoProj();


        for (String s : arr) {
            joinOutput.setText(joinOutput.getText() + s);
        }

    }

    @FXML
    void returnToDirectorMenu(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DirectorMenuController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        DirectorMenuController controller = loader.getController();
        controller.setDb(db);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();

    }

}
