package sample;

import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GroupVolunteerController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField v_city;

    @FXML
    private TextField p_id;

    @FXML
    private Button v_submit;

    @FXML
    private Button quitButton;

    @FXML
    private Text groupOutput;


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
    void groupVolunteer(ActionEvent e) {

        ArrayList<String> arr;
        arr = db.getVolunteersInfo("'" + v_city.getText() + "'", Integer.parseInt(p_id.getText()));
        StringBuffer stringBuffer = new StringBuffer();

        for (String s : arr) {
            groupOutput.setText(groupOutput.getText() + s);

        }

        //groupOutput.setText(String.valueOf(stringBuffer));

        v_city.clear();
        p_id.clear();

    }

}
