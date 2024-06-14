package com.usecase.demo.controller;

import com.usecase.demo.model.DeleteDTO;
import com.usecase.demo.model.Gadget;
import com.usecase.demo.model.UpdatePriceDTO;
import com.usecase.demo.model.UpdateQuanDTO;
import com.usecase.demo.repository.GadgetRepository;
import com.usecase.demo.service.GadgetService;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.hibernate.mapping.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<List<Gadget>>fetchAll() {
        List<Gadget>l= gadgetService.findAll();
        return ResponseEntity.ok(l);
    }

    @GetMapping("/Id/{id}")
    public ResponseEntity<Gadget> fetchById(@PathVariable Integer id) {
        Gadget Gid=gadgetService.findById(id);
        return ResponseEntity.ok(Gid);
    }

    @GetMapping("/Summary")
    public ResponseEntity<List<Gadget> >summary(@RequestParam int low,@RequestParam int high) {

        List<Gadget> l=gadgetService.findGadgetsByPriceRange(low,high);
        return ResponseEntity.ok(l);
    }
    
    
    @PostMapping("/update/Quantity")
    public ResponseEntity<String> updateQuantity(@RequestBody  UpdateQuanDTO updatequandto) {
        Integer id=gadgetService.findIDForGivenMakeAndModel(updatequandto.make,updatequandto.model);
        Gadget xx=gadgetService.findById(id);
        xx.quantity=updatequandto.quantity;
        gadgetService.save(xx);
        return ResponseEntity.ok("Quantity updated");
    }

    @PostMapping("/update/Price")
    public ResponseEntity<String> updatePrice(@RequestBody  UpdatePriceDTO updatepricedto) {
        Integer id=gadgetService.findIDForGivenMakeAndModel(updatepricedto.make,updatepricedto.model);
        Gadget xx=gadgetService.findById(id);
        xx.price=updatepricedto.price;
        gadgetService.save(xx);
        return ResponseEntity.ok("Quantity updated");
    }
    
    
    
    @PostMapping("/add")
    public ResponseEntity<String> addGadget( @RequestBody Gadget gadget){
      Gadget gadgetAdded=  gadgetService.save(gadget);
        return ResponseEntity.ok("gadget added: "+gadgetAdded.id);
    }

    @PostMapping("/adds")
    public ResponseEntity<String> addGadgets (@RequestBody ArrayList<Gadget> gadgets) {
        String gadgetIDList="";
        for(Gadget u:gadgets){Gadget gadgetAdded=gadgetService.save(u);

        gadgetIDList=gadgetIDList.concat("id: "+gadgetAdded.id+"\n");
        }
        return ResponseEntity.ok("Gadgets added: \n"+gadgetIDList);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody DeleteDTO deleteDTO) {
        
        Integer gadgetDeleteId=gadgetService.findIDForGivenMakeAndModel(deleteDTO.make,deleteDTO.model);
        
        gadgetService.deleteById(gadgetDeleteId);
        return ResponseEntity.ok("Deleted");
    }
    
    



}
