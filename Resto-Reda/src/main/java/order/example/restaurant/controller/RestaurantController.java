package order.example.restaurant.controller;

import order.example.restaurant.model.domain.dto.ClientOrderDTO;
import order.example.restaurant.model.domain.dto.DishDTO;
import order.example.restaurant.service.RestoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/resto")
public class RestaurantController {

    @Autowired
    private RestoServiceImp restoServiceImp;

    @GetMapping
    public String home(Model model){
        return "index";
    }


    /*
    * *
    * **OVERVIEW**
    * *
    */
    @GetMapping("/overview")
    public String orderOverview(Model model){
        model.addAttribute("orders", restoServiceImp.getAllOrders());
        return "overview";
    }

    /*
     * *
     * **DETAILS**
     * *
     */
    @GetMapping("/{id}")
    public String getOrderDetail(@PathVariable("id") String id, Model model){
        try {
            ClientOrderDTO clientOrderDTO = restoServiceImp.getOrderDTO(UUID.fromString(id));
            model.addAttribute("order",clientOrderDTO);
            model.addAttribute("dishes", clientOrderDTO.getDishList());
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            model.addAttribute("order", null);
        }
        return "details";
    }


    /*
     * *
     * **NEW ORDER**
     * *
     */

    @GetMapping("/new")
    public String newOrderPage(Model model){
        model.addAttribute("order", new ClientOrderDTO());
        return "addOrder";
    }

    @PostMapping("/newPost")
    public String newOrder(@ModelAttribute @Valid ClientOrderDTO clientOrderDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "addOrder";
        }
        restoServiceImp.addOrder(clientOrderDTO);
        return "redirect:/resto/overview";
    }


    /*
     * *
     * **NEW DISH**
     * *
     */
    @GetMapping("/{id}/dish/create")
    public String addDishPage(@PathVariable("id") String id, Model model){
        try {
            DishDTO dishDTO = new DishDTO();
            model.addAttribute("dish", dishDTO);
            ClientOrderDTO clientOrderDTO = restoServiceImp.getOrderDTO(UUID.fromString(id));
            model.addAttribute("order", clientOrderDTO);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            model.addAttribute("task", null);
        }
        return "addDish";
    }

    @PostMapping("/dish/addDish")
    public String addDish(@ModelAttribute @Valid DishDTO dishDTO, BindingResult bindingResult, @RequestParam(value = "orderId") String id){
        if (bindingResult.hasErrors()) return "addDish";
        try {
            restoServiceImp.addDish(UUID.fromString(id),dishDTO);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return "redirect:/resto/overview";
        }
        return "redirect:/resto/" + UUID.fromString(id);
    }

}
