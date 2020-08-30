package order.example.restaurant.service;

import order.example.restaurant.model.domain.dto.DishDTO;
import order.example.restaurant.model.domain.dto.ClientOrderDTO;

import java.util.List;
import java.util.UUID;

public interface RestoService {

    List<ClientOrderDTO> getAllOrders();

    void addOrder(ClientOrderDTO clientOrderDTO);

    ClientOrderDTO getOrderDTO(UUID uuid);

    void addDish(UUID uuid, DishDTO dishDTO);
}
