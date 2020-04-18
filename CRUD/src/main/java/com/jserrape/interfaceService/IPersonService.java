package com.jserrape.interfaceService;

import java.util.List;
import java.util.Optional;

import com.jserrape.model.Person;


public interface IPersonService {

	public List<Person> listar();

	public Optional<Person> listarId(int id);

	public int save(Person p);

	public void delete(int id);
}
