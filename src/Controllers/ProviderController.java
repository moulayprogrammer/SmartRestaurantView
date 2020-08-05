package Controllers;

import Model.Bill;
import Model.Provider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.html.ImageView;

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
    @FXML
    private Button insertButton;

    @FXML
    private VBox vboxOption;



    private ObservableList<Provider> dataTable = FXCollections.observableArrayList();
    private ArrayList<Provider> list_Providers = new ArrayList<>();
    private boolean visible = false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public void Init(BorderPane mainPane) {
        this.mainPane = mainPane;

        chargeListProvider();
        vboxOption.setVisible(false);

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

    @FXML
    void addNewProvider(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/addProvider.fxml"));
            DialogPane temp = loader.load();
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(temp);
            dialog.initStyle(StageStyle.UNDECORATED);
            dialog.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void chargeListProvider(){
        Provider provider = new Provider(1,"نايلي","زهواني","0663430252","مشروبات","مدينة الجديدة","20000","40000");
       list_Providers.add(provider)   ;
    }
    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) insertButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void insertProvider(ActionEvent event) {

    }
    @FXML
    void slideShowHide(ActionEvent event) {
     if (!visible){
     vboxOption.setVisible(true);
     visible = true;
     }
     else{ vboxOption.setVisible(false);
         visible = false;

     }
    }

}
