package br.com.vibe3d.api.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Entity
public class Produto extends PanacheEntity {
    private static final Log log = LogFactory.getLog(Produto.class);
    public String nome;
    @Column(name = "titulosite")
    public String tituloSite;
    public String descricao;
    public double preco;
    public int desconto;
    @Column(name = "arquivomodelo3d")
    public String arquivoModelo3D;
    public String imagens;
    public String acabamentos;

    public static Optional<Produto> findProdutoById(Long id) {
        return find("id", id).firstResultOptional();
    }

    public static Optional<Produto> findProdutoByNome(String nome) {
        return find("nome", nome).firstResultOptional();
    }

    @Transactional
    public static Optional<Produto> update(Produto produto) {
        Optional<Produto> produtoOrigem = findProdutoById(produto.id);
        if (produtoOrigem.isPresent()) {
            produtoOrigem.get().arquivoModelo3D = produto.arquivoModelo3D;
            produtoOrigem.get().preco = produto.preco;
            produtoOrigem.get().desconto = produto.desconto;
            produtoOrigem.get().imagens = produto.imagens;
            produtoOrigem.get().tituloSite = produto.tituloSite;
            produtoOrigem.get().nome = produto.nome;
            produtoOrigem.get().tituloSite = produto.tituloSite;
            produtoOrigem.get().acabamentos = produto.acabamentos;
            // atualizar produto
            produtoOrigem.get().persistAndFlush();
        }
        return produtoOrigem;
    }
}