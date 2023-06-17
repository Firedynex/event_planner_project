module event_planner {
    requires javafx.controls;
    requires javafx.fxml;

    requires transitive java.net.http;
    requires transitive com.google.gson;

    opens event_planner to javafx.fxml;
    exports event_planner;
}
