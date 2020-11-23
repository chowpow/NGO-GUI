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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Director;
import model.Volunteer;

import java.io.IOException;

public class InsertDirectorController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField d_id;

    @FXML
    private PasswordField d_pass;

    @FXML
    private TextField d_name;

    @FXML
    private TextField d_phone;

    @FXML
    private TextField d_add;

    @FXML
    private TextField d_city;

    @FXML
    private Button insertButton;

    @FXML
    private Label dLabel;

    @FXML
    private Button quitButton;

    @FXML
    void insertDirector(ActionEvent event) {
        int dId = Integer.parseInt(d_id.getText());
        String dPass = d_pass.getText();
        String dName = d_name.getText();
        int dPhone = Integer.parseInt(d_phone.getText());
        String dAdd = d_add.getText();
        String dCity = d_city.getText();

        Director director = new Director(dId, dPass, dName, dPhone, dAdd, dCity);

        dLabel.setText(dName + " has been added");

        db.insertDirector(director);

        d_id.clear();
        d_pass.clear();
        d_name.clear();
        d_phone.clear();
        d_add.clear();
        d_city.clear();

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
