package pt.com.arquitetura.provider.repository;

import org.springframework.data.repository.CrudRepository;
import pt.com.arquitetura.provider.model.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
}