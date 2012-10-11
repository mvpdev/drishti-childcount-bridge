package org.ei.drishti.controller;

import org.ei.commcare.listener.CommCareFormSubmissionRouter;
import org.ei.drishti.contract.*;
import org.ei.drishti.util.SafeMap;
import org.ei.drishti.ccforms.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DrishtiController {
    private static Logger logger = LoggerFactory.getLogger(DrishtiController.class.toString());
    
    private ChildcountFormA FormA;
    private ChildcountFormB FormB;

    @Autowired
    public DrishtiController(CommCareFormSubmissionRouter router, ChildcountFormA FormA, ChildcountFormB FormB) {
        router.registerForDispatch(this);
        this.FormA = FormA;
        this.FormB = FormB;
    }

    
    //Under Five Module
    public void registerUnderFive(UnderFiveRegistrationInformation childInformation) {
        logger.info("Child Registration: " + childInformation);
        FormA.registerUnderFive(childInformation);
    }

   
    //Pregnancy Module
    public void registerPregnancy(PregnancyRegistrationInformation pregnancyInformation) {
        logger.info("Pregnancy Registration: " + pregnancyInformation);
        FormA.registerPregnancy(pregnancyInformation);
    }
    
    public void PregnancyVisit(PregnancyVisitForm visitInformation){
        logger.info("Pregnancy Visit: " + visitInformation);
        FormB.pregnancyvisit(visitInformation);
    }
    
    //Household Module
    public void registerHouseholds(HouseholdRegistrationInformation householdInformation){
        logger.info("Household Registration: " + householdInformation);
        FormA.registerHousehold(householdInformation);
    }
    
    public void HouseholdVisit(HouseholdVisitForm visitInformation){
        logger.info("Household Visit: " + visitInformation);
        FormB.householdvisit(visitInformation);
    }
   

}
