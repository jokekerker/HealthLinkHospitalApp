/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.healthlinkhospitalapp;

import Presenter.PatientPersister;

/**
 *
 * @author nuii
 */
public class HealthLinkHospitalApp {

    public static void main(String[] args) {
        PatientPersister patientPersister = new PatientPersister();
        patientPersister.establishDatabaseConnection();
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
