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

public class ProjectInfoController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField p_amount;

    @FXML
    private Button projectSubmit;

    @FXML
    private Button quitButton;

    @FXML
    private Text update;

    @FXML
    void projectHaving(ActionEvent event) {
        update.setText("");

        ArrayList<String> arr = db.projectInfo(Integer.parseInt(p_amount.getText()));

        for (String s : arr) {
            update.setText(update.getText() + s);

        }

        p_amount.clear();

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
