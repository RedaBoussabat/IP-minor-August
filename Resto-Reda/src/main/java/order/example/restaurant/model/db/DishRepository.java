package order.example.restaurant.model.db;

import order.example.restaurant.model.domain.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
