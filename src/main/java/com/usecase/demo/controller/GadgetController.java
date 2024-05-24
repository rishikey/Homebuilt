package com.usecase.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GadgetController {

    public GadegetService gadgetService;
    public GadgetController(GadgetService gadgetService){
        this.gadgetService=gadgetService;
    }

    @PostMapping("/addGadget")
    public void addGadget( Gadget gadget){
        gadgetService.save(gadget);
    }

}
