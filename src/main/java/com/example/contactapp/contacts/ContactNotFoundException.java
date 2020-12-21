package com.example.contactapp.contacts;

public class ContactNotFoundException extends RuntimeException {
    ContactNotFoundException(Long id) {
        super("Contact not found: " + id);
    }
}
