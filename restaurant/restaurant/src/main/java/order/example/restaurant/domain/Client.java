package order.example.restaurant.domain;


import order.example.restaurant.dto.DishDTO;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @NotEmpty(message = "Naam mag niet leeg zijn")
    private String name;
    @NotNull
    @NotEmpty(message = "Nummer mag niet leeg zijn")
    private String phone;
    private boolean processed;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Dish> dishes;

    public Client() {
    }

    public Client(Long id, String name, String phone, boolean processed){
        setId(id);
        setName(name);
        setPhone(phone);
        this.processed = false;
        dishes = new ArrayList<>();
    }

    public Client(Long id, String name, String phone, boolean processed, List<Dish> dishes){
        setId(id);
        setName(name);
        setPhone(phone);
        this.processed = false;
        setDishes(dishes);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isProcessed(){
        return processed;
    }

    public void setProcessed() {
        this.processed = true;
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
