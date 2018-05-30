package ua.training.initializer;

import java.sql.*;

/**
 * Utility class to initialize and de-initialize DB for program to operate and clean DB after usage.
 */
public class DBInitializator {

    private final static DBInitializator INSTANCE = new DBInitializator();
    private Connection connection;

    private DBInitializator(){}


    private String getUrlDefault() {
        return DBParameters.URL_DEFAULT;
    }

    private String getUrlCustom() {
        return DBParameters.URL_CUSTOM;
    }

    private String getNAME() {
        return DBParameters.NAME;
    }

    private String getPASSWORD() {
        return DBParameters.PASSWORD;
    }

    private Connection getDefaultConnection() throws SQLException{
        setDefaultConnectionToDB();
        return connection;
    }

    private Connection getCustomConnection(){
        try {
            setCustomConnectionToDB();
        }
        catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }

    private Connection getValueOfConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    private void setDefaultConnectionToDB() throws SQLException {
        setConnection(DriverManager.getConnection(getUrlDefault(), getNAME(), getPASSWORD()));
    }

    private void setCustomConnectionToDB() throws SQLException{
        setConnection(DriverManager.getConnection(getUrlCustom(), getNAME(), getPASSWORD()));
    }

    private void closeConnectionToDB() throws SQLException{
        getValueOfConnection().close();
    }

    private void createDB() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate(DBStatements.CREATE_DB_STATEMENT);
    }

    private void dropDB() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate(DBStatements.DROP_DB_STATEMENT);
    }

    private void createTables() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate(DBStatements.CREATE_EMPLOYEE_TABLE_STATEMENT);
        statement.executeUpdate(DBStatements.CREATE_PROJECT_TABLE_STATEMENT);
        statement.executeUpdate(DBStatements.CREATE_TASK_TABLE_STATEMENT);
        statement.executeUpdate(DBStatements.CREATE_PROJECT_ARCHIVE_TABLE_STATEMENT);
        statement.executeUpdate(DBStatements.CREATE_TASK_ARCHIVE_TABLE_STATEMENT);
    }

    private void insertUserRecord(String record) throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate(record);
    }

    public void initializeDB(){
        try {
            getDefaultConnection();
            dropDB();
            createDB();
            closeConnectionToDB();
            getCustomConnection();
            createTables();
            insertUserRecord(DBStatements.INSERT_EMPLOYEE_RECORD_STATEMENT + DBStatements.INSERT_EMPLOYEE_RECORD1_VALUE);
            insertUserRecord(DBStatements.INSERT_EMPLOYEE_RECORD_STATEMENT + DBStatements.INSERT_EMPLOYEE_RECORD2_VALUE);
            insertUserRecord(DBStatements.INSERT_EMPLOYEE_RECORD_STATEMENT + DBStatements.INSERT_EMPLOYEE_RECORD3_VALUE);
            insertUserRecord(DBStatements.INSERT_EMPLOYEE_RECORD_STATEMENT + DBStatements.INSERT_EMPLOYEE_RECORD4_VALUE);
            insertUserRecord(DBStatements.INSERT_EMPLOYEE_RECORD_STATEMENT + DBStatements.INSERT_EMPLOYEE_RECORD5_VALUE);
            insertUserRecord(DBStatements.INSERT_EMPLOYEE_RECORD_STATEMENT + DBStatements.INSERT_EMPLOYEE_RECORD6_VALUE);
            insertUserRecord(DBStatements.INSERT_PROJECT_RECORD_STATEMENT + DBStatements.INSERT_PROJECT_RECORD1_VALUE);
            insertUserRecord(DBStatements.INSERT_PROJECT_RECORD_STATEMENT + DBStatements.INSERT_PROJECT_RECORD2_VALUE);
            insertUserRecord(DBStatements.INSERT_PROJECT_RECORD_STATEMENT + DBStatements.INSERT_PROJECT_RECORD3_VALUE);
            insertUserRecord(DBStatements.INSERT_PROJECT_RECORD_STATEMENT + DBStatements.INSERT_PROJECT_RECORD4_VALUE);
            insertUserRecord(DBStatements.INSERT_PROJECT_RECORD_STATEMENT + DBStatements.INSERT_PROJECT_RECORD5_VALUE);
            insertUserRecord(DBStatements.INSERT_PROJECT_RECORD_STATEMENT + DBStatements.INSERT_PROJECT_RECORD6_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD1_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD2_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD3_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD4_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD5_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD6_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD7_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD8_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD9_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD10_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD11_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD12_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD13_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD14_VALUE);
            insertUserRecord(DBStatements.INSERT_TASK_RECORD_STATEMENT + DBStatements.INSERT_TASK_RECORD15_VALUE);
            closeConnectionToDB();
        }
        catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deInitializeDB(){
        try {
            getDefaultConnection();
            dropDB();
            closeConnectionToDB();
        }
        catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static DBInitializator getInstance(){
        return INSTANCE;
    }
}
