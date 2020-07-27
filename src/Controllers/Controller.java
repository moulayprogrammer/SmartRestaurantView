package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    ImageView logo,userVector;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*Image image = new Image("Images/Logo.png");
        logo.setImage(image);
        image = new Image("Images/Vector.png");
        userVector.setImage(image);*/

        LaunchProviderScreen();
    }

    private void LaunchProviderScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/AddFactoryBuy.fxml"));
            BorderPane temp = loader.load();
            mainPane.getChildren().setAll(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToFirst(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/FirstScreen.fxml"));
            AnchorPane temp = loader.load();
            mainPane.getChildren().setAll(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
