package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;



@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	 
	 
	 @RequestMapping("/contact")
		public String viewContactPage(Model model) {
			List<Contact> listContacts = contactService.listAll();
			model.addAttribute("listContacts", listContacts);
			
			
		return "contact";

}
	 
	 @RequestMapping("/contactForm")
		public String showNewContactForm(Model model) {
			Contact contact = new Contact();
			model.addAttribute("contact", contact);
			
			return "contactForm";

		}
	 
	 @RequestMapping(value ="/save_contact", method = RequestMethod.POST)
		public String saveContact(@ModelAttribute ("contact") Contact contact) {
			contactService.save_contact(contact);
			
			return "redirect:/contact";
		}
	 
	 //@RequestMapping("/edit-contact/{id}")
		//public ModelAndView showEditGameForm(@PathVariable(name = "id_contact") Long id_contact) {
			//ModelAndView nav = new ModelAndView("edit-contact");
			//Contact contact = contactService.get_contact(id_contact);
			//nav.addObject("contact", contact);
			
			//return nav;
		//}
	 
	 
	 
	 @RequestMapping("/delete/{id_contact}")
		public String deleteContact(@PathVariable (name = "id_contact") Long id_contact) {
			contactService.delete_contact(id_contact);
			
			return "redirect:/contact";

}
	 
	 
	 
}
