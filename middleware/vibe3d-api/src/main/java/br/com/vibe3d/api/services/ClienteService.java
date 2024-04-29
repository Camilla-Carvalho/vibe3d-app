package br.com.vibe3d.api.services;

import br.com.vibe3d.api.entities.Cliente;
import br.com.vibe3d.api.repositories.ClienteRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll(Sort.by("id")).list();
    }

    public Optional<Cliente> obterClientePorEmail(String email) {
        return clienteRepository.findClienteByEmail(email);
    }

    @Transactional
    public Cliente criarCliente(Cliente cliente) {
        if(!clienteRepository.findByEmail(cliente.getEmail()))
            clienteRepository.persist(cliente);
        else
            return null;
        return cliente;
    }

    @Transactional
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.getEntityManager().merge(cliente);
    }

    @Transactional
    public boolean removerCliente(String email) {
        Optional<Cliente> cliente = clienteRepository.findClienteByEmail(email);
        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
            return true;
        }
        return false;
    }
}