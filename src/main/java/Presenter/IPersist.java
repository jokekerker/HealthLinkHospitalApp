package Presenter;

import Model.User;
import Model.patient.Patient;
import java.sql.Connection;
import java.util.LinkedList;

public interface IPersist {

    public Integer addUsers(LinkedList<User> userList, Connection connection);
    public void addPatients(LinkedList<Patient> patientList, Integer userId, Connection connection);
    public LinkedList<Patient> selectPatients();
}
