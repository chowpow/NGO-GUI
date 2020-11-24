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

import java.io.IOException;

public class DeleteBeneController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField b_id;

    @FXML
    private Button b_delete;

    @FXML
    private Button quitButton;

    @FXML
    private Label vLabel;

    @FXML
    void deleteBene(ActionEvent event) {
        int bId = Integer.parseInt(b_id.getText());

        db.deleteBeneficiary(bId);

        vLabel.setText("Beneficiary: " + bId + " has been deleted");

        b_id.clear();

    }

    @FXML
    void returnToBeneMenu(ActionEvent e) throws IOException {
        Stage loginWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BeneficiaryMenuController.fxml"));
        Parent menu = loader.load();

        Scene menuScene = new Scene(menu);

        BeneficiaryMenuController controller = loader.getController();
        controller.setDb(db);

        loginWindow.setScene(menuScene);
        loginWindow.show();

    }

}
