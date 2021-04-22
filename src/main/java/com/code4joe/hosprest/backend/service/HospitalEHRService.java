package com.code4joe.hosprest.backend.service;

import com.code4joe.hosprest.backend.domain.HospitalEHR;

import java.util.List;

/**
 * This is the contract for the HospitalEHRService.
 *
 * @author Matthew Puentes
 */
public interface HospitalEHRService {

    /**
     * Connects to the appropriate endpoint and get, by state and in descending order,
     * the percentage of hospitals that support basic EHR notes in the year 2014.
     *
     * @return list of hospitalEHR
     */
    List<HospitalEHR> getHospitalEHRByStateInDesc();
}
