package com.usecase.demo.service;

import com.usecase.demo.model.gadget;
import com.usecase.demo.repository.GadgetRepository;
import com.usecase.demo.repository.GadgetRepository;
import org.springframework.stereotype.Service;

@Service
public class GadgetService {
    private final GadgetRepository gadgetRepository;

    public GadgetService(GadgetRepository gadgetRepository){
        this.gadgetRepository= gadgetRepository;
    }

    public void save(Gadget gadget ){
        gadgetRepository.save(gadget);
    }
}
