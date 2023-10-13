

package com.mycompany.healthlinkhospitalapp;

import Presenter.Persister;

public class HealthLinkHospitalApp {

    public static void main(String[] args) {
        Persister patientPersister = new Persister();
        patientPersister.establishDatabaseConnection();
        
        java.awt.EventQueue.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            String userRole = authenticateUser(loginFrame);
            Home home = new Home();
            home.displayUsername();
        });
    }
    
    private static String authenticateUser(LoginFrame loginFrame){
        return "admin";
    }
}
