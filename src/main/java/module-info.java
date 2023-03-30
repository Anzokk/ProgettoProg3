module finale.finale {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens finale.finale to javafx.fxml;
    exports finale.finale;
}