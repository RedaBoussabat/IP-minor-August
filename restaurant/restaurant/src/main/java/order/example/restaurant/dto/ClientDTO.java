package order.example.restaurant.dto;

import order.example.restaurant.domain.Dish;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class ClientDTO {

    private Long id;
    @NotEmpty(message = "Naam mag niet leeg zijn")
    private String name;
    @NotEmpty(message = "Nummer mag niet leeg zijn")
    private String phone;
    private boolean processed;

    private List<Dish> dishes;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(@Valid DishDTO dishDTO){
        Dish dish = new Dish(dishDTO.getDish(), dishDTO.getDescription());
        dishes.add(dish);
    }
}
