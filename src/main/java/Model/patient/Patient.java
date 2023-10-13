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
    private String contactPhone;
    private String email;
    private String emergencyContact;
    private String emergencyContactaPhone;
    private String bloodGroup;
    private String medicareNo;
    private String allergies;
    private String registeredBy;
    //private List<MedicalRecord> medicalRecords; // A Patient can have multiple medical records

    // Constructors, getters, and setters
    public Patient() {
    }

    public Patient(String name, String gender, String dateOfBirth, String address, String contactPhone, String email, String emergencyContact, String emergencyContactaPhone, String bloodGroup, String medicareNo, String allergies, String registeredBy) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactPhone = contactPhone;
        this.email = email;
        this.emergencyContact = emergencyContact;
        this.emergencyContactaPhone = emergencyContactaPhone;
        this.bloodGroup = bloodGroup;
        this.medicareNo = medicareNo;
        this.allergies = allergies;
        this.registeredBy = registeredBy;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactaPhone() {
        return emergencyContactaPhone;
    }

    public void setEmergencyContactaPhone(String emergencyContactaPhone) {
        this.emergencyContactaPhone = emergencyContactaPhone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMedicareNo() {
        return medicareNo;
    }

    public void setMedicareNo(String medicareNo) {
        this.medicareNo = medicareNo;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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
