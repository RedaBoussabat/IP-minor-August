package order.example.restaurant.dto;

import order.example.restaurant.domain.Client;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DishDTO {
    private Long id;

    @NotEmpty(message = "Dishnaam mag niet leeg zijn")
    private String dish;
    private String description;

    private Client client;

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
