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
import model.Leads;

import java.io.IOException;

public class InsertLeadsController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField d_id;

    @FXML
    private TextField v_id;

    @FXML
    private Button insertButton;

    @FXML
    private Button quitButton;

    @FXML
    private Label leadsLabel;

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
    void insertLeads(ActionEvent event) {
        Leads leads = new Leads(Integer.parseInt(d_id.getText()), Integer.parseInt(v_id.getText()));
        db.insertLeads(leads);

        leadsLabel.setText("Leads with Director ID: " + d_id.getText() + " Volunteer ID: " + v_id.getText() + " added");



    }

}
