package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...
    
    // Inside class:    
	
    // TO DO: Constructor that takes an ID
    public Physician(int id) {
    	super(id);
    }
	
    // TO DO: Setters & Getters
    @Override
	public boolean assignPin(int pinParam) {
    	int lenPin = String.valueOf(pinParam).length();
	    	if(lenPin == 4) {
	    		return true;
	    	} else {
	    		return false;
	    	}
    }

    @Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(id == confirmedAuthID) {
			return true;
		} else {
			return false;
		}
	}
    
    private ArrayList<String> patientNotes;
    
    public void newPatientNotes(String notes, String patientName, Date date) {
    	String report = String.format(
    			"Datetime Submitted: %s \n", date);
    	report += String.format("Reported By ID: %s\n", this.id);
    	report += String.format("Patient Name: %s\n", patientName);
    	report += String.format("Notes: %s \n", notes);
    	this.patientNotes.add(report);
    }
}

