package sample;

import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Volunteer;

import java.io.IOException;

public class InsertVolunteerController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    public DatabaseHandler getDb() {
        return db;
    }

    @FXML
    private TextField v_id;

    @FXML
    private PasswordField v_pass;

    @FXML
    private TextField v_name;

    @FXML
    private TextField v_phone;

    @FXML
    private TextField v_add;

    @FXML
    private TextField v_city;

    @FXML
    private Label vLabel;


    @FXML
    void insertVolunteer(ActionEvent e) {
        int volunteerId = Integer.parseInt(v_id.getText());
        String volunteerPassWord = v_pass.getText();
        String volunteerName = v_name.getText();
        int volunteerPhone = Integer.parseInt(v_phone.getText());
        String volunteerAddress = v_add.getText();
        String volunteerCity = v_city.getText();

        Volunteer volunteer = new Volunteer(volunteerId, volunteerPassWord, volunteerName, volunteerPhone, volunteerAddress, volunteerCity);

        vLabel.setText(volunteerName + " has been added");

        db.insertVolunteer(volunteer);

        v_id.clear();
        v_pass.clear();
        v_name.clear();
        v_phone.clear();
        v_add.clear();
        v_city.clear();
    }

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

}
