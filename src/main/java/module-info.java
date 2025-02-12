module org.example.mi_bocadillo_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.mariadb.jdbc;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens org.example.mi_bocadillo_javafx to javafx.fxml, org.hibernate.orm.core;
    exports org.example.mi_bocadillo_javafx;
    exports org.example.mi_bocadillo_javafx.dao;
    opens org.example.mi_bocadillo_javafx.dao to javafx.fxml, org.hibernate.orm.core;
    exports org.example.mi_bocadillo_javafx.controller;
    opens org.example.mi_bocadillo_javafx.controller to javafx.fxml, org.hibernate.orm.core;
    exports org.example.mi_bocadillo_javafx.util;
    opens org.example.mi_bocadillo_javafx.util to javafx.fxml, org.hibernate.orm.core;
    exports org.example.mi_bocadillo_javafx.model;
    opens org.example.mi_bocadillo_javafx.model to javafx.fxml, org.hibernate.orm.core;
    exports org.example.mi_bocadillo_javafx.service;
    opens org.example.mi_bocadillo_javafx.service to javafx.fxml, org.hibernate.orm.core;
}