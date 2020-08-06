package order.example.restaurant.repository;

import order.example.restaurant.domain.Client;
import order.example.restaurant.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
