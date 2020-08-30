package order.example.restaurant.model.domain.dto;

import order.example.restaurant.model.domain.entity.Dish;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class DishDTO {

    private int id;

    @NotEmpty
    private String dishName;

    private String dishDescription;

    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDishName(String dishName) {
        if (dishName == null || dishName.trim().isEmpty()) throw new IllegalArgumentException("Dishname is empty");
        this.dishName = dishName;
    }

    public void setDishDescription(String dishDescription) {
        if (dishDescription == null || dishDescription.trim().isEmpty()) throw new IllegalArgumentException("Dishname is empty");
        this.dishDescription = dishDescription;
    }

    public Dish createDish(){
        return new Dish(id, dishName, dishDescription);
    }

}
