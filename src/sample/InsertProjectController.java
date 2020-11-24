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
import model.Director;
import model.Project;

import java.io.IOException;

public class InsertProjectController {

    private DatabaseHandler db;

    public void setDb(DatabaseHandler db) {
        this.db = db;
    }

    @FXML
    private TextField p_id;

    @FXML
    private TextField p_description;

    @FXML
    private TextField p_budget;

    @FXML
    private TextField p_duration;

    @FXML
    private Button insertButton;

    @FXML
    private Label dLabel;

    @FXML
    private Button quitButton;

    @FXML
    void insertProject(ActionEvent event) {

        int pId = Integer.parseInt(p_id.getText());
        String pDescription = p_description.getText();
        int pBudget = Integer.parseInt(p_budget.getText());
        String pDuration = p_duration.getText();

        Project project = new Project(pId, pDescription, pBudget, pDuration);

        db.insertProject(project);

        p_id.clear();
        p_description.clear();
        p_budget.clear();
        p_duration.clear();

        dLabel.setText("Project: " + pDescription + " has been added");


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
