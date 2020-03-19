package pt.com.arquitetura.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import pt.com.arquitetura.delivery.model.Order;
import pt.com.arquitetura.delivery.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Order save(@Validated Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public void delete(Long id) {
        Optional<Order> orderOptional = findById(id);
        if (orderOptional.isPresent()) {
            orderRepository.delete(orderOptional.get());
        }

    }
}