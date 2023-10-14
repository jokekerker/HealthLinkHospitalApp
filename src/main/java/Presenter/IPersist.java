package Presenter;

import Model.User;
import Model.patient.Patient;
import java.sql.Connection;
import java.util.LinkedList;

public interface IPersist {

    public Long addUsers(LinkedList<User> userList, Connection connection);
    public void addPatients(LinkedList<Patient> patientList, Long userId, Connection connection);
    public LinkedList<Patient> selectPatients();
}
