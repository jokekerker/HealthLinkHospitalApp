

package com.mycompany.healthlinkhospitalapp;

import Presenter.PatientPersister;

public class HealthLinkHospitalApp {

    public static void main(String[] args) {
        PatientPersister patientPersister = new PatientPersister();
        patientPersister.establishDatabaseConnection();
        
        java.awt.EventQueue.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            String userRole = authenticateUser(loginFrame);
            Home home = new Home();
            home.displayUsername(userRole);
        });
    }
    
    private static String authenticateUser(LoginFrame loginFrame){
        return "admin";
    }
}
