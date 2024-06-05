package com.usecase.demo.service;

import com.usecase.demo.Exceptions.idNotFoundException;
import com.usecase.demo.model.Gadget;
import com.usecase.demo.repository.GadgetRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    private final GadgetRepository gadgetRepository;

    
    public GadgetService(GadgetRepository gadgetRepository){
        this.gadgetRepository= gadgetRepository;
    }

    public Gadget save(Gadget gadget ){
       return gadgetRepository.save(gadget);
    }

    public Gadget findById(Integer id){

        return gadgetRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));
    }

    public List<Gadget> findAll(){
        return (List<Gadget>) gadgetRepository.findAll();
    }

    public Optional<Gadget> findById(int id){
        Optional<Gadget> ans=null;
        try{
            if(gadgetRepository.existsById(id))ans= gadgetRepository.findById(id);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return ans;
    }

    public List<Gadget> findGadgetsByPriceRange(double lo,double hi){
      return   gadgetRepository.findGadgetsByPriceRange(lo,hi);
    }

    public int findIDForGivenMakeAndModel(String make,String model){
       return  gadgetRepository.findIDForGivenMakeAndModel( make, model);
    }

    public void deleteById(int id){
       try {
           boolean ifExists=gadgetRepository.existsById(id);
           if(ifExists)gadgetRepository.deleteById(id);
           else throw new idNotFoundException("ID:{} not found"+id);

       }
       catch (idNotFoundException e){
           System.out.println(e.getMessage());
       }
    }

}
