package br.com.vibe3d.api.entities;

import br.com.vibe3d.api.entities.Cliente;
import br.com.vibe3d.api.entities.ItemDoPedido;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido extends PanacheEntity {
    //@Id @GeneratedValue
    //public long id;
    @OneToOne
    public Cliente cliente;
    @OneToMany
    public List<ItemDoPedido> itens;
    public double total;
    public String status;

    public Pedido() {}

    // Construtor
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0.0;
        this.status = "Pendente"; // Definindo status inicial como pendente
    }
}