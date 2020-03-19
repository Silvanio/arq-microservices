package pt.com.arquitetura.delivery.repository;

import org.springframework.data.repository.CrudRepository;
import pt.com.arquitetura.delivery.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}