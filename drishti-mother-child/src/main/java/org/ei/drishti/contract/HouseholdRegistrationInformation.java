package org.ei.drishti.contract;

import java.text.MessageFormat;
import org.motechproject.util.DateUtil;
import java.util.Date;

public class HouseholdRegistrationInformation {
    private String caseId;
    private String healthID;
    private String sex;
    private String fullname;
    private String dobknown;
    private String locationcode;
    private String age;
    private String dob;
    private String mobile;
    private String CHWIdentity;

                    
    public HouseholdRegistrationInformation( String healthID, String CHWIdentity, String locationcode, String sex, String fullname, String age, String dob, String dobknown, String mobile) {
        this.healthID = healthID;
        this.sex = sex;
        this.fullname = fullname;
        this.locationcode = locationcode;
        this.dob = dob;
        this.age = age;
        this.dobknown = dobknown;
        this.mobile = mobile;
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
          
    public String mobile()
    {
        return mobile;
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

    public String locationcode() {
        return locationcode;
    }
        

    @Override
    public String toString() {
        return MessageFormat.format("Household Registration :  healthID: {0}, Name: {1} , Case: {2}. ", healthID, fullname,  caseId);
    }
}
