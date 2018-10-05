package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label infoLabel;

    @FXML
    private Button printUserButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button printTariffsButton;

    @FXML
    private TextField costForNWField;

    @FXML
    private Button sortButton;

    @FXML
    private Button addUserButton;

    @FXML
    private TextField nameUserField;

    @FXML
    private TextField speciesUserField;

    @FXML
    private TextField numberUserField;

    @FXML
    void initialize() {
        Model model = new Model();

        searchButton.setOnAction(event -> {
            String inpText = costForNWField.getText();
            String text = model.searchWork(inpText);
            infoLabel.setText(text);
        });

        sortButton.setOnAction(event -> {
            String text = model.searchWork();
            infoLabel.setText(text);
        });

        addUserButton.setOnAction(event -> {
            String nameUser = nameUserField.getText();
            String speciesUserText = speciesUserField.getText();
            String numberUser = numberUserField.getText();
            String text = model.addUser(nameUser, numberUser, speciesUserText);
            infoLabel.setText(text);
        });

        printUserButton.setOnAction(event -> {
            String text = model.buildLabelText(Model.TypeText.CLIENTS);
            infoLabel.setText(text);
        });

        printTariffsButton.setOnAction(event -> {
            String text = model.buildLabelText(Model.TypeText.TARIFFS);
            infoLabel.setText(text);
        });
    }
}
