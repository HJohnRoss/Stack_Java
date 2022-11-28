package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
//... imports class definition...
    
    public AdminUser(int idParam, String role) {
		super(idParam);
		this.role = role;
		// TODO Auto-generated constructor stub
	}
	// Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    @Override
	public boolean assignPin(int pin) {
    	int lenPin = String.valueOf(pin).length();
    	if(lenPin > 5) {
    		return true;
    	} else {
    		return false;
    	}
    }
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(confirmedAuthID == this.id) {
    		return true;
    	} else {
    		authIncident();
    		return false;
    	}
    }
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
    	return securityIncidents;
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
}
