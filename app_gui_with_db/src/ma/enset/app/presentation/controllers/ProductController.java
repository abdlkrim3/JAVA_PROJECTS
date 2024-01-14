package ma.enset.app.presentation.controllers;

import com.mysql.cj.xdevapi.Column;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import ma.enset.app.dao.DaoProductImpl;
import ma.enset.app.dao.entities.Product;
import ma.enset.app.services.ServiceProduct;
import ma.enset.app.services.ProduitServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTreeTableCell.forTreeTableColumn;

public class ProductController implements Initializable {

    @FXML
    private TextField textNom;
    @FXML
    private TextField textDescreption ;
    @FXML
    private TextField textQuantite ;
    @FXML
    private TextField textPrix ;
    @FXML
    private TextField textSearch ;
    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Integer> colId;
    @FXML
    private TableColumn<Product, String> colNom;
    @FXML
    private TableColumn<Product, Float> colPrix;
    @FXML
    private TableColumn<Product, String> colDescreption;
    @FXML
    private TableColumn<Product, Integer> colQuantite;
    ObservableList<Product> productObservableList = FXCollections.observableArrayList();
    ServiceProduct serviceProduct = new ProduitServiceImpl(new DaoProductImpl());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productTableView.setItems(productObservableList);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colDescreption.setCellValueFactory(new PropertyValueFactory<>("descreption"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));

        //  Mise a jour de tableview
        productTableView.setEditable(true);
        colNom.setCellFactory(TextFieldTableCell.forTableColumn());

        colNom.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, String> event) {
                Product p = event.getRowValue();
                p.setNom(event.getNewValue());
                update(p);
            }
        });
        colPrix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        colPrix.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, Float>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, Float> event) {
                Product p = event.getRowValue();
                // Verifie si le prix est un nombre ou non
                p.setPrix(event.getNewValue());
                update(p);
            }
        });
        colDescreption.setCellFactory(TextFieldTableCell.forTableColumn());
        colDescreption.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, String> event) {
                Product p = event.getRowValue();
                p.setDescreption(event.getNewValue());
                update(p);
            }
        });
        colQuantite.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colQuantite.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, Integer> event) {
                Product p = event.getRowValue();
                p.setQuantite(event.getNewValue());
                update(p);
            }
        });

        loadProducts();

        //  Fonction qui gére la recherche dans tableview
        textSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                productObservableList.clear();
                productObservableList.addAll(serviceProduct.getProductByQuery(t1));
            }
        });
    }
    @FXML
    public void addProduct(){
        Product p = new Product();
        boolean flag = true;
        String tmpNom = textNom.getText();
        String tmpDescreption = textDescreption.getText();
        String tmpPrix = textPrix.getText();
        String tmpQuantite = textQuantite.getText();
        // Vérifier les champs
        // -- Les champs ne doivent pas étre vide
        if(tmpNom.isEmpty() || tmpDescreption.isEmpty() || tmpPrix.isEmpty() || tmpQuantite.isEmpty()){
            flag = false;
        }
        // -- Prix et Quantite doivent étre des nombres
        try{
            Float.parseFloat(tmpPrix);
            Integer.parseInt(tmpQuantite);
        }
        catch (NumberFormatException e){
            flag = false;
        }

        if(flag){
            p.setNom(tmpNom);
            p.setDescreption(tmpDescreption);
            p.setPrix(Float.parseFloat(tmpPrix));
            p.setQuantite(Integer.parseInt(tmpQuantite));
            serviceProduct.addProduct(p);
            loadProducts();
        }
    }
    @FXML
    public void deleteProduct(){
        Product p = productTableView.getSelectionModel().getSelectedItem();
        if(p != null){
            serviceProduct.deleteProduct(p);
            loadProducts();
        }
    }
    @FXML
    public void update(Product p){
        serviceProduct.updateProduct(p);
        loadProducts();
    }
    private void loadProducts(){
        productObservableList.clear();
        productObservableList.addAll(serviceProduct.getAllProducts());
    }
}
