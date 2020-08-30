package order.example.restaurant.model.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Dish {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String dishName;

    private String dishDescription;

    //@ManyToOne
    //private ClientOrder order;

    public Dish(int id, String dishName, String dishDescription) {
        setId(id);
        setDishName(dishName);
        setDishDescription(dishDescription);
    }

    public Dish(String dishName, String dishDescription) {
        setDishName(dishName);
        setDishDescription(dishDescription);
    }

    public Dish() {

    }

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
}
