package order.example.restaurant.service;

import order.example.restaurant.domain.Client;
import order.example.restaurant.domain.Dish;
import order.example.restaurant.dto.ClientDTO;
import order.example.restaurant.dto.DishDTO;

import java.util.List;

public interface ClientService {
    void addClient(ClientDTO clientDTO);

    Client getClient(long clientId);

    List<Dish> getDishes(long clientId);

    void addDish(DishDTO dishDTO, long clientId);

    List<Client> getClients();

}
