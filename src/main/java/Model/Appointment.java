package Model;

import Model.patient.Patient;
import java.util.Date;


public class Appointment {

    private Long id;
    private Long patientId;
    private String name;
    private String appointmentDate;
    private String symptom;
    private String gpName; 
    private AppointmentStatus status; // Enum: Scheduled, Completed, Canceled, etc.


    // Constructors, getters, and setters

    public Appointment() {
        
    }

    public Appointment(Long id, Long patientId, String name, String appointmentDate, String symptom, String gpName, AppointmentStatus status) {
        this.id = id;
        this.patientId = patientId;
        this.name = name;
        this.appointmentDate = appointmentDate;
        this.symptom = symptom;
        this.gpName = gpName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    
    
    
    }

    

    
