package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Contact;



@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{

}
