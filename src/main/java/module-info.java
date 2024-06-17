module com.example.barbersystemm {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.barbersystemm to javafx.fxml;
    opens Model.Classes to javafx.base;

    exports com.example.barbersystemm;
    exports Model.Classes;
}