module com.isha.inventorymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires servlet.api;
    requires org.json;
    requires java.sql;
    requires javafx.base;

    opens com.isha.inventorymanagementsystem to javafx.fxml;
    exports com.isha.inventorymanagementsystem;

    opens com.isha.inventorymanagementsystem.classes to javafx.base;
    exports com.isha.inventorymanagementsystem.classes;
}