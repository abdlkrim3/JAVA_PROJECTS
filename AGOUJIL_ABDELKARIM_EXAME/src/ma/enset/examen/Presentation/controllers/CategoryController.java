package ma.enset.examen.Presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.examen.Dao.CompteDaoImpl;
import ma.enset.examen.Dao.ClientDaoImpl;
import ma.enset.examen.Dao.entities.Compte;
import ma.enset.examen.Service.CatalogueService;
import ma.enset.examen.Service.CatalogueServiceImpl;


import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
   /* public TextField category_txt;
    public TableView cat_tableView;
    public TableColumn<Compte, Integer> id_cell;
    public TableColumn<Compte, String> Name_cell;

    ObservableList<Compte> observableList;

    CatalogueService categoryService;

    public CategoryController() {
        categoryService = new CatalogueServiceImpl(new CompteDaoImpl());
    }
    //private CatalogueService categoryService=new CatalogueServiceImpl(new ClientDaoImpl());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCategory();
        id_cell.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("id"));
        Name_cell.setCellValueFactory(new PropertyValueFactory<Compte, String>("name"));

        cat_tableView.setItems(observableList);
    }

    private ObservableList<Compte> loadCategory(){
        return observableList = FXCollections.observableArrayList(
                categoryService.getALl()
        );

    }

    @FXML
    private void addCat(){
        try{
            Compte c = new Compte();
            c.setName(category_txt.getText());
            categoryService.add(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

*/
}


