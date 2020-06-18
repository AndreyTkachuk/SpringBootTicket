package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Ticket;


@Repository
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {
    Ticket findOneByTitle(String title); 
    
    
}


