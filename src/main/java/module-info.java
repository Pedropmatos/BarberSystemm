module com.example.barbersystemm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.barbersystemm to javafx.fxml;
    exports com.example.barbersystemm;
}