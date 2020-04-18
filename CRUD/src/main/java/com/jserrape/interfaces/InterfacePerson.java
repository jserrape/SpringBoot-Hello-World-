package com.jserrape.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jserrape.model.Person;

@Repository
public interface InterfacePerson extends CrudRepository<Person, Integer>{

}
