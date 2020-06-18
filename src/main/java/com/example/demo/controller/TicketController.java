package com.example.demo.controller;


import java.util.Optional;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.OrderService;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.model.Order;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import com.example.demo.specification.TicketSpecs;


@Controller
public class TicketController {
	
    private static final int INITIAL_PAGE = 0;
    private static final int PAGE_SIZE = 10;
	
    
	private TicketService ticketService;
    private OrderService orderService;
    private ShoppingCartService shoppingCartService;
	
	
	 @Autowired
	    public void setTicketService(TicketService ticketService) {
	        this.ticketService = ticketService;
	    }
	 
	 @Autowired
	    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
	        this.shoppingCartService = shoppingCartService;
	    }
	    
	    @Autowired
	    public void setOrderService(OrderService orderService) {
	        this.orderService = orderService;
	    }
	
	 @RequestMapping("/ticket")
	public String showTicketPage(Model model,
			@RequestParam(value = "page") Optional<Integer> page,
	        @RequestParam(value = "word", required = false) String word,
	        @RequestParam(value = "min", required = false) Double min,
	        @RequestParam(value = "max", required = false) Double max) {
		
		final int currentPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Specification<Ticket> spec = Specification.where(null);
        StringBuilder filters = new StringBuilder();
        if (word != null) {
            spec = spec.and(TicketSpecs.titleContains(word));
            filters.append("&word=" + word);
        }
        if (min != null) {
            spec = spec.and(TicketSpecs.priceGreaterThanOrEq(min));
            filters.append("&min=" + min);
        }
        if (max != null) {
            spec = spec.and(TicketSpecs.priceLesserThanOrEq(max));
            filters.append("&max=" + max);
        }

        Page<Ticket> tickets = ticketService.getTicketsWithPagingAndFiltering(currentPage, PAGE_SIZE, spec);

        model.addAttribute("tickets", tickets.getContent());
        model.addAttribute("page", currentPage);
        model.addAttribute("totalPage", tickets.getTotalPages());

        model.addAttribute("filters", filters.toString());

        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("word", word);
		
		
		return"ticket";
		
	}
	 
	 
	 
	 @RequestMapping("/new_ticket")
	 public String newTicketForm(Model model) {
		 Ticket ticket = new Ticket();
		 model.addAttribute("ticket", ticket);
		 
		 return "new_ticket";
	 }
	 
	 
	 @RequestMapping(value ="/save", method = RequestMethod.POST)
	 public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		 ticketService.save(ticket);
		 
		 return "redirect:/ticket";
		 
	 }


	 @GetMapping("/cart/add/{id}")
	 public String addTicketToCart(
	         Model model,
	         @PathVariable(name = "id") Long id,
	         HttpServletRequest httpServletRequest
	 ) {
	     shoppingCartService.addToCart(httpServletRequest.getSession(), id);
	     String referer = httpServletRequest.getHeader("referer");
	     return "redirect:" + referer;
	     
	 }

	 @GetMapping("/order/fill")
	 public String orderFill(
	         Model model,
	         HttpServletRequest httpServletRequest
	         ) {
	    
	     Order order = orderService.makeOrder(shoppingCartService.getCurrentCart(httpServletRequest.getSession()));
	     
	     model.addAttribute("order", order);
	     
	     return "order-filler";
	 }
	 @PostMapping("order/confirm")
	 public String orderConfirm(
	         Model model,
	         HttpServletRequest httpServletRequest,
	         @ModelAttribute(name = "order") Order orderFromFrontend) {
	     
	     Order order = orderService.makeOrder(shoppingCartService.getCurrentCart(httpServletRequest.getSession()));
	     order = orderService.saveOrder(order);
	     model.addAttribute("order", order);
	     return "order-filler";
	 }

	 @GetMapping("/order/result/{id}")
	 public String orderConfirm(
	         Model model,
	         @PathVariable(name = "id") Long id) {

	     Order confirmedOrder = orderService.findById(id);
	     
	     model.addAttribute("order", confirmedOrder);
	     return "order-result";
	 }

	 }
