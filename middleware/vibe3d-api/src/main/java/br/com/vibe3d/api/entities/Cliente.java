package br.com.vibe3d.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente { //extends PanacheEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String email;
    //private String senha;
    //private String roles;

    /*@OneToMany
    public List<ItemDoPedido> listaDesejos;
    @OneToOne
    public Pedido pedido;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    public CarrinhoDeCompras carrinhoDeCompras;*/

    // Construtor
    public Cliente() {}

    public Cliente(String nome, String sobrenome, String endereco, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.email = email;
        /*this.listaDesejos = new ArrayList<>();
        this.pedido = new Pedido();
        this.carrinhoDeCompras = new CarrinhoDeCompras();*/
    }

    /*
    // Métodos para interação com o carrinho de compras
    public void adicionarAoCarrinho(ItemDoPedido item) {
        carrinhoDeCompras.adicionarItem(item);
    }

    public void removerDoCarrinho(ItemDoPedido item) {
        carrinhoDeCompras.removerItem(item);
    }

    public void finalizarCompra() {
        Pedido novoPedido = new Pedido();
        //novoPedido.itens(carrinhoDeCompras.itens);
        carrinhoDeCompras.finalizarPedido();
        carrinhoDeCompras.limparCarrinho();
    }*/
}