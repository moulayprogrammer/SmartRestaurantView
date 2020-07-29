package Controllers;

import Model.Bill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class BillController implements Initializable {


    @FXML
    private BorderPane mainPane;
    @FXML
    private TextField txt_Provider_Name;

    @FXML
    private TextField txt_Paid;

    @FXML
    private Label lbl_bill_total;

    @FXML
    private TableView<Bill> table_Bill;

    @FXML
    private TableColumn<Bill, String> col_Product_Name;

    @FXML
    private TableColumn<Bill, String> col_Unit;

    @FXML
    private TableColumn<Bill, Integer> col_Quantity;

    @FXML
    private TableColumn<Bill, Integer> col_Price;

    @FXML
    private TableColumn<Bill, Integer> col_Total_Price;

    @FXML
    private JFXListView<String> listViewProduct;

    @FXML
    private TextField txt_price;

    @FXML
    private TextField txt_quantity;

    private ObservableList<Bill> dataTable = FXCollections.observableArrayList();
    private ObservableList<String> dataTableView = FXCollections.observableArrayList();
    private ArrayList<Bill> list_Bill = new ArrayList<>();
    private ArrayList<String> list_Product = new ArrayList<>();
    private int total_bill_Price;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chargeListProduct();
        chargeListBill();
        col_Product_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_Unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        col_Quantity.setCellValueFactory(new PropertyValueFactory<>("quant"));
        col_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_Total_Price.setCellValueFactory(new PropertyValueFactory<>("total"));
        dataTable.setAll(list_Bill);
        table_Bill.setItems(dataTable);
        dataTableView.setAll(list_Product);
        listViewProduct.setItems(dataTableView);
        lbl_bill_total.setText(total_bill_Price+".00");
        txt_Provider_Name.setText("naily maz");
    }
    public void Init(BorderPane mainPane) {
        this.mainPane = mainPane;
    }
   private void chargeListBill(){
       total_bill_Price = 0;
       for (int i = 1; i < 20; i++) {
           Bill bill = new Bill();
           bill.setName(list_Product.get(i));
           bill.setUnit("kg");
           bill.setPrice(i*50);
           bill.setQuant(i+3);
           bill.setTotal(bill.getPrice()*bill.getQuant());
           total_bill_Price += bill.getTotal();
           list_Bill.add(bill);
       }
    }
    private void chargeListProduct(){
        for (int i = 0; i < 2; i++) {
            list_Product.add("طماطم معلبة");
            list_Product.add("بطاطا");
            list_Product.add("فلفل");
            list_Product.add("طماطم");
            list_Product.add("مايوناز");
            list_Product.add("هريسة");
            list_Product.add("زيت");
            list_Product.add("كاتشاب");
            list_Product.add("زيتون");
            list_Product.add("طماطم");
        }
    }
}
