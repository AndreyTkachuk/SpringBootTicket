package com.example.demo.model;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="contact")
public class Contact implements Serializable {
	private static final long serialVersionUID = -1190198026206001434L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_contact;
	
	
	@Column(name="name_contact")
	private String name_contact;
	
	@Column(name="email_contact")
	private String email_contact;
	
	@Column(name="subject_contact")
	private String subject_contact;
	
	@Column(name="message_contact")
	private String message_contact;
	
	
	
	public Contact() {
		
	}
	
	
	public String getName_contact() {
		return name_contact;
	}
	public void setName_contact(String name_contact) {
		this.name_contact = name_contact;
	}
	public Long getId_contact() {
		return id_contact;
	}
	public void setId_contact(Long id_contact) {
		this.id_contact = id_contact;
	}
	public String getEmail_contact() {
		return email_contact;
	}
	public void setEmail_contact(String email_contact) {
		this.email_contact = email_contact;
	}
	public String getSubject_contact() {
		return subject_contact;
	}
	public void setSubject_contact(String subject_contact) {
		this.subject_contact = subject_contact;
	}
	public String getMessage_contact() {
		return message_contact;
	}
	public void setMessage_contact(String message_contact) {
		this.message_contact = message_contact;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email_contact == null) ? 0 : email_contact.hashCode());
		result = prime * result + ((id_contact == null) ? 0 : id_contact.hashCode());
		result = prime * result + ((message_contact == null) ? 0 : message_contact.hashCode());
		result = prime * result + ((name_contact == null) ? 0 : name_contact.hashCode());
		result = prime * result + ((subject_contact == null) ? 0 : subject_contact.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (email_contact == null) {
			if (other.email_contact != null)
				return false;
		} else if (!email_contact.equals(other.email_contact))
			return false;
		if (id_contact == null) {
			if (other.id_contact != null)
				return false;
		} else if (!id_contact.equals(other.id_contact))
			return false;
		if (message_contact == null) {
			if (other.message_contact != null)
				return false;
		} else if (!message_contact.equals(other.message_contact))
			return false;
		if (name_contact == null) {
			if (other.name_contact != null)
				return false;
		} else if (!name_contact.equals(other.name_contact))
			return false;
		if (subject_contact == null) {
			if (other.subject_contact != null)
				return false;
		} else if (!subject_contact.equals(other.subject_contact))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Contact [id_contact=" + id_contact + ", name_contact=" + name_contact + ", email_contact="
				+ email_contact + ", subject_contact=" + subject_contact + ", message_contact=" + message_contact + "]";
	}




}
