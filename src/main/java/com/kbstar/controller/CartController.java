package com.kbstar.controller;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping("")
    public String main(Model model, String id, HttpSession httpSession) throws Exception {
        if (httpSession.getAttribute("logincust") == null) {
            model.addAttribute("center", "login");
            return "index";
        }
        List<Cart> list =null;
        try {
            list = cartService.getid(id);
        } catch (Exception e) {
            throw new Exception("시스템 장애");
        }
        model.addAttribute("list", list);
        model.addAttribute("center", "cart");
        return "index";
    }

    @RequestMapping("/delete")
    public String delete(Cart cart) throws Exception {
        cartService.remove(cart.getId());
        return "redirect:/cart?id=" + cart.getCust_id();
    }

    @RequestMapping("/update")
    public String update(Cart cart) throws Exception {
        cartService.modify(cart);
        return "redirect:/cart?id=" + cart.getCust_id();
    }
}
