package Controllers;


import Model.Provider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML
    private VBox vboxOptionJob;

    @FXML
    private Button cancelButtonJob;

    @FXML
    private Button insertJobButton;




    private ObservableList<Provider> dataTable = FXCollections.observableArrayList();
    private ArrayList<Provider> list_Providers = new ArrayList<>();
    private boolean visible = false;
    private boolean visibleJob = false;
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

    @FXML
    void showListJob(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/jobs.fxml"));
            DialogPane temp = loader.load();
            ProviderController providerController = loader.getController();
            providerController.hide();
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
       closeDialog(insertButton);
    }

    @FXML
    void insertProvider(ActionEvent event) {

    }
    @FXML
    void showHideProviderOperation(ActionEvent event) {
     visible = showHideListOperation(vboxOption,visible);
    }
    @FXML
    void showHideJobOperation(ActionEvent event) {
        visibleJob = showHideListOperation(vboxOptionJob,visibleJob);

    }
    private boolean showHideListOperation(VBox vBox ,boolean visibles){
        if (!visibles){
            vBox.setVisible(true);
            visibles = true;
        }
        else{ vBox.setVisible(false);
            visibles = false;

        }
        return visibles;
    }
    @FXML
    void cancel(ActionEvent event) {
        closeDialog(cancelButtonJob);
    }

    @FXML
    void deleteJob(ActionEvent event) {

    }

    @FXML
    void insertJob(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/addJob.fxml"));
            DialogPane temp = loader.load();
            hide();
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(temp);
            dialog.initStyle(StageStyle.UNDECORATED);
            dialog.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void hide(){
        vboxOptionJob.setVisible(false);
    }

    @FXML
    void updateJob(ActionEvent event) {

    }

    @FXML
    void closeInsertJobDialog(MouseEvent event) {
        closeDialog(insertJobButton);
    }

    private void closeDialog(Button btn){
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
