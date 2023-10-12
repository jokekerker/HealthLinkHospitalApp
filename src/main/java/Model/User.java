
package Model;

import java.util.Set;


public class User {
    private Long id;
    private String username;
    private String password; 
    private String name;
    private String email;
    private String roles; 
    // Other relevant attributes, such as contact information, etc.

    // Constructors, getters, and setters

    public User() {
    }
    
    public User(Long id, String username, String password, String name, String lastName, String email, String roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
