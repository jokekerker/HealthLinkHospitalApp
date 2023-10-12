package Presenter;

import Model.User;
import Model.patient.Patient;
import java.util.LinkedList;

public interface IPersist {

    public void addUsers(LinkedList<User> userList);
    public void addPatients(LinkedList<Patient> patientList);
    public LinkedList<Patient> selectPatients();
}
