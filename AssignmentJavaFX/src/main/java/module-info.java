module jobcreated.jobcreated {
    requires javafx.controls;
    requires javafx.fxml;


    opens javaFX to javafx.fxml;
    exports javaFX;
}