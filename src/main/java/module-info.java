module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ansavanix.ktanesolver to javafx.fxml;
    exports com.ansavanix.ktanesolver;
}