module com.example.manageanimals {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.manageanimals to javafx.fxml;
    exports com.example.manageanimals;
}