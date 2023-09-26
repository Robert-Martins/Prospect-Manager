package com.prospect.manager.presentation.controllers;

import com.prospect.manager.presentation.services.IProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/prospects")
public class ProspectController {

    @Autowired
    private IProspectService prospectService;

}
