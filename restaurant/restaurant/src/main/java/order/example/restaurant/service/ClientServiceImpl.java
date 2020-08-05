package order.example.restaurant.service;

import order.example.restaurant.domain.Client;
import order.example.restaurant.dto.ClientDTO;
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
    public List<ClientDTO> getOrders(){
        return repository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }


    @Override
    public ClientDTO addClient(ClientDTO clientDTO){
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setPhone(clientDTO.getPhone());
        client.setProcessed(clientDTO.isProcessed());
        this.repository.save(client);
        return convert(client);
    }

    private ClientDTO convert(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setProcessed(client.isProcessed());
        return clientDTO;
    }
}
