package sn.groupeisi.crud_backend.service;

import sn.groupeisi.crud_backend.model.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    Person updatePerson(Person person);
    String deletePerson(String id);
    List<Person> getAllPerson();
}
