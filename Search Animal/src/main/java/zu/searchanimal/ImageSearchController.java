package zu.searchanimal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javafx.stage.Stage;
import org.json.JSONObject;

public class ImageSearchController {

    @FXML
    private TextField animalTextField;
    @FXML
    private Button searchButton;
    @FXML
    private ImageView animalImageView;
    @FXML
    private Button backButton;

    private static final String ACCESS_KEY = "kCWaP-etOOiwxDmMCUSaFpO6qPCUeNMa_cPeSDgFVGY";

    @FXML
    public void searchAnimal() {
        String animalName = animalTextField.getText().trim();

        if (!animalName.isEmpty()) {
            try {
                String apiUrl = "https://api.unsplash.com/photos/random?query=" + animalName + "&client_id=" + ACCESS_KEY;

                HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
                connection.setRequestMethod("GET");

                InputStream responseStream = connection.getInputStream();
                Scanner scanner = new Scanner(responseStream).useDelimiter("\\A");
                String response = scanner.hasNext() ? scanner.next() : "";

                JSONObject jsonResponse = new JSONObject(response);
                String imageUrl = jsonResponse.getJSONObject("urls").getString("regular");

                Image image = new Image(imageUrl, true);
                animalImageView.setImage(image);

            } catch (Exception e) {
                e.printStackTrace();
                // Handle error (e.g., show an alert)
            }
        }
    }

    public void goBack (ActionEvent event) throws Exception{

        Parent previousScene = FXMLLoader.load(getClass().getResource("Animal-RadioBox.fxml"));
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(new Scene(previousScene));
    }

}
