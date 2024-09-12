package sn.groupeisi.crud_backend.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.crud_backend.model.Person;
import sn.groupeisi.crud_backend.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/all-person")
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> personList = personService.getAllPerson();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @PostMapping("/add-person")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        try {
            Person createdPerson = personService.addPerson(person);
            return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update-person/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable String id, @RequestBody Person person) {
        person.setId(id);

        try {
            String result = String.valueOf(personService.updatePerson(person));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable String id) {
        try {
            String result = personService.deletePerson(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
