package ma.enset.tpjdbc.Presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.tpjdbc.Dao.ProduitDaoImpl;
import ma.enset.tpjdbc.Dao.entities.Produit;
import ma.enset.tpjdbc.Service.ProduitService;
import ma.enset.tpjdbc.Service.ProduitServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ProduitController2 implements Initializable {
    @FXML
    private TextField textNom;
    @FXML
    private TextField textDescription;
    @FXML
    private TextField textPrix;
    @FXML
    private TextField textQuantite;
    @FXML
    private TextField textSearch;
    @FXML
    private TableView<Produit> produitTableView;
    @FXML
    private TableColumn <Produit,Integer> colID;
    @FXML
    private TableColumn <Produit,String> colNom;
    @FXML
    private TableColumn <Produit,String> colDescription;
    @FXML
    private TableColumn <Produit,Float> colPrix;
    @FXML
    private TableColumn <Produit,Integer> colQuantite;
    ObservableList<Produit> produitList= FXCollections.observableArrayList();
    private ProduitService produitService=new ProduitServiceImpl(new ProduitDaoImpl());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        produitTableView.setItems(produitList);
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        produitList.addAll(produitService.getALL());
    }
    public void addProduit(){

    }
    public void deletProduit(){

    }
    public void updateProduit(){

    }
}