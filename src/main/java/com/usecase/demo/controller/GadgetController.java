package com.usecase.demo.controller;

import com.usecase.demo.model.Gadget;
import com.usecase.demo.model.UpdateQuanDTO;
import com.usecase.demo.repository.GadgetRepository;
import com.usecase.demo.service.GadgetService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.hibernate.mapping.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class GadgetController {

    public GadgetService gadgetService;
    public GadgetController(GadgetService gadgetService){
        this.gadgetService=gadgetService;
    }


    @GetMapping("/Gadgets")
    public ResponseEntity<List<Gadget>>fetchAll(@RequestParam String param) {
        List<Gadget>l= gadgetService.findAll();
        return ResponseEntity.ok(l);
    }

    @GetMapping("/Id/{id}")
    public ResponseEntity<Gadget> fetchById(@PathVariable Integer id) {
        Gadget Gid=gadgetService.findById(id);
        return ResponseEntity.ok(Gid);
    }

    @GetMapping("/Summary")
    public ResponseEntity<List<Gadget> >(@RequestParam List<Integer> lowhigh) {
        Integer low=lowhigh[0],high=lowhigh[1];
        List<Gadget> l=gadgetService.findGadgetsByPriceRange(low,high);
        return ResponseEntity.ok(l);
    }
    
    
    @PostMapping("/update/Quantity")
    public ResponseEntity<String> updateQuantity(@RequestBody  UpdateQuanDTO x) {
        Integer id=findIDForGivenMakeAndModel(x.make,x.model);
        Gadget xx=gadgetService.findById(id);
        xx.quantity=x.quantity;
        gadgetService.save(xx);
        return ResponseEntity.ok("Quantity updated");
    }

    @PostMapping("/update/Price")
    public String updatePrice(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
    
    
    @PostMapping("/addGadget")
    public void addGadget( @RequestBody Gadget gadget){
        gadgetService.save(gadget);
    }

    @PostMapping("/addGadgets")
    public String addGadgets (@RequestBody ArrayList<Gadget> gadgets) {
        //TODO: process POST request->return type of method is string for acknowledging the update
        //
        
        
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody String entity) {
        //TODO: process POST request
        
        
    }
    
    



}
