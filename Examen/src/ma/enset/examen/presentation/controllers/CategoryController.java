package ma.enset.examen.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.examen.dao.DaoCategoryImp;
import ma.enset.examen.dao.entities.Category;
import ma.enset.examen.service.CategoryService;
import ma.enset.examen.service.CategoryServiceImp;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    public TextField category_txt;
    public TableView cat_tableView;
    public TableColumn<Category, Integer> id_cell;
    public TableColumn<Category, String> Name_cell;

    ObservableList<Category> observableList;

    CategoryService categoryService;

    public CategoryController() {
        categoryService = new CategoryServiceImp(new DaoCategoryImp());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCategory();
        id_cell.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));
        Name_cell.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));

        cat_tableView.setItems(observableList);
    }

    private ObservableList<Category> loadCategory(){
        return observableList = FXCollections.observableArrayList(
                categoryService.getALl()
        );

    }

    @FXML
    private void addCat(){
        try{
            Category c = new Category();
            c.setName(category_txt.getText());
            categoryService.add(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}


