package order.example.restaurant.service;

import order.example.restaurant.domain.Client;
import order.example.restaurant.domain.Dish;
import order.example.restaurant.dto.ClientDTO;
import order.example.restaurant.dto.DishDTO;
import order.example.restaurant.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> getClients() {
        return repository.findAll();
    }

    @Override
    public void addClient(ClientDTO clientDTO) {
        Client client = new Client(clientDTO.getId(), clientDTO.getName(), clientDTO.getPhone(),clientDTO.isProcessed());
        repository.saveAndFlush(client);
    }

    @Override
    public Client getClient(long clientId) {
        return repository.findById(clientId).orElse(null);
    }

    @Override
    public List<Dish> getDishes(long clientId) {
        Client client = repository.findById(clientId).orElse(null);
        if(client == null){
            return null;
        } else {
            return client.getDishes();
        }
    }

    @Override
    public void addDish(DishDTO dishDTO, long clientId) {
        Client client = repository.findById(clientId).orElse(null);
        if(client != null){
            client.addDish(dishDTO);
            repository.saveAndFlush(client);
        }
    }


}
