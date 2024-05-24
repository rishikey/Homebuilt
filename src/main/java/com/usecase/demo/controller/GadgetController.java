package com.usecase.demo.controller;

import com.usecase.demo.model.Gadget;
import com.usecase.demo.service.GadgetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GadgetController {

    public GadgetService gadgetService;
    public GadgetController(GadgetService gadgetService){
        this.gadgetService=gadgetService;
    }

    @PostMapping("/addGadget")
    public void addGadget( Gadget gadget){
        gadgetService.save(gadget);
    }

}
