package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.moja.biblioteczka.utils.DialogsUtils;
import pl.moja.biblioteczka.utils.FxmlUtils;


public class MainController {
    
    @FXML
    private BorderPane borderPane; 
    
    @FXML
    private TopMenuButtonsController topMenuButtonsController;
    
    @FXML
    public void closeApplication(){
        Optional<ButtonType> result = DialogsUtils.confirmationDialog();
        
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        } 
    }
    
    @FXML
    public void setCaspian() {
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
    }
    
    @FXML
    public void setModena() {
        Application.setUserAgentStylesheet(STYLESHEET_MODENA);
    }
    
    @FXML
    public void setAlwaysOnTop(ActionEvent actionEvent){
        Stage stage = (Stage) borderPane.getScene().getWindow();
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        stage.setAlwaysOnTop(value);
    }
    
    @FXML
    public void about() {
        DialogsUtils.dialogAboutApplication();
    }
    
    @FXML
    private void initialize() {
        topMenuButtonsController.setMainController(this);
    }
    
    public void setCenter(String fxmlPath) {
        borderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
    }
}
