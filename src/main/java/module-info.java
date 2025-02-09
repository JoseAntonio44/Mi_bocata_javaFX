module org.example.mi_bocadillo_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens org.example.mi_bocadillo_javafx to javafx.fxml;
    exports org.example.mi_bocadillo_javafx;
    exports org.example.mi_bocadillo_javafx.controller;
    opens org.example.mi_bocadillo_javafx.controller to javafx.fxml;
}