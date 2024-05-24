package com.usecase.demo.repository;

import com.usecase.demo.model.Gadget;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface GadgetRepository extends CrudRepository<Gadget,String> {

}
