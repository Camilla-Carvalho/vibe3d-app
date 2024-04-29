package br.com.vibe3d.api.services;

import br.com.vibe3d.api.entities.Acabamento;
import br.com.vibe3d.api.entities.Produto;
import br.com.vibe3d.api.repositories.ProdutoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProdutoService {

    public List<Produto> listarProdutos() {
        return Produto.listAll(Sort.ascending("nome"));
    }

    public Optional<Produto> obterProdutoPorNome(String nome) {
        return Produto.findProdutoByNome(nome);
    }

    @Transactional
    public Produto criarProduto(Produto produto) {
        if(Produto.findProdutoByNome(produto.nome).isPresent()) {
            return null;
        } else {
            produto.persistAndFlush();
        }
        return produto;
    }

    @Transactional
    public Optional<Produto> atualizarProduto(Produto produto) {
        return Produto.update(produto);
    }

    @Transactional
    public boolean removerProduto(Long id) {
        Optional<Produto> produto = Produto.findProdutoById(id);
        if (produto.isPresent()) {
            produto.get().delete();
            return true;
        }
        return false;
    }

    public List<Acabamento> obterAcabamentosByIdProduto(Long id) {
        List<Long> listaIds = new ArrayList<>();
        Optional<Produto> produto = Produto.findProdutoById(id);
        if (produto.isPresent()) {
            if (produto.get().acabamentos == null) {
                return new ArrayList<>();
            }
            else {
                for (String idStr : produto.get().acabamentos.split(","))
                    listaIds.add(Long.valueOf(idStr));
                return Acabamento.findByListId(listaIds);
            }
        }
        return new ArrayList<>();
    }
}