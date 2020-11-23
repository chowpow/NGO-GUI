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

public class JoinVolunteerController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private Text groupOutput;

    @FXML
    private Button quitButton;

    @FXML
    private Button join1;

    @FXML
    private Button join2;

    @FXML
    private Text joinOutput;

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
    void joinVolunteer1(ActionEvent e) {

        ArrayList<String> arr;

        arr = db.getVolunteerInfoJoin1();

        for (String s : arr) {
            joinOutput.setText(groupOutput.getText() + s);

        }

    }

    @FXML
    void joinVolunteer2(ActionEvent e) {

        ArrayList<String> arr;

        arr = db.getVolunteerInfoJoin2();

        for (String s : arr) {
            joinOutput.setText(groupOutput.getText() + s);

        }

    }

}
