package com.example.contactapp.contacts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAll();
    List<Contact> findByEmail(String email);
}
