package order.example.restaurant.controller;

import order.example.restaurant.domain.Order;
import order.example.restaurant.dto.OrderDTO;
import order.example.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService serviceInt;

    @GetMapping
    public String getOrders(Model model){
        model.addAttribute("orders", serviceInt.getOrders());
        return "orders";
    }

    @GetMapping("/create")
    public String getCreateOrderForm(Model model){
        model.addAttribute("order", new OrderDTO());
        return "form";
    }

    @PostMapping
    public String postNewOrder(@ModelAttribute @Valid Order order, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        serviceInt.addOrder(order);
        return "redirect:/order";
    }
}
