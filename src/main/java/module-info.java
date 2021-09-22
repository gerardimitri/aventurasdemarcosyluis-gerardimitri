module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aventurasdemarcoyluis to javafx.fxml;
    exports com.example.aventurasdemarcoyluis;
    exports com.example.aventurasdemarcoyluis.Items;
    opens com.example.aventurasdemarcoyluis.Items to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.Players;
    opens com.example.aventurasdemarcoyluis.Players to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.Enemies;
    opens com.example.aventurasdemarcoyluis.Enemies to javafx.fxml;
}