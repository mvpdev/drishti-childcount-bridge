package org.ei.drishti.contract;

import java.text.MessageFormat;
import org.motechproject.util.DateUtil;
import java.util.Date;

public class PregnancyRegistrationInformation {
    private String caseId;
    private String healthID;
    private String fullname;
    private String householdhealthid;
    private String edd;
    private String dobknown;
    private String eddknown;
    private String age;
    private String dob; 
    private String mobile; 
    private String sex;
    private String CHWIdentity;
                        
                    
    public PregnancyRegistrationInformation(String caseId, String CHWIdentity, String healthID, String fullname,  String householdhealthid, String dobknown, String mobile, String age, String dob) {
        this.caseId = caseId;
        this.healthID = healthID;
        this.fullname = fullname;
        this.householdhealthid  = householdhealthid;
        this.dob = dob;
        this.age = age;
        this.dobknown = dobknown;
        this.mobile = mobile;
        this.sex = "F";
        this.CHWIdentity = CHWIdentity;
    }

    public String age(){
        if(dobknown == "yes"){
            return dob;
        }
        else{
            return age+"y";
        }
    }

    public String CHWIdentity(){
        return CHWIdentity;
    }
        
    public String mobile(){
        return mobile;
    }
    
    public String caseId() {
        return caseId;
    }

    public String healthID() {
        return healthID;
    }

    public String fullname() {
        return fullname;
    }
    
    public String sex() {
        return sex;
    }
    
    public String householdhealthid() {
        return householdhealthid;
    }

    public String locationcode() {
        return "commcare";
    }
        
    @Override
    public String toString() {
        return MessageFormat.format("Pregnancy Registration : healthID: {0}, Name: {1}, Case: {2}. age: {5} : {3} dob: {4}", healthID, fullname, caseId, age, dob, dobknown);
    }
}
