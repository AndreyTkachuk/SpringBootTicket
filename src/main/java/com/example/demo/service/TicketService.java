package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;



@Service
public class TicketService {
	
	
	private TicketRepository ticketRepository;
	
	
	 @Autowired
	    public void setProductRepository(TicketRepository ticketRepository) {
	        this.ticketRepository = ticketRepository;
	    }
	
	
	public  List<Ticket>getAllTickets(){
		return(List<Ticket>)ticketRepository.findAll();
	}
	
	 public List<Ticket> getAllTicketsWithFilter(Specification<Ticket> ticketSpecification) {
	        return ticketRepository.findAll(ticketSpecification);
	    }

	    public Ticket getTicketById(Long id) {
	        return ticketRepository.findById(id).orElse(null);
	    }

	    public Page<Ticket> getAllTicketsByPage(int pageNumber, int pageSize) {
	        return ticketRepository.findAll(PageRequest.of(pageNumber, pageSize));
	    }
	
	public Page<Ticket> getTicketsWithPagingAndFiltering(
            int pageNumber,
            int pageSize,
            Specification<Ticket> ticketSpecification) {
        return ticketRepository.findAll(ticketSpecification, PageRequest.of(pageNumber, pageSize));
    }
	
	public boolean isTicketWithTitleExists(String ticketTitle){
        return ticketRepository.findOneByTitle(ticketTitle) != null;
    }

    public void save(Ticket ticket){
        ticketRepository.save(ticket);
    }
    
    
    public Ticket get(long id) {
    	Optional<Ticket> result = ticketRepository.findById(id);
    		
    	return result.get();
    }


	

}
