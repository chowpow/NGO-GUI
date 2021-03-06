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

public class ProjectNestedController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField b_age;

    @FXML
    private TextField p_id;

    @FXML
    private Button nested_submit;

    @FXML
    private Button quitButton;

    @FXML
    private Text groupOutput;

    @FXML
    void projectNested(ActionEvent event) {
        groupOutput.setText("");
        ArrayList<String> arr = db.getBeneficiaryCityAndMinAge(Integer.parseInt(p_id.getText()), Integer.parseInt(b_age.getText()));

        for (String s: arr) {
            groupOutput.setText(groupOutput.getText() + s);
        }

        p_id.clear();
        b_age.clear();

    }

    @FXML
    void returnToProjectMenu(ActionEvent e) throws IOException {
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
