package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;



@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	
	
	public List<Contact> listAll(){
		
		return(List<Contact>)contactRepository.findAll();
	}
	
	
	
	public void save_contact(Contact contact) {
		
		contactRepository.save(contact);
	}
	
	
	public Contact get_contact(long id) {
		Optional <Contact> result = contactRepository.findById(id);
		
		return result.get();
	}
	
	
     public void delete_contact( Long id) {
		
		contactRepository.deleteById(id);
	}

}
