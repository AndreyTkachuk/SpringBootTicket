package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.utils.ShoppingCart;
import org.springframework.stereotype.Service;
import com.example.demo.model.Ticket;

import javax.servlet.http.HttpSession;

@Service
public class ShoppingCartService {

    private TicketService ticketService;

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ShoppingCart getCurrentCart(HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public void resetCart(HttpSession session){
        session.removeAttribute("cart");
    }

    public void addToCart(HttpSession session, Long ticketId){
        Ticket ticket = ticketService.getTicketById(ticketId);
        addToCart(session, ticket);
    }

    public void addToCart(HttpSession session, Ticket ticket){
        ShoppingCart cart = getCurrentCart(session);
        cart.add(ticket);
    }

    public void removeFromCart(HttpSession session, Long ticketId){
    	Ticket ticket = ticketService.getTicketById(ticketId);
        removeFromCart(session, ticket);
    }

    public void removeFromCart(HttpSession session, Ticket ticket){
        ShoppingCart cart = getCurrentCart(session);
        cart.remove(ticket);
    }

    public void setTicketCount(HttpSession session, Long ticketId, Long quantity){
        ShoppingCart cart = getCurrentCart(session);
        Ticket ticket = ticketService.getTicketById(ticketId);
        cart.setQuantity(ticket, quantity);
    }

    public void setTicketCount(HttpSession session, Ticket ticket, Long quantity){
        ShoppingCart cart = getCurrentCart(session);
        cart.setQuantity(ticket, quantity);
    }

    private double fetTotalCost(HttpSession session){
        return getCurrentCart(session).getTotalCost();
    }
}

