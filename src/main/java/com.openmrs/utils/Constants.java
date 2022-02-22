package com.openmrs.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String PAGE_TITLE = "Login";

    public static List<String> actualLocations() {
        List<String> list = new ArrayList<>();
        list.add("Inpatient Ward");
        list.add("Isolation Ward");
        list.add("Laboratory");
        list.add("Outpatient Clinic");
        list.add("Pharmacy");
        list.add("Registration Desk");
        return list;
    }

    public static final String CANT_LOGIN_MESSAGE = "Please contact your System Administrator.";
    public static final String ERROR_MESSAGE_WITHOUT_CREDENTIAL_AND_LOCATION = "You must choose a location!";
    public static final String ERROR_MESSAGE_WITHOUT_CREDENTIAL_BUT_WITH_LOCATION = "Invalid username/password. Please try again.";
    public static final String FIND_PATIENT_RECORD_PAGE_NAME = "Find Patient Record";

    public static List<String> actualApps() {
        List<String> list = new ArrayList<>();
        list.add("Find Patient Record");
        list.add("Active Visits");
        list.add("Register a patient");
        list.add("Capture Vitals");
        list.add("Appointment Scheduling");
        list.add("Reports");
        list.add("Data Management");
        list.add("Configure Metadata");
        list.add("System Administration");

        return list;
    }

    public static List<String> getGeneralActions() {
        List<String> generalActionsList = new ArrayList<>();
        generalActionsList.add("Start Visit");
        generalActionsList.add("Add Past Visit");
        generalActionsList.add("Merge Visits");
        generalActionsList.add("Schedule Appointment");
        generalActionsList.add("Request Appointment");
        generalActionsList.add("Mark Patient Deceased");
        generalActionsList.add("Edit Registration Information");
        generalActionsList.add("Delete Patient");
        generalActionsList.add("Attachments");

        return generalActionsList;

    }

}
