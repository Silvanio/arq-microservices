package pt.com.arquitetura.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pt.com.arquitetura.provider.model.Provider;
import pt.com.arquitetura.provider.repository.ProviderRepository;

import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public Provider save(@Validated Provider order) {
        return providerRepository.save(order);
    }

    public Optional<Provider> findById(Long id) {
        return providerRepository.findById(id);
    }

    public Iterable<Provider> findAll() {
        return providerRepository.findAll();
    }

    public void delete(Long id) {
        Optional<Provider> optional = findById(id);
        if (optional.isPresent()) {
            providerRepository.delete(optional.get());
        }

    }
}