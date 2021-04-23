package com.code4joe.hosprest.ui.controller;

import com.code4joe.hosprest.backend.domain.HospitalEHR;
import com.code4joe.hosprest.backend.service.HospitalEHRService;
import com.code4joe.hosprest.config.ApplicationProperties;
import com.code4joe.hosprest.constant.ControllerConstants;
import com.code4joe.hosprest.constant.RequestParamConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final ApplicationProperties properties;
    private final HospitalEHRService hospitalEHRService;

    public IndexController(ApplicationProperties properties, HospitalEHRService hospitalEHRService) {
        this.properties = properties;
        this.hospitalEHRService = hospitalEHRService;
    }

    /**
     * The method is the root mapping.
     *
     * @param model the model
     * @return the index page.
     */
    @GetMapping(path = ControllerConstants.INDEX_URL_MAPPING)
    public String root(Model model) {
        List<HospitalEHR> hospitalEHRByState = hospitalEHRService.getHospitalEHRByStateInDesc();
        model.addAttribute("hospitalEHRByState", hospitalEHRByState);
        model.addAttribute(RequestParamConstants.PERIOD, properties.getPeriod());
        return ControllerConstants.INDEX_VIEW_NAME;
    }
}
