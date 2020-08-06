package order.example.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Dish {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Dishnaam mag niet leeg zijn")
    private String dish;
    private String description;

   @ManyToOne
   private Client client;

    public Dish() {
    }

    public Dish(String dish, String description) {
        setDish(dish);
        setDescription(description);
    }

    public String getDish() {
        return dish;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
