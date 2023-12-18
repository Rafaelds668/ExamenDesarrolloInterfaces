module com.example.examendesarrollointerfaces {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.examendesarrollointerfaces to javafx.fxml;
    exports com.example.examendesarrollointerfaces;
}