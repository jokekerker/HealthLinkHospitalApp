package Model;

import Model.patient.Patient;
import java.time.LocalDateTime;

public class Appointment {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Patient patient; // The Patient for whom the appointment is scheduled
    private HealthcareProvider healthcareProviders; //
    private AppointmentStatus status; // Enum: Scheduled, Completed, Canceled, etc.
    private String reason; // Reason for the appointment
    // Additional attributes as needed

    // Constructors, getters, and setters

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime startTime, LocalDateTime endTime, Patient patient, HealthcareProvider healthcareProviders, AppointmentStatus status, String reason) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.patient = patient;
        this.healthcareProviders = healthcareProviders;
        this.status = status;
        this.reason = reason;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HealthcareProvider getHealthcareProviders() {
        return healthcareProviders;
    }

    public void setHealthcareProviders(HealthcareProvider healthcareProviders) {
        this.healthcareProviders = healthcareProviders;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
}
