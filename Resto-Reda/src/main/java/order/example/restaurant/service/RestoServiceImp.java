package order.example.restaurant.service;

import order.example.restaurant.model.db.DishRepository;
import order.example.restaurant.model.db.OrderRepository;
import order.example.restaurant.model.domain.dto.DishDTO;
import order.example.restaurant.model.domain.dto.ClientOrderDTO;
import order.example.restaurant.model.domain.entity.Dish;
import order.example.restaurant.model.domain.entity.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestoServiceImp implements RestoService {

    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;


    @Autowired
    public RestoServiceImp(DishRepository dishRepository, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
    }


    @Override
    public List<ClientOrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(ClientOrder::createDTO).collect(Collectors.toList());
    }

    @Override
    public void addOrder(ClientOrderDTO clientOrderDTO) {
        orderRepository.save(clientOrderDTO.createOrder());
    }

    @Override
    public ClientOrderDTO getOrderDTO(UUID uuid) {
        if (orderRepository.findById(uuid).isPresent()){
            ClientOrder clientOrder = orderRepository.findById(uuid).get();
            return clientOrder.createDTO();
        } else {
            return null;
        }
    }


    @Override
    public void addDish(UUID uuid, DishDTO dishDTO) {
        Dish dish = dishDTO.createDish();
        ClientOrder clientOrder = getOrder(uuid);
        clientOrder.addDish(dish);
        dishRepository.save(dish);
        orderRepository.save(clientOrder);
    }

    private ClientOrder getOrder(UUID uuid) {
        if (orderRepository.findById(uuid).isPresent()){
            return orderRepository.findById(uuid).get();
        } else {
            throw new IllegalArgumentException("UUID not found");
        }
    }


}
