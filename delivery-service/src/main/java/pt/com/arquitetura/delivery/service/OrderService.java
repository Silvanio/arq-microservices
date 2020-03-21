package pt.com.arquitetura.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pt.com.arquitetura.delivery.clients.ProviderClient;
import pt.com.arquitetura.delivery.exception.ProviderNotExistException;
import pt.com.arquitetura.delivery.model.Order;
import pt.com.arquitetura.delivery.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProviderClient providerClient;

    public Order save(@Validated Order order) throws Exception {

        if (providerClient.isExist(order.getIdProvider())) {
            return orderRepository.save(order);
        }
        throw new ProviderNotExistException();
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