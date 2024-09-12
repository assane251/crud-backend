package sn.groupeisi.crud_backend.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.groupeisi.crud_backend.model.Person;
import sn.groupeisi.crud_backend.repo.PersonRepository;
import sn.groupeisi.crud_backend.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {

        Optional<Person> existingperson = personRepository.findPersonByEmail(person.getEmail());

        if (existingperson.isPresent()) {
            throw new RuntimeException(person.getEmail() + " already exists!");
        }

        person.setId(UUID.randomUUID().toString());
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {

        Optional<Person> existingperson = personRepository.findPersonById(String.valueOf(Integer.parseInt(person.getId())));

        if (!existingperson.isPresent()) {
            throw new RuntimeException("Person not found.");
        }

        return personRepository.save(person);
    }

    @Override
    public String deletePerson(String id) {

        Optional<Person> existingPerson = personRepository.findPersonById(id);

        if (!existingPerson.isPresent()) {
            throw new RuntimeException("Person not found");
        }

        personRepository.deletePersonById(id);

        return "Person deleted successfully";
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
