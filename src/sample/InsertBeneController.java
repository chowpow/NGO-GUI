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
import model.Beneficiary;
import model.Volunteer;

import java.io.IOException;

public class InsertBeneController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField b_id;

    @FXML
    private TextField b_age;

    @FXML
    private TextField b_phone;

    @FXML
    private TextField b_city;

    @FXML
    private TextField b_postal;

    @FXML
    private TextField b_name;

    @FXML
    private Button insertButton;

    @FXML
    private Label vLabel;

    @FXML
    private Button quitButton;

    @FXML
    void insertBene(ActionEvent event) {
        int bId = Integer.parseInt(b_id.getText());
        String bName = b_name.getText();
        int bAge = Integer.parseInt(b_age.getText());
        int bPhone = Integer.parseInt(b_phone.getText());
        String bCity = b_city.getText();
        String bPostal = b_postal.getText();

        Beneficiary beneficiary = new Beneficiary(bId, bName, bAge, bPhone, bCity, bPostal);

        vLabel.setText(bName + " has been added");

        db.insertBeneficiary(beneficiary);

        b_id.clear();
        b_name.clear();
        b_age.clear();
        b_phone.clear();
        b_city.clear();
        b_postal.clear();


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
