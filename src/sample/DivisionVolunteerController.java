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

public class DivisionVolunteerController {

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
    void volunteerDivision1(ActionEvent event) {
        ArrayList<String> arr;

        arr = db.getVolunteerInfoDivision1();

        for (String s : arr) {
            joinOutput.setText(groupOutput.getText() + s);
        }
    }

    @FXML
    void volunteerDivision2(ActionEvent event) {
        ArrayList<String> arr;

        arr = db.getVolunteerInfoDivision2();

        for (String s : arr) {
            joinOutput.setText(groupOutput.getText() + s);
        }

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
