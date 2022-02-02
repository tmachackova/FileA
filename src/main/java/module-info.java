module com.example.filea {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.filea to javafx.fxml;
    exports com.example.filea;
}