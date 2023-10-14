package Presenter;

import Model.Appointment;
import Model.AppointmentStatus;
import Model.Billing;
import Model.User;
import Model.patient.Patient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Persister implements IPersist {

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
    private PreparedStatement createTableAppointment;
    private PreparedStatement insertUser;
    private PreparedStatement insertPatient;
    private PreparedStatement insertAppointment;
    private PreparedStatement insertBilling;
    private PreparedStatement selectPatient;

    private List<User> userList;

    public Connection getConnection() {
        if (dbConnection == null) {
            establishDatabaseConnection();
        }
        return dbConnection;
    }

    public Persister() {
        MYSQL_URL = "jdbc:mysql://localhost:3306";
        DB_URL = MYSQL_URL + "/healthlinkshospital_db";

        USERNAME = "root";
        PASSWORD = "password";

        establishDatabaseConnection();
    }

    public void establishDatabaseConnection() {
        try {
            PreparedStatement replaceUser;
            //Connects to the SQL instance
            sqlConnection = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
            //Creates the database if not exists
            createDBHLHospital = sqlConnection.prepareStatement("create database if not exists healthlinkshospital_db");
            createDBHLHospital.executeUpdate();

            sqlConnection.close();

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
                    + "create table if not exists patient(\n"
                    + "patientid int not null auto_increment ,\n"
                    + "name varchar(100) not null,\n"
                    + "gender varchar(20) not null,\n"
                    + "dateofbirth varchar(50) not null,\n"
                    + "address varchar(80) not null,\n"
                    + "contactphone varchar(20) not null,\n"
                    + "email varchar(50) not null,\n"
                    + "emergencycontact varchar(100) not null,\n"
                    + "emergencycontactphone varchar(50) not null,\n"
                    + "bloodgroup varchar(50) not null,\n"
                    + "medicareno varchar(50) not null,\n"
                    + "allergies varchar(50) not null,\n"
                    + "registeredby varchar(100) not null,\n"
                    + "primary key (patientid))");
            createTableDiagnosis = dbConnection.prepareStatement(""
                    + "create table if not exists diagnosis(\n"
                    + "patientid int not null auto_increment ,\n"
                    + "symptom varchar(200) not null,\n"
                    + "diagnosis varchar(200) not null,\n"
                    + "medicines varchar(200) not null,\n"
                    + "recordby varchar(100) not null,\n"
                    + "primary key (patientid))");
            createTableBilling = dbConnection.prepareStatement(""
                    + "create table if not exists billing(\n"
                    + "billid int not null auto_increment,\n"
                    + "patientid int not null,\n"
                    + "invoicedate int not null,\n"
                    + "detail varchar(100) not null,\n"
                    + "unit int not null,\n"
                    + "amount int not null,\n"
                    + "total int not null,\n"
                    + "primary key (billid))");
            createTableAppointment = dbConnection.prepareStatement(""
                    + "create table if not exists appointment(\n"
                    + "appointmentid int not null auto_increment,\n"
                    + "patientid int not null, \n"
                    + "name varchar(50) not null, \n"
                    + "date varchar(50) not null, \n"
                    + "symptom varchar(200) not null, \n"
                    + "gpname varchar(50) not null, \n"
                    + "status varchar(20) not null, \n"
                    + "primary key (appointmentid))");
            createTableUser.executeUpdate();
            createTablePatient.executeUpdate();
            createTableDiagnosis.executeUpdate();
            createTableBilling.executeUpdate();
            createTableAppointment.executeUpdate();

            replaceUser = dbConnection.prepareStatement(
                    "replace into user"
                    + "(userid, name, username, password, email, role)"
                    + "values (1,'admin','admin','admin','admin@HLH.com.au','admin')"
            );
            replaceUser.executeUpdate();
            replaceUser = dbConnection.prepareStatement(
                    "replace into user"
                    + "(userid, name, username, password, email, role)"
                    + "values (2,'staff','staff','staff','staff@HLH.com.au','staff')"
            );
            replaceUser.executeUpdate();
            replaceUser = dbConnection.prepareStatement(
                    "replace into user"
                    + "(userid, name, username, password, email, role)"
                    + "values (3, 'user','user','user','user@HLH.com.au','user')"
            );
            replaceUser.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public Map<String, String> authenticateUser(String username, String password) {
        try {

            PreparedStatement selectUser = dbConnection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            selectUser.setString(1, username);
            selectUser.setString(2, password);
            ResultSet results = selectUser.executeQuery();

            if (results.next()) {
                Map<String, String> userDetails = new HashMap<>();
                userDetails.put("role", results.getString("role"));
                userDetails.put("username", results.getString("username"));
                return userDetails;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUsername(String role) {
        try {
            PreparedStatement selectUsername = dbConnection.prepareStatement("SELECT username FROM user WHERE role = ?");
            selectUsername.setString(1, role);
            ResultSet results = selectUsername.executeQuery();

            if (results.next()) {
                return results.getString("username");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addUsers(LinkedList<User> userList, Connection connection) {
        try {
            insertUser = connection.prepareStatement("INSERT INTO user (username, password, name, email, role) VALUES (?, ?, ?, ?, ?)");
            for (User oneUser : userList) {
                insertUser.setString(1, oneUser.getUsername());
                insertUser.setString(2, oneUser.getPassword());
                insertUser.setString(3, oneUser.getName());
                insertUser.setString(4, oneUser.getEmail());
                insertUser.setString(5, oneUser.getRoles());

                insertUser.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public void addPatients(LinkedList<Patient> patientList, Connection connection) {
        try {
            insertPatient = connection.prepareStatement("INSERT INTO patient (name, gender, dateofbirth, address, contactphone, email, emergencycontact, emergencycontactphone, bloodgroup, medicareno, allergies, registeredby) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (Patient onePatient : patientList) {
                insertPatient.setString(1, onePatient.getName());
                insertPatient.setString(2, onePatient.getGender());
                insertPatient.setString(3, onePatient.getDateOfBirth());
                insertPatient.setString(4, onePatient.getAddress());
                insertPatient.setString(5, onePatient.getContactPhone());
                insertPatient.setString(6, onePatient.getEmail());
                insertPatient.setString(7, onePatient.getEmergencyContact());
                insertPatient.setString(8, onePatient.getEmergencyContactaPhone());
                insertPatient.setString(9, onePatient.getBloodGroup());
                insertPatient.setString(10, onePatient.getMedicareNo());
                insertPatient.setString(11, onePatient.getAllergies());
                insertPatient.setString(12, onePatient.getRegisteredBy());
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
                        results.getString("name"),
                        results.getString("gender"),
                        results.getString("dateOfBirth"),
                        results.getString("adress"),
                        results.getString("contactNumber"),
                        results.getString("email"),
                        results.getString("emergencyContact"),
                        results.getString("emergencyContactPhone"),
                        results.getString("bloodGroup"),
                        results.getString("medicareNo"),
                        results.getString("allergies"),
                        results.getString("registeredBy")));

            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
        return patientList;
    }

    public boolean addAppointment(Appointment appointment, Connection connection) {
        try {
            PreparedStatement insertAppointment = connection.prepareStatement("INSERT INTO appointment (patientid, name, date, symptom, gpname, status) VALUES (?, ?, ?, ?, ?, ?)");

            // Set the values in the PreparedStatement
            insertAppointment.setLong(1, appointment.getPatientId());
            insertAppointment.setString(2, appointment.getName());
            insertAppointment.setString(3, appointment.getAppointmentDate());
            insertAppointment.setString(4, appointment.getSymptom());
            insertAppointment.setString(5, appointment.getGpName());
            insertAppointment.setString(6, appointment.getStatus().toString());

            // Execute the SQL query to insert the appointment
            int rowsAffected = insertAppointment.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                return true; // Insertion was successful
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }

        return false;
    }

    public List<Appointment> selectAppointments(String username) {
        List<Appointment> appointments = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();

            String sql = "SELECT * FROM appointment WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentDate(resultSet.getString("date"));
                appointment.setSymptom(resultSet.getString("symptom"));
                appointment.setGpName(resultSet.getString("gpname"));
                String statusString = resultSet.getString("status");
                AppointmentStatus status;
                if ("Schedule".equals(statusString)){
                    status = AppointmentStatus.Schedule;
                }else if("Completed".equals(statusString)){
                    status = AppointmentStatus.Completed;
                }else if("Canceled".equals(statusString)){
                    status = AppointmentStatus.Canceled;
                }else{
                    status = null;
                }
                appointment.setStatus(status);
                
                appointments.add(appointment);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return appointments;
    }

    public void addBilling(LinkedList<Billing> billingList, Connection connection) {
        try {
            insertBilling = connection.prepareStatement("INSERT INTO billing (patientid, name, date, detail, unit, amount, total) VALUES (?, ?, ?, ?, ?, ?, ?)");
            for (Billing oneBilling : billingList) {
                insertBilling.setLong(1, oneBilling.getPatientId());
                insertBilling.setString(2, oneBilling.getName());
                insertBilling.setString(3, oneBilling.getBillDate());
                insertBilling.setString(4, oneBilling.getDetail());
                insertBilling.setInt(5, oneBilling.getUnit());
                insertBilling.setInt(6, oneBilling.getAmount());
                insertBilling.setInt(7, oneBilling.getTotal());
                insertBilling.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    public Patient getPatientByID(String patientID, Connection connection) throws SQLException {
        String query = "SELECT * FROM Patient WHERE PatientID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, patientID);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Patient patient = new Patient();
            patient.setId(resultSet.getLong("PatientID"));
            patient.setName(resultSet.getString("Name"));
            // Set other patient properties as well

            return patient;
        } else {
            return null; // Patient not found
        }
    }

}
