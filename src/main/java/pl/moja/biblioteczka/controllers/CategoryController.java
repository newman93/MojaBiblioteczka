package pl.moja.biblioteczka.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.moja.biblioteczka.modelFx.CategoryFx;
import pl.moja.biblioteczka.modelFx.CategoryModel;

public class CategoryController {

    @FXML
    private TextField categoryTextField;

    @FXML
    private Button addCategoryButton;

    @FXML
    private ComboBox<CategoryFx> categoryComboBox;
    
    private CategoryModel categoryModel;
    
    @FXML
    public void initialize() {
        this.categoryModel = new CategoryModel();
    }
    
    @FXML
    void addCategoryOnAction() {
        categoryModel.saveCategoryInDatabase(categoryTextField.getText());
    }

}