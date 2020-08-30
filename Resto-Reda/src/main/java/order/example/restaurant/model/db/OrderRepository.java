package order.example.restaurant.model.db;

import order.example.restaurant.model.domain.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<ClientOrder, UUID> {
}
