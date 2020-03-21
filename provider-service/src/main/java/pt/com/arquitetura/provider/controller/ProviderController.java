package pt.com.arquitetura.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.arquitetura.provider.model.Provider;
import pt.com.arquitetura.provider.service.ProviderService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/providers", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProviderController {

    @Autowired
    private ProviderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Provider> save(@RequestBody Provider provider) {
        return ResponseEntity.ok(orderService.save(provider));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Provider> findById(@PathVariable("id") Long id) {
        Optional<Provider> orderOptional = orderService.findById(id);
        if (orderOptional.isPresent()) {
            return ResponseEntity.ok(orderOptional.get());
        }
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "exist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isExist(@PathVariable("id") Long id) {
        Optional<Provider> orderOptional = orderService.findById(id);
        if (orderOptional.isPresent()) {
            return ResponseEntity.ok(Boolean.TRUE);
        }
        return ResponseEntity.ok(Boolean.FALSE);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Provider>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}