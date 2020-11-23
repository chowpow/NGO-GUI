package sample;

import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateDirectorController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField d_id;

    @FXML
    private Button d_submit;

    @FXML
    private Button quitButton;

    @FXML
    private Text groupOutput;

    @FXML
    private PasswordField d_pass;

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

    @FXML
    void updateDirector(ActionEvent event) {
        int dId = Integer.parseInt(d_id.getText());
        String dPass = d_pass.getText();

        db.updateDirector(dId, dPass);
        groupOutput.setText("Director: " + dId + "'s password has been changed");

        d_id.clear();
        d_pass.clear();
    }

}
