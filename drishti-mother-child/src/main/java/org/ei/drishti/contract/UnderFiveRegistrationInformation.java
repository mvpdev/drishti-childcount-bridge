package org.ei.drishti.contract;

import java.text.MessageFormat;

public class UnderFiveRegistrationInformation {
    private String caseId;
    private String healthID;
    private String sex;
    private String fullname;
    private int birthweight;
    private String motherhealthid;
    private String householdhealthid;
    //private String locationcode;
    private String clinicdelivery;
    private String age;
    private String dob; 
    private String dobknown;
    private String monthyear;
    private String CHWIdentity;
    private String dobcalc;

                    
    public UnderFiveRegistrationInformation(String caseId, String dobcalc,  String CHWIdentity, String healthID, String sex, String fullname, String motherhealthid, String householdhealthid, String clinicdelivery, String age, String dob, String dobknow, String monthyear) {
        this.caseId = caseId;
        this.healthID = healthID;
        this.sex = sex;
        this.fullname = fullname;
        this.motherhealthid = motherhealthid;
        this.clinicdelivery = clinicdelivery;
        //this.locationcode = locationcode;
        this.householdhealthid = householdhealthid;
        this.birthweight = birthweight;
        this.dob = dob;
        this.age = age;
        this.dobknown = dobknown;
        this.monthyear = monthyear;
        this.CHWIdentity = CHWIdentity;
        this.dobcalc = dobcalc;
        
    }


    public String age(){
        if(dobknown == "yes"){
            return dob;
        }
        else{
            if(monthyear=="month"){
                return dobcalc;
            }
            else{
                return age+"y";
            }
        }
    }

    public String CHWIdentity(){
        return CHWIdentity;
    }
        
    public String caseId() {
        return caseId;
    }

    public String healthID() {
        return healthID;
    }

    public String sex() {
        return sex;
    }

    public String fullname() {
        return fullname;
    }

    public String householdhealthid() {
        return householdhealthid;
    }

    public String clinicdelivery() {
        return clinicdelivery;
    }

    public String motherhealthid() {
        return motherhealthid;
    }
    
    
    public int birthweight(){
        return birthweight;
    }
    
    
    @Override
    public String toString() {
        return MessageFormat.format("Child Registration :  healthID: {0}, Name: {1} , Case: {2}. ", healthID, fullname,  caseId);
    }
}
