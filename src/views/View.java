package views;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import controllers.IControllerForView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class View implements IViewForController, Initializable {
    @FXML
    private Button btnAcces;

    @FXML
    private Button btnLangue;

    @FXML
    private TextField txtFldNom;

    private final IControllerForView controller;
    Stage mainStage;

    private String langueCourante;

    public View(IControllerForView controller) {
        this.controller = controller;
        langueCourante = "fr";
    }

    @Override
    public void start() {
        Platform.startup(() -> {
            mainStage = new Stage();
            startStage(langueCourante);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnAcces.setDefaultButton(true);

        btnAcces.disableProperty().bind(txtFldNom.textProperty().isEmpty());
        btnAcces.setOnAction((ActionEvent ae) -> {
            connexion();
            mainStage.close();
        });

        btnLangue.setOnAction((ActionEvent ae) -> {
            if (langueCourante.equals("en")) {
                startStage("fr");
            } else {
                startStage("en");
            }

        });
    }

    private void startStage(String language) {
        try {
            langueCourante = language;
            Locale locale = new Locale(language);
            ResourceBundle bundle = ResourceBundle.getBundle("ressources/MessageBundle", locale);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"), bundle);
            fxmlLoader.setControllerFactory(type -> {
                return this;
            });
            Parent root = (Parent) fxmlLoader.load();
            Scene principalScene = new Scene(root);

            principalScene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
            mainStage.setScene(principalScene);
            mainStage.setTitle("Liste de lecture");
            mainStage.setMinWidth(500);
            mainStage.setMinHeight(400);
            mainStage.setMaxWidth(900);
            mainStage.setMaxHeight(600);
            mainStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            Platform.exit();
        }
    }

    public void connexion() {
        controller.connexion(txtFldNom.getText(), langueCourante);
    }

    @Override
    public void messageInfo(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
        });
    }
}
