module patrick.cheba.orace {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires javafx.web;
    requires javafx.webEmpty;
    requires org.xerial.sqlitejdbc;

    exports patrick.cheba.orace;
    opens patrick.cheba.orace to javafx.fxml;

}