
package Model;

import java.util.Set;


public class User {
    private Long id;
    private String username;
    private String password; 
    private String firstName;
    private String lastName;
    private String email;
    private Set<Role> roles; // A User can have multiple roles (e.g., doctor, nurse, admin)
    // Other relevant attributes, such as contact information, etc.

    // Constructors, getters, and setters

    public User() {
    }
    
    public User(Long id, String username, String password, String firstName, String lastName, String email, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }
    

    // Methods for adding and removing roles, if needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
