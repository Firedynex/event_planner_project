module event_planner {
    requires javafx.controls;
    requires javafx.fxml;

    opens event_planner to javafx.fxml;
    exports event_planner;
}
