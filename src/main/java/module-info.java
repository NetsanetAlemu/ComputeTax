module com.example.computeincometax {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.computeincometax to javafx.fxml;
    exports com.example.computeincometax;
}