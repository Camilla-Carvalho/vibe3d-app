package br.com.vibe3d.api.repositories;

import br.com.vibe3d.api.entities.Cliente;
import br.com.vibe3d.api.entities.HomePage;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    public boolean findByEmail(String email){
        return find("email", email).firstResultOptional().isPresent();
    }
    public Optional<Cliente> findClienteByEmail(String email){
        return find("email", email).firstResultOptional();
    }
}