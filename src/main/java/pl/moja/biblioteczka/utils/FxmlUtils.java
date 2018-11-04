package pl.moja.biblioteczka.utils;

import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlUtils {
    public static Pane fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
        loader.setResources(getResourceBundle());
        try {
            return  loader.load();
        } catch (Exception ex) {
            DialogsUtils.errorDialog(ex.getMessage());
        }
        return null;
    }
    
    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundles.messages");
    }
}
