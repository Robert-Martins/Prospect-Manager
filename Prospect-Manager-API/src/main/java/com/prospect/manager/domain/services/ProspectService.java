package com.prospect.manager.domain.services;

import com.prospect.manager.domain.repositories.ProspectRepository;
import com.prospect.manager.presentation.services.IProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProspectService implements IProspectService {

    @Autowired
    private ProspectRepository prospectRepository;

}
