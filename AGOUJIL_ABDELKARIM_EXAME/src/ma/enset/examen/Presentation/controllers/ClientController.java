package ma.enset.examen.Presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.examen.Dao.ClientDaoImpl;
import ma.enset.examen.Dao.entities.Client;
import ma.enset.examen.Service.CatalogueService;
import ma.enset.examen.Service.CatalogueServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
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
    private TableView<Client> produitTableView;
    @FXML
    private TableColumn <Client,Integer> colID;
    @FXML
    private TableColumn <Client,String> colNom;
    @FXML
    private TableColumn <Client,String> colDescription;
    @FXML
    private TableColumn <Client,Float> colPrix;
    @FXML
    private TableColumn <Client,Integer> colQuantite;
    ObservableList<Client> clientList = FXCollections.observableArrayList();
    private CatalogueService produitService=new CatalogueServiceImpl(new ClientDaoImpl());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        produitTableView.setItems(clientList);
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        loadProduits();
        //  Mise a jour de tableview
        /*
        produitTableView.setEditable(true);
        colNom.setCellFactory(TextFieldTableCell.forTableColumn());

        colNom.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Produit, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Produit, String> event) {
                Produit p = event.getRowValue();
                p.setNom(event.getNewValue());
                updateProduit(p);
            }
        });
        colPrix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        colPrix.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Produit, Float>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Produit, Float> event) {
                Produit p = event.getRowValue();
                // Verifie si le prix est un nombre ou non
                p.setPrix(event.getNewValue());
                updateProduit(p);
            }
        });
        colDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        colDescription.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Produit, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Produit, String> event) {
                Produit p = event.getRowValue();
                p.setDescription(event.getNewValue());
                updateProduit(p);
            }
        });
        colQuantite.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colQuantite.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Produit, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Produit, Integer> event) {
                Produit p = event.getRowValue();
                p.setQuantite(event.getNewValue());
                updateProduit(p);
            }
        });

        loadProduits();

        //  Fonction qui gére la recherche dans tableview
        textSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                produitList.clear();
                produitList.addAll(produitService.getProduitParMc(t1));
            }
        });*/
    }
    public void addProduit(){
        Client p = new Client();
        boolean flag = true;
        String tmpNom = textNom.getText();
        String tmpDescreption = textDescription.getText();
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
            p.setDescription(tmpDescreption);
            p.setPrix(Float.parseFloat(tmpPrix));
            p.setQuantite(Integer.parseInt(tmpQuantite));
            produitService.addClient(p);
            loadProduits();
        }
    }
    public void deletProduit(){
        Client p=produitTableView.getSelectionModel().getSelectedItem();
        produitService.deletClient(p);
        loadProduits();
    }
    public void updateProduit(Client p){
        produitService.updateClient(p);
        loadProduits();
    }
    private void loadProduits(){
        clientList.clear();
        clientList.addAll(produitService.getALL());
    }
}