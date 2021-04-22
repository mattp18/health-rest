package com.code4joe.hosprest.backend.service.impl;

import com.code4joe.hosprest.backend.domain.HospitalEHR;
import com.code4joe.hosprest.backend.service.HospitalEHRService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalEHRServiceImpl implements HospitalEHRService {
    /**
     * Connects to the appropriate endpoint and get, by state and in descending order,
     * the percentage of hospitals that support basic EHR notes in the year 2014.
     *
     * @return list of hospitalEHR
     */
    @Override
    public List<HospitalEHR> getHospitalEHRByStateInDesc() {
        return null;
    }
}
