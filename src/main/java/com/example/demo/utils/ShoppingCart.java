	package com.example.demo.utils;

import java.util.ArrayList;

import java.util.List;

import com.example.demo.model.OrderItem;
import com.example.demo.model.Ticket;



public class ShoppingCart {

    private List<OrderItem> items;
    private Double totalCost;

    public ShoppingCart() {
        items = new ArrayList<>();
        totalCost = 0.0;
    }

    public void add(Ticket ticket) {
        OrderItem orderItem = findOrderFromTicket(ticket);
        if (orderItem == null) {
            orderItem = new OrderItem();
            orderItem.setTicket(ticket);
            orderItem.setItemPrice(ticket.getPrice());
            orderItem.setQuantity(0L);
            orderItem.setId(0L);
            orderItem.setTotalPrice(0.0);
            items.add(orderItem);
        }
        orderItem.setQuantity(orderItem.getQuantity() + 1);
        recalculate();
    }

    public void setQuantity(Ticket ticket, Long quantity) {
        OrderItem orderItem = findOrderFromTicket(ticket);
        if (orderItem == null) {
            return;
        }
        orderItem.setQuantity(quantity);
        recalculate();
    }

    public void remove(Ticket ticket) {
        OrderItem orderItem = findOrderFromTicket(ticket);
        if (orderItem == null) {
            return;
        }
        items.remove(orderItem);
        recalculate();
    }

    private void recalculate() {
        totalCost = 0.0;
        for(OrderItem o : items){
            o.setTotalPrice(o.getQuantity() * o.getTicket().getPrice());
            totalCost += o.getTotalPrice();
        }
    }

    private OrderItem findOrderFromTicket(Ticket ticket) {
        return items.stream().filter(o -> o.getTicket().getId().equals(ticket.getId())).findFirst().orElse(null);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
