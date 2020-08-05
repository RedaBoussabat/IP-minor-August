package order.example.restaurant.service;

import order.example.restaurant.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private List<Order> orders;

    public OrderServiceImpl(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public List<Order> getOrders(){
        return orders;
    }

    @Override
    public void addOrder(Order order){
        orders.add(order);
    }
}
