module zu.searchanimal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens zu.searchanimal to javafx.fxml;
    exports zu.searchanimal;
}