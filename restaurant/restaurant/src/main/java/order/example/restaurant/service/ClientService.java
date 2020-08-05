package order.example.restaurant.service;

import order.example.restaurant.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getOrders();

    ClientDTO addClient(ClientDTO order);

}
