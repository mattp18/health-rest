package com.code4joe.hosprest.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalEHR implements Serializable {

    /**
     * The serialization runtime associates with each serializable class a version
     *  * number, called a serialVersionUID, which is used during deserialization to
     *  * verify that the sender and receiver of a serialized object have loaded
     *  * classes for that object that are compatible with respect to serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The region name for the data. This includes all 50 states and the District of Columbia.
     */
    private String region;

    /**
     * Time period for the data. Year in which data was collected through survey.
     */
    private String period;

    /**
     * Percent of All Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    @JsonProperty("pct_hospitals_basic_ehr_notes")
    private String pctHospitalsBasicEhrNotes;

    /**
     * Percent of Rural Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    @JsonProperty("pct_rural_hospitals_basic_ehr_notes")
    private String pctRuralHospitalsBasicEhrNotes;

    /**
     * Percent of Small Hospitals that have Adopted at least a Basic EHR with Clinician Notes.
     */
    @JsonProperty("pct_small_hospitals_basic_ehr_notes")
    private String pctSmallHospitalsBasicEhrNotes;
}
