package order.example.restaurant.controller;

import order.example.restaurant.dto.ClientDTO;
import order.example.restaurant.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public String getOrders(Model model){
        model.addAttribute("clients", service.getOrders());
        return "clients";
    }

    @GetMapping("/create")
    public String getCreateOrderForm(Model model){
        model.addAttribute("client", new ClientDTO());
        return "form";
    }

    @PostMapping
    public String postNewOrder(@ModelAttribute @Valid ClientDTO clientDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        service.addClient(clientDTO);
        return "redirect:/client";
    }
}
