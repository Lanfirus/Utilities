package ua.training.initializer;

public interface DBParameters {

    String URL_DEFAULT = "jdbc:mysql://localhost/mysql?verifyServerCertificate=false&useSSL=true";
    String URL_CUSTOM = "jdbc:mysql://localhost/time_tracking?characterEncoding=utf8&verifyServerCertificate=false&useSSL=true";
    String NAME = "admin";
    String PASSWORD = "admin";
}
