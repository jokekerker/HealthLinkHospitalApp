package Presenter;

import Model.User;
import Model.patient.Patient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PatientPersister implements IPersist {

    private final String MYSQL_URL;
    private final String DB_URL;
    private final String USERNAME;
    private final String PASSWORD;
    private Connection sqlConnection;
    private Connection dbConnection;
    private PreparedStatement createDBHLHospital;
    private PreparedStatement createTableUser;
    private PreparedStatement createTablePatient;
    private PreparedStatement createTableDiagnosis;
    private PreparedStatement createTableBilling;
    private PreparedStatement insertUser;
    private PreparedStatement insertPatient;
    private PreparedStatement selectPatient;

    private List<User> userList;

    public PatientPersister() {
        MYSQL_URL = "jdbc:mysql://localhost:3306";
        DB_URL = MYSQL_URL + "/healthlinkshospital_db";

        USERNAME = "root";
        PASSWORD = "password";

    }

    public void establishDatabaseConnection() {
        try {
            PreparedStatement replaceUser;
            //Connects to the SQL instance
            sqlConnection = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
            //Creates the database if not exists
            createDBHLHospital = sqlConnection.prepareStatement("create database if not exists payroll_db");
            createDBHLHospital.executeUpdate();
            if (sqlConnection != null) {
                sqlConnection.close();
            }
            //Connects to database
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            createTableUser = dbConnection.prepareStatement(""
                    + "create table if not exists user(\n"
                    + "userid int not null auto_increment,\n"
                    + "name varchar(50) not null, \n"
                    + "username varchar(50) not null,\n"
                    + "password varchar(10) not null,\n"
                    + "email varchar(50) not null, \n"
                    + "role varchar(50) not null, \n"
                    + "primary key (userid))");
            createTablePatient = dbConnection.prepareStatement(""
                    + "create table if not exists employee(\n"
                    + "patientid int not null auto_increment ,\n"
                    + "name varchar(100) not null,\n"
                    + "gender varchar(20) not null,\n"
                    + "dateofbirth varchar(50) not null,\n"
                    + "address varchar(80) not null,\n"
                    + "contactphone varchar(20) not null,\n"
                    + "email varchar(50) not null,\n"
                    + "primary key (patientid))");
            createTableDiagnosis = dbConnection.prepareStatement(""
                    + "create table if not exists employee(\n"
                    + "patientid int not null auto_increment ,\n"
                    + "symptom varchar(200) not null,\n"
                    + "diagnosis varchar(200) not null,\n"
                    + "medicines varchar(200) not null,\n"
                    + "recordby varchar(100) not null,\n"
                    + "primary key (patientid))");
            createTableBilling = dbConnection.prepareStatement(""
                    + "create table if not exists payroll(\n"
                    + "billid int not null auto_increment,\n"
                    + "patientid int not null,\n"
                    + "invoicedate int not null,\n"
                    + "detail varchar(100) not null,\n"
                    + "unit int not null,\n"
                    + "amount int not null,\n"
                    + "total int not null,\n"
                    + "primary key (billid))");
            createTableUser.executeUpdate();
            createTablePatient.executeUpdate();
            createTableBilling.executeUpdate();

            replaceUser = dbConnection.prepareStatement(
                    "replace into user"
                    + "(id, name, username, password, email, role)"
                    + "values (1, 'admin','admin','admin','admin@HLH.com.au','admin')"
            );
            replaceUser.executeUpdate();
            replaceUser = dbConnection.prepareStatement(
                    "replace into user"
                    + "(id, name, username, password, email, role)"
                    + "values (2, 'hol','hols','holS453','hols@HLH.com.au','staff')"
            );
            replaceUser.executeUpdate();
            replaceUser = dbConnection.prepareStatement(
                    "replace into user"
                    + "(id, name, username, password, email)"
                    + "values (3, 'jon','john','johN789','john@HLH.com.au','user')"
            );
            replaceUser.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public String authenticateUser(String username, String password) {
        try {
            PreparedStatement selectUser = dbConnection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            selectUser.setString(1, username);
            selectUser.setString(2, password);
            ResultSet results = selectUser.executeQuery();
            
            if(results.next()){
                return results.getString("role");
            }else{
                return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addUsers(LinkedList<User> userList) {
        try {
            for (User oneUser : userList) {
                insertUser.setLong(1, oneUser.getId());
                insertUser.setString(2, oneUser.getUsername());
                insertUser.setString(3, oneUser.getPassword());
                insertUser.setString(4, oneUser.getName());
                insertUser.setString(5, oneUser.getEmail());
                insertUser.setString(6, oneUser.getRoles());
                insertUser.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void addPatients(LinkedList<Patient> patientList) {
        try {
            for (Patient onePatient : patientList) {
                insertPatient.setString(1, onePatient.getName());
                insertPatient.setString(2, onePatient.getGender());
                insertPatient.setString(3, onePatient.getDateOfBirth());
                insertPatient.setString(4, onePatient.getAddress());
                insertPatient.setString(5, onePatient.getPhoneNumber());
                insertPatient.setString(6, onePatient.getEmail());
                insertPatient.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    //Synchronised select of all records from residence needful table 
    public LinkedList<Patient> selectPatients() {

        LinkedList<Patient> patientList = new LinkedList<>();
        try {
            ResultSet results = selectPatient.executeQuery();
            while (results.next()) {
                patientList.add(new Patient(
                        results.getLong("id"),
                        results.getString("name"),
                        results.getString("gender"),
                        results.getString("dateOfBirth"),
                        results.getString("adress"),
                        results.getString("phoneNumber"),
                        results.getString("email")));
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
        return patientList;
    }
}
