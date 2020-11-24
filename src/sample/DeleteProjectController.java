package sample;

import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteProjectController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField p_id;

    @FXML
    private Button p_delete;

    @FXML
    private Button quitButton;

    @FXML
    private Label pLabel;

    @FXML
    void deleteProject(ActionEvent event) {
        db.deleteProject(Integer.parseInt(p_id.getText()));

        pLabel.setText("Project " + Integer.parseInt(p_id.getText()) + " has been deleted");

        p_id.clear();


    }

    @FXML
    void returnToDirectorMenu(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProjectMenuController.fxml"));
        Parent volMenu = loader.load();

        Scene volMenuScene = new Scene(volMenu);

        ProjectMenuController controller = loader.getController();
        controller.setDb(db);

        loginWindow.setScene(volMenuScene);
        loginWindow.show();

    }

}
