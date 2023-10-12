package Model.patient;

import Model.MedicalRecord;
import java.time.LocalDate;
import java.util.List;

public class Patient {

    private Long id;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    //private List<MedicalRecord> medicalRecords; // A Patient can have multiple medical records

    // Constructors, getters, and setters
    public Patient() {
    }

    public Patient(Long id, String name, String gender, String dateOfBirth, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        //this.medicalRecords = medicalRecords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
    // Methods for adding and retrieving medical records
*/
    
}
