package order.example.restaurant.service;

import order.example.restaurant.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();

    void addOrder(Order order);
}
