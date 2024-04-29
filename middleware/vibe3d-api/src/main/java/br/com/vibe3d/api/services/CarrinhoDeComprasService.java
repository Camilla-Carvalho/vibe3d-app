package br.com.vibe3d.api.services;

import br.com.vibe3d.api.entities.CarrinhoDeCompras;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import net.bytebuddy.dynamic.DynamicType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CarrinhoDeComprasService {

    private static final Log log = LogFactory.getLog(CarrinhoDeComprasService.class);

    @Transactional
    public boolean adicionarItemAoCarrinho(Long idCliente, Long idItem) {
        // Lógica para adicionar o produto com o ID especificado ao carrinho de compras
        // Retornar true se o item for adicionado com sucesso, caso contrário, retorne false
        Optional<CarrinhoDeCompras> carrinho = CarrinhoDeCompras.findByClienteId(idCliente);
        if (carrinho.isPresent()) {
            carrinho.get().adicionarItem(idItem);
            return true;
        }else{
            new CarrinhoDeCompras(idCliente, idItem.toString()).persistAndFlush();
            return false;
        }
    }

    @Transactional
    public boolean removerItemDoCarrinho(Long idCliente, Long idItem) {
        // Lógica para remover o produto com o ID especificado do carrinho de compras
        // Retorne true se o item for removido com sucesso, caso contrário, retorne false
        Optional<CarrinhoDeCompras> carrinho = CarrinhoDeCompras.findByClienteId(idCliente);
        if (carrinho.isPresent()) {
            if (log.isDebugEnabled()) log.info("### itens: "+carrinho.get().itensCarrinho);
            String itens = carrinho.get().itensCarrinho;
            itens = itens.replace(","+idItem.toString(), "");
            itens = itens.replace(idItem.toString(), "");
            if (log.isDebugEnabled()) log.info("### itens-replaced: "+carrinho.get().itensCarrinho);
            carrinho.get().itensCarrinho = itens;
            carrinho.get().persistAndFlush();
            return true;
        }
        return false;
    }

    public Optional<CarrinhoDeCompras> obterCarrinhoDeComprasByClienteId(Long clienteId) {
        // Lógica para obter o carrinho de compras atual do cliente
        // Retorna o objeto CarrinhoDeCompras
        return CarrinhoDeCompras.findByClienteId(clienteId);
    }
}