package order.example.restaurant.model.domain.dto;

import order.example.restaurant.model.domain.entity.ClientOrder;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientOrderDTO {

    private UUID uuid;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phone;

    private boolean processed;

    private List<DishDTO> dishList;

    public ClientOrderDTO() {
        this.dishList = new ArrayList<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Description cannot be empty");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) throw new IllegalArgumentException("Description cannot be empty");
        this.phone = phone;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public List<DishDTO> getDishList() {
        return new ArrayList<>(dishList);
    }

    public void setDishList(List<DishDTO> dishList) {
        this.dishList = dishList;
    }

    public ClientOrder createOrder(){
        return new ClientOrder(name, phone, UUID.randomUUID());
    }
}
