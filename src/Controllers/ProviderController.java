package Controllers;

import Model.Bill;
import Model.Provider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ProviderController implements Initializable {
    @FXML
    private BorderPane mainPane;
    @FXML
    private TableView<Provider> providerTable;
    @FXML
    private TableColumn<Provider, String> col_name;

    @FXML
    private TableColumn<Provider, String> col_last_name;

    @FXML
    private TableColumn<Provider, String> col_job;

    @FXML
    private TableColumn<Provider, String> col_adress;

    @FXML
    private TableColumn<Provider, Integer> col_phone_number;

    @FXML
    private TableColumn<Provider, Integer> col_creditor;

    @FXML
    private TableColumn<Provider, Integer> col_creditor_to;

    @FXML
    private TableColumn<Provider, Integer> col_id;

    private ObservableList<Provider> dataTable = FXCollections.observableArrayList();
    private ArrayList<Provider> list_Providers = new ArrayList<>();
/*
*    private int id;
    private String first_name;
    private String last_name;
    private String  phone_number;
    private String job;
    private String adress;
    private String creditor;
    private String creditor_to;
* */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chargeListProvider();
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        col_last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        col_phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        col_adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        col_job.setCellValueFactory(new PropertyValueFactory<>("job"));
        col_creditor.setCellValueFactory(new PropertyValueFactory<>("creditor"));
        col_creditor_to.setCellValueFactory(new PropertyValueFactory<>("creditor_to"));
        dataTable.setAll(list_Providers);
        providerTable.setItems(dataTable);



    }
    public void Init(BorderPane mainPane) {
        this.mainPane = mainPane;
    }

    @FXML
    void addNewProvider(ActionEvent event) {

    }
    private void chargeListProvider(){
        Provider provider = new Provider(1,"نايلي","زهواني","0663430252","مشروبات","مدينة الجديدة","20000","40000");
       list_Providers.add(provider)   ;
    }

}
