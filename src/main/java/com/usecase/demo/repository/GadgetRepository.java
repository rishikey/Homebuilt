package com.usecase.demo.repository;

import com.usecase.demo.model.Gadget;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface GadgetRepository extends CrudRepository<Gadget,Integer> {

    @Query("SELECT g FROM Gadgets WHERE g.price GreaterThanEqual low AND g.price LessThanEqual high")
    List<Gadget> findGadgetsByPriceRange(@Param(value = "low") Integer low,@Param(value = "high") Integer high);
    
}
