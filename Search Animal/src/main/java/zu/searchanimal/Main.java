package zu.searchanimal;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


public class Main extends Application {

    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Animal-RadioBox.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            close(stage);
        });
    }

    public void close(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setContentText("Are you sure you want to close?");
        alert.setHeaderText("Click OK to confirm, or Cancel to return.");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}

