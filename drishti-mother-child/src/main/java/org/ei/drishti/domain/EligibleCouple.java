package org.ei.drishti.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;

@TypeDiscriminator("doc.type === 'EligibleCouple'")
public class EligibleCouple extends MotechBaseDataObject {
    @JsonProperty
    private String caseId;
    @JsonProperty
    private String ecNumber;
    @JsonProperty
    private String wife;
    @JsonProperty
    private String husband;
    @JsonProperty
    private String anmIdentifier;
    @JsonProperty
    private String village;
    @JsonProperty
    private String subCenter;
    @JsonProperty
    private String phc;
    @JsonProperty
    private String currentMethod;

    public EligibleCouple() {
    }

    public EligibleCouple(String caseId, String ecNumber) {
        this.caseId = caseId;
        this.ecNumber = ecNumber;
    }

    public EligibleCouple withCouple(String wife, String husband) {
        this.wife = wife;
        this.husband = husband;
        return this;
    }

    public EligibleCouple withANMIdentifier(String anmIdentifier) {
        this.anmIdentifier = anmIdentifier;
        return this;
    }

    public EligibleCouple withFamilyPlanning(String currentMethod) {
        this.currentMethod = currentMethod;
        return this;
    }

    public EligibleCouple withLocation(String village, String subCenter, String phc) {
        this.village = village;
        this.subCenter = subCenter;
        this.phc = phc;
        return this;
    }

    public String wife() {
        return wife;
    }

    public String caseId() {
        return caseId;
    }

    private String getCaseId() {
        return caseId;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(o, this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
