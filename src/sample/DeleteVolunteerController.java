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
import model.Volunteer;

import java.io.IOException;

public class DeleteVolunteerController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField v_id;

    @FXML
    private Button v_delete;

    @FXML
    private Button quitButton;

    @FXML
    private Label vLabel;

    @FXML
    void returnToVolunteerMenu(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VolunteerMenuController.fxml"));
        Parent menu = loader.load();

        Scene menuScene = new Scene(menu);

        VolunteerMenuController controller = loader.getController();
        controller.setDb(db);

        loginWindow.setScene(menuScene);
        loginWindow.show();
    }

    @FXML
    void deleteVolunteer(ActionEvent e) {

        db.deleteVolunteer(Integer.parseInt(v_id.getText()));

        vLabel.setText("Volunteer " + Integer.parseInt(v_id.getText()) + " has been deleted");

        v_id.clear();

    }

}
