package zu.searchanimal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class AnimalRadioBoxController {

    @FXML
    public Label animalLabel;
    @FXML
    public Button searchButton;
    @FXML
    public RadioButton dogRadioButton;
    public RadioButton catRadioButton;
    public RadioButton lionRadioButton;
    public RadioButton unicornRadioButton;
    @FXML
    public ImageView animalImageView;

    public Stage stage;
    public Scene scene;
    public Parent root;

    @FXML
    void chooseAnimal(){

        if(dogRadioButton.isSelected()){
            try {

                animalLabel.setText(dogRadioButton.getText());
                Image dogImage = new Image(getClass().getResourceAsStream("/dog 2.png"));
                animalImageView.setImage(dogImage);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(catRadioButton.isSelected()){
            try {

                animalLabel.setText(catRadioButton.getText());
                Image catImage = new Image(getClass().getResourceAsStream("/cat2.png"));
                animalImageView.setImage(catImage);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(lionRadioButton.isSelected()){
            try{
                animalLabel.setText(lionRadioButton.getText());
                Image lionImage = new Image(getClass().getResourceAsStream("/lion2.jpeg"));
                animalImageView.setImage(lionImage);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(unicornRadioButton.isSelected()){
            try{
                animalLabel.setText(unicornRadioButton.getText());
                Image unicornImage = new Image(getClass().getResourceAsStream("/unicorn.png"));
                animalImageView.setImage(unicornImage);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void searchAnimal(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ImageSearch.fxml"));
        root = loader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

