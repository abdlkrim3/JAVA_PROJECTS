module JDBCJAVAFX {
    requires javafx.fxml;
    requires javafx.controls;
    requires  java.sql;



    opens ma.enset.tpjdbc to javafx.fxml;
    opens ma.enset.tpjdbc.presentation.controllers to javafx.fxml,javafx.controls;
    exports ma.enset.tpjdbc.Presentation.controllers to javafx.controls,javafx.fxml;
}