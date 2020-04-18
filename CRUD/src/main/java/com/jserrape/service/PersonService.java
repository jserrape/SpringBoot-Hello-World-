package com.jserrape.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jserrape.interfaceService.IPersonService;
import com.jserrape.interfaces.InterfacePerson;
import com.jserrape.model.Person;

@Service
public class PersonService implements IPersonService{
	
	@Autowired
	private InterfacePerson data;

	@Override
	public List<Person> listar() {
		return (List<Person>) data.findAll();
	}

	@Override
	public Optional<Person> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
