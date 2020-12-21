package com.example.contactapp.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//TODO: Implement business logic in Service classes
//TODO: Add documentation for API
//TODO: Add unit tests

@RestController
public class ContactController {
    @Autowired
    ContactRepository repository;

    @GetMapping("/contact")
    List<Contact> contactList(){
        return repository.findAll();
    }

    @PutMapping("/contact/{id}")
    Contact updateContact(@RequestBody Contact updatedContact, @PathVariable Long id){
        //TODO: Handle Exceptions
        //TODO: Validate email address is in correct format
        Contact newContact = repository.findById(id)
                .map(contact -> {
                    contact.setFirstName(updatedContact.getFirstName());
                    contact.setLastName(updatedContact.getLastName());
                    contact.setEmail(updatedContact.getEmail());
                    return repository.save(contact);
                }).orElseThrow(() ->
                     new ContactNotFoundException(id)
                );
        return newContact;
    }

    @PostMapping("/contact")
    ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
        //TODO: Handle exceptions
        Contact c =  repository.save(contact);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/contact/{id}")
    void deleteContact( @PathVariable Long id){
        //TODO: Check if id exists and throw exception
        repository.deleteById(id);
    }
}
