package com.example.demo.specification;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Ticket;

public class TicketSpecs {
	
	public static Specification<Ticket> titleContains(String word) {
        return (Specification<Ticket>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Ticket> priceGreaterThanOrEq(double value) {
        return (Specification<Ticket>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), value);
    }

    public static Specification<Ticket> priceLesserThanOrEq(double value) {
        return (Specification<Ticket>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), value);
    }

}


