package br.com.vibe3d.api.repositories;

import br.com.vibe3d.api.entities.Cliente;
import br.com.vibe3d.api.entities.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public Optional<Produto> findProdutoByEmail(String email) {
        return findAll().firstResultOptional();
    }
//    public boolean findByEmail(String email){
//        return find("email", email).firstResultOptional().isPresent();
//    }
//    public Optional<Cliente> findClienteByEmail(String email){
//        return find("email", email).firstResultOptional();
//    }
}