package order.example.restaurant.service;

import order.example.restaurant.domain.Order;

import java.util.List;

public interface OrderServiceInt {
    List<Order> getOrders();

    void addOrder(Order order);
}
