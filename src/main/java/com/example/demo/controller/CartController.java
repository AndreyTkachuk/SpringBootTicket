package com.example.demo.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ShoppingCartService;
import com.example.demo.utils.ShoppingCart;


@Controller
@RequestMapping("/cart")
public class CartController {

    private ShoppingCartService shoppingCartService;

    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String cartPage(Model model, HttpSession session){
        ShoppingCart cart = shoppingCartService.getCurrentCart(session);
        model.addAttribute("cart", cart);
        return "cart-page";
    }
}