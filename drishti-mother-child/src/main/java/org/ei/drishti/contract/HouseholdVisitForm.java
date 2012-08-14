package org.ei.drishti.contract;

import java.text.MessageFormat;

public class HouseholdVisitForm {
    private String caseId;
    private String healthID;
    private String CHWIdentity;
    private String women_count;
    private String women_using_fplanning;
    private String fplanning_method;
    //visit section
    private String member_available;
    private int under_five;
    private String advice_given;
    //sick section
    private String other_sickmembers;
    private String any_rdt;
    private String no_rdt;
    private String positive_rdt;
    private String anti_malarial;
    private String num_anti_malarial;
    

                    
    public HouseholdVisitForm(String caseId, String CHWIdentity, String healthID, String member_available, String advice_given, String no_rdt, String positive_rdt, String women_using_fplanning, String fplanning_method, String women_count, String other_sickmembers, String any_rdt, String num_anti_malarial, String anti_malarial) {
        this.caseId = caseId;
        this.healthID = healthID;
        this.women_count = women_count;
        this.women_using_fplanning = women_using_fplanning;
        this.fplanning_method = fplanning_method;
        this.member_available = member_available;
        this.under_five = 0;
        this.advice_given = advice_given;
        this.other_sickmembers = other_sickmembers;
        this.no_rdt = no_rdt;
        this.anti_malarial = anti_malarial;
        this.num_anti_malarial = num_anti_malarial;
        this.any_rdt = any_rdt;
        this.positive_rdt = positive_rdt;
        this.CHWIdentity = CHWIdentity;
    }


    public String CHWIdentity(){
        return CHWIdentity;
    }
    
    public String healthID() {
        return healthID;
    }
            
    public String caseId() {
        return caseId;
    }

    public String anti_malarial() {
        return anti_malarial;
    }

    public String num_anti_malarial() {
        return num_anti_malarial;
    }

    public String any_rdt() {
        return any_rdt;
    }
    public String no_rdt() {
        return no_rdt;
    }

    public String positive_rdt() {
        return positive_rdt;
    }
    
    public String other_sickmembers() {
        return other_sickmembers;
    }
    
    public String advice_given() {
        return advice_given;
    }
    
    public int under_five() {
        return under_five;
    }
    
    public String member_available() {
        return member_available;
    }
    
    public String fplanning_method() {
        return fplanning_method;
    }
    
    public String women_using_fplanning() {
        return women_using_fplanning;
    }
    
    public String women_count() {
        return women_count;
    }
    
    
    @Override
    public String toString() {
        return MessageFormat.format("Household Visit: healthID: {0}, Case: {2}. ", healthID, caseId);
    }
}
