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
import model.Help;

import java.io.IOException;

public class InsertHelpController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField p_id;

    @FXML
    private TextField b_id;

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
    void insertHelp(ActionEvent event) {
        Help help = new Help(Integer.parseInt(p_id.getText()),Integer.parseInt(b_id.getText()));

        db.insertHelp(help);
        leadsLabel.setText("Help with Project ID: " + p_id.getText() + " Beneficiary ID: " + b_id.getText() + " added");
    }

}
