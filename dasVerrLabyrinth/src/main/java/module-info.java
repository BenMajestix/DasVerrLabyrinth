module com.benpaul.dasverrlabyrinth {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.benpaul.dasverrlabyrinth to javafx.fxml;
    exports com.benpaul.dasverrlabyrinth;
}
