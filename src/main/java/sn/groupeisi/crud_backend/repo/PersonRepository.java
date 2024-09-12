package sn.groupeisi.crud_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.groupeisi.crud_backend.model.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findPersonById(String id);
    Optional<Person> findPersonByEmail(String email);
    Optional<Person> deletePersonById(String id);
}
