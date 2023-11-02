module com.example.mod7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.mod7 to javafx.fxml;
    exports com.example.mod7;
}