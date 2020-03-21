package pt.com.arquitetura.delivery.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.arquitetura.delivery.model.Order;
import pt.com.arquitetura.delivery.service.OrderService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "API - Gerenciamento de Ordens", description = "Operações para Ordens")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Para Salvar Ordens", response = Order.class)
    public ResponseEntity<Order> save(@RequestBody Order order) throws Exception {
        return ResponseEntity.ok(orderService.save(order));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Obter Ordens pelo ID", response = Order.class)
    public ResponseEntity<Order> findById(@PathVariable("id") Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (orderOptional.isPresent()) {
            return ResponseEntity.ok(orderOptional.get());
        }
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ApiOperation(value = "Listar todas as ordens", response = Iterable.class)
    public ResponseEntity<Iterable<Order>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Remover uma ordem pelo ID")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}