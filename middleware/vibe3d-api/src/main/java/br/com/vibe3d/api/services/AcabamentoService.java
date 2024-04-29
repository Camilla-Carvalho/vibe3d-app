package br.com.vibe3d.api.services;

import br.com.vibe3d.api.entities.Acabamento;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AcabamentoService {

    Acabamento acabamento;

    public List<Acabamento> listarAcabamentos() {
        return Acabamento.findAll(Sort.ascending("id")).list();
    }

    public Optional<Acabamento> obterAcabamentoPorId(Long id) {
        return Acabamento.findByIdOptional(id);
    }

    @Transactional
    public Acabamento adicionarNovoAcabamento(Acabamento acabamento) {
        Acabamento.persist(acabamento);
        return acabamento;
    }

    @Transactional
    public Acabamento atualizarAcabamento(Acabamento acabamento) {
        return Acabamento.getEntityManager().merge(acabamento);
    }

    @Transactional
    public boolean removerAcabamento(Long id) {
        Optional<Acabamento> acabamento = Acabamento.findByIdOptional(id);
        if (acabamento.isPresent()) {
            Acabamento.deleteById(id);
            return true;
        }
        return false;
    }
}
