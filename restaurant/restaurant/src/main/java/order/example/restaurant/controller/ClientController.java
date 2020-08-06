package order.example.restaurant.controller;


import order.example.restaurant.dto.ClientDTO;
import order.example.restaurant.dto.DishDTO;
import order.example.restaurant.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/resto")
public class ClientController {
    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("clients", service.getClients());
        return "overview";
    }

    @GetMapping("overview")
    public String getClientsOverview(Model model){
        model.addAttribute("clients", service.getClients());
        return "overview";
    }

    /*
    **
    * ***
    * ****
    ADDING A CLIENT
     */
    @GetMapping("new")
    public String getTaskForm(Model model){
        model.addAttribute("clientDTO", new ClientDTO());
        return "newClient";
    }

    @PostMapping("new")
    public String PostNewClient(@ModelAttribute @Valid ClientDTO clientDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "newClient";
        } else {
            service.addClient(clientDTO);
            return "redirect:/resto";
        }
    }

    /*
    **
    * ***
    * ****
    GET A CLIENT DETAILS
     */
    @GetMapping("{clientId}")
    public String getClientDetail(@PathVariable int clientId, Model model){
        model.addAttribute("client", service.getClient(clientId));
        if(service.getClient(clientId) != null && !service.getDishes(clientId).isEmpty()){
            model.addAttribute("dishes", service.getDishes(clientId));
        }
        return "details";
    }

    /*
    **
    * ***
    * ****
    GIVE CLIENT DISHES
     */

    @GetMapping("{clientId}/dish/create")
    public String getDishForm(@PathVariable int clientId, Model model){
        model.addAttribute("client", service.getClient(clientId));
        model.addAttribute("dishDTO", new DishDTO());
        return "newDish";
    }



    @PostMapping("dish/newClient")
    public String postNewDish(@ModelAttribute @Valid DishDTO dishDTO, BindingResult bindingResult, Model model, @RequestParam(value = "clientId") Integer clientId){
        if(bindingResult.hasErrors()){
            model.addAttribute("client", service.getClient(clientId));
            return "newDish";
        }
        service.addDish(dishDTO, clientId);
        return "redirect:/resto/" + clientId;
    }

     /*
    **
    * ***
    * ****
    PROCESS
    */

     @GetMapping("/{clientId}/process")
    public String getProcessPage(@PathVariable int orderId, Model model){
         model.addAttribute("orderToProcess", service.getClient(orderId));
         return "processed";
     }

}
