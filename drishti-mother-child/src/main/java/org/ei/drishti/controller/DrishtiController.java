package org.ei.drishti.controller;

import org.ei.commcare.listener.CommCareFormSubmissionRouter;
import org.ei.drishti.contract.*;
import org.ei.drishti.util.SafeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DrishtiController {
    private static Logger logger = LoggerFactory.getLogger(DrishtiController.class.toString());

    @Autowired
    public DrishtiController(CommCareFormSubmissionRouter router) {
        router.registerForDispatch(this);

    }

    public void registerMother(AnteNatalCareEnrollmentInformation enrollmentInformation, Map<String, String> extraData) {
        logger.info("Mother registration: " + enrollmentInformation);

        
    }

    public void updateANCCareInformation(AnteNatalCareInformation ancInformation) {
        logger.info("ANC care: " + ancInformation);
    }

    public void updateOutcomeOfANC(AnteNatalCareOutcomeInformation outcomeInformation) {
        logger.info("ANC outcome: " + outcomeInformation);
    }

    public void closeANCCase(AnteNatalCareCloseInformation closeInformation, Map<String, String> extraData) {
        logger.info("ANC close: " + closeInformation);
    }

    public void registerChild(ChildRegistrationRequest childInformation) {
        logger.info("New child registration: " + childInformation);

    }

    public void updateChildImmunization(ChildImmunizationUpdationRequest updationRequest, Map<String, String> extraData) {
        logger.info("Child immunization updation: " + updationRequest);

    }

    public void closeChildCase(ChildCloseRequest childCloseRequest) {
        logger.info("Child close: " + childCloseRequest);

    }

    public void registerEligibleCouple(EligibleCoupleRegistrationRequest eligibleCoupleRegistrationRequest, Map<String, String> extraData) {
        logger.info("Eligible couple registration: " + eligibleCoupleRegistrationRequest + ". Extra data: " + extraData);
    }

    public void closeEligibleCouple(EligibleCoupleCloseRequest eligibleCoupleCloseRequest) {
        logger.info("Eligible couple close: " + eligibleCoupleCloseRequest);
    }
}
