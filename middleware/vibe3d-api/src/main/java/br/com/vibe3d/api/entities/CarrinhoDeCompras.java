package br.com.vibe3d.api.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class CarrinhoDeCompras extends PanacheEntity {

    private static final Log log = LogFactory.getLog(CarrinhoDeCompras.class);

    public Long idCliente;
    public String itensCarrinho;

    public CarrinhoDeCompras() {}

    public CarrinhoDeCompras(Long id, String itens) {
        this.idCliente = id;
        this.itensCarrinho = itens;
    }

    public static Optional<CarrinhoDeCompras> findByClienteId(Long clienteId) {
        return find("idCliente", clienteId).firstResultOptional();
    }

    public boolean adicionarItem(Long item) {
        if (!this.itensCarrinho.contains(item.toString())){
            this.itensCarrinho = this.itensCarrinho + (this.itensCarrinho.isEmpty() ?"":",") + item.toString();
            // Organizar em sequência (Sorted)
            /*String sortedString =
                    Arrays.stream(this.itensCarrinho.split(","))      // separar pelas vírgulas ','
                            .map(Integer::valueOf)                    // converter as strings para ints
                            //.sorted()                               // sequenciar
                            .map(String::valueOf)                     // converter de volta para string
                            .collect(Collectors.joining(","));        // saída: 1,2,4,5,8,9,15,...
            if (log.isDebugEnabled()) log.debug("Carrinho de compras: " + sortedString);*/
            this.persistAndFlush();
            return true;
        }else{
            return false;
        }
    }

    public boolean removerItem(Long idCliente, Long item) {
        this.itensCarrinho="";
        this.persistAndFlush();
        return true;
    }
/*
    public void limparCarrinho() {
        //this.itensCarrinho = new ArrayList<>();
    }

    public void finalizarPedido() {
        // ToDo
    }
    */
}