module com.isha.inventorymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.isha.inventorymanagementsystem to javafx.fxml;
    exports com.isha.inventorymanagementsystem;
}