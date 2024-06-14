package com.usecase.demo.repository;

import com.usecase.demo.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget,Integer> {

//    @Query("SELECT g FROM Gadgets g WHERE g.price >= ?1 AND g.price <= ?2")
   public List<Gadget> findByPriceBetween(int low,int high);
    
//    @Query("SELECT g FROM Gadgets g WHERE g.make=:make and g.model=model")
    public Integer findIdByMakeAndModel(@Param(value="make") String make,@Param(value="model") String model);

}
