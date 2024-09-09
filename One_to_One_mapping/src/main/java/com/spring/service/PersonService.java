package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Entity.Person;
import com.spring.Entity.Passport;
import com.spring.repo.PersonRepo;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    // Get all persons
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    // Get person by ID
    public Person getPersonById(Long id) {
        return personRepo.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    // Add a new person
    public Person addPerson(Person person) {
        // Ensure bidirectional relationship is maintained
        if (person.getPassport() != null) {
            person.getPassport().setPerson(person);  // Set the person reference in passport
        }
        return personRepo.save(person);
    }

    // Update an existing person
    public Person updatePerson(Long id, Person personDetails) {
        Person existingPerson = personRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        // Update the person's details
        existingPerson.setName(personDetails.getName());

        // Update passport details if present
        if (personDetails.getPassport() != null) {
            Passport existingPassport = existingPerson.getPassport();
            existingPassport.setPassportNumber(personDetails.getPassport().getPassportNumber());
            existingPassport.setPerson(existingPerson);  // Set the reverse relationship
            existingPerson.setPassport(existingPassport);
        }

        return personRepo.save(existingPerson);
    }

    // Delete person by ID
    public void deleteById(Long id) {
        personRepo.deleteById(id);
    }
}
