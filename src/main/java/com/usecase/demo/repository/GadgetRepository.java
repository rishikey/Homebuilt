package com.usecase.demo.repository;

import com.usecase.demo.model.gadget;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface GadgetRepository extends CrudRepository<gadget,String> {

}
