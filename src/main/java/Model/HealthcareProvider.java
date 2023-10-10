package Model;

public class HealthcareProvider {

    private Long id;
    private String firstName;
    private String lastName;
    private String specialization; // Doctor's specialization, nurse's department, etc.
    private String licenseNumber; // Healthcare provider's license or certification number
    // Other relevant attributes, such as contact information, qualifications, etc.

    // Constructors, getters, and setters
    // Additional methods as needed

    public HealthcareProvider() {
    }

    public HealthcareProvider(Long id, String firstName, String lastName, String specialization, String licenseNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
}
