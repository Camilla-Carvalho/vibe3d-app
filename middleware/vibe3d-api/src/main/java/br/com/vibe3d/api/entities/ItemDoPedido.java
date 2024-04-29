package br.com.vibe3d.api.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
public class ItemDoPedido extends PanacheEntity {
    public int quantidade;
    public Long idProduto;
    public Long idCliente;
    public Long idCarrinhoDeCompras;

    public ItemDoPedido(Long idProduto, Long idCliente, Long idCarrinhoDeCompras, int quantidade) {
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.idCarrinhoDeCompras = idCarrinhoDeCompras;
        this.quantidade = quantidade;
    }

    public ItemDoPedido() {}
}