package order.example.restaurant.repository;

import order.example.restaurant.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> list;

    public OrderRepository() {
        list = new ArrayList<>();
        list.add(new Order("hank", "6545213", true));

    }

    public List<Order> getOrders() {
        return list;
    }

    public void addOrder(Order order){
        list.add(order);
    }
}
