package order.example.restaurant.model.domain.entity;

import order.example.restaurant.model.domain.dto.DishDTO;
import order.example.restaurant.model.domain.dto.ClientOrderDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
public class ClientOrder {

    @Id
    private UUID uuid;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phone;

    private boolean processed;

    @OneToMany
            //(mappedBy = "order")
    private List<Dish> dishList;

    public ClientOrder(){
        setRandomUuid();
        if (dishList == null) dishList = new ArrayList<>();
        processed = false;

    }

    public ClientOrder(String name, String phone){
        setRandomUuid();
        setName(name);
        setPhone(phone);
        processed = false;
        if (dishList == null) dishList = new ArrayList<>();
    }

    public ClientOrder(String name, String phone, UUID uuid){
        setName(name);
        setPhone(phone);
        setUuid(uuid);
        processed = false;

        if (dishList == null) dishList = new ArrayList<>();
    }

    public List<DishDTO> getDishes(){
        return dishList.stream().map(dish -> {
            DishDTO dishDTO = new DishDTO();
            dishDTO.setId(dish.getId());
            dishDTO.setDishName(dish.getDishName());
            dishDTO.setDishDescription(dish.getDishDescription());
            return dishDTO;
        }
        ).collect(Collectors.toList());
    }

    public void addDish(Dish dish){
        dishList.add(dish);
    }

    private void setRandomUuid(){
        this.uuid = UUID.randomUUID();
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

    public void process() {
        processed = true;
    }


    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public ClientOrderDTO createDTO(){
        ClientOrderDTO clientOrderDTO = new ClientOrderDTO();
        clientOrderDTO.setName(name);
        clientOrderDTO.setPhone(phone);
        clientOrderDTO.setUuid(uuid);
        clientOrderDTO.setDishList(getDishes());
        return clientOrderDTO;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
