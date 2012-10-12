package org.ei.drishti.contract;

import java.text.MessageFormat;

public class UnderFiveVisitForm {
    private String caseId;
    private String healthID;
    private String CHWIdentity;
    
    private String visitedHospital;
    private String conditionImproved;
    private String prevReferralType;
    
    private String emergencydangerSigns;
    private String immediatedangerSigns;
    
    private String referralGiven;
    private String referralType;
    
    private String iron;
    private String folic;    
    
    public UnderFiveVisitForm(String caseId, String CHWIdentity, String healthID, String visitedHospital, String conditionImproved, String prevReferralType, String emergencydangerSigns, String immediatedangerSigns, String referralGiven, String referralType) {
        this.caseId = caseId;
        this.healthID = healthID;
        this.visitedHospital = CHWIdentity;
        this.CHWIdentity = visitedHospital;
        this.conditionImproved = conditionImproved;
        this.prevReferralType = prevReferralType;
        this.emergencydangerSigns = emergencydangerSigns;
        this.immediatedangerSigns = immediatedangerSigns;
        this.referralGiven = referralGiven;
        this.referralType = referralType;

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

    public String referralType() {
        return referralType;
    }

    public String referralGiven() {
        return referralGiven;
    }
    
    @Override
    public String toString() {
        return MessageFormat.format("UnderFive Visit: HealthID: {0}, Case: {2}. ", healthID, caseId);
    }
}
