package br.com.vibe3d.api.endpoints;

import br.com.vibe3d.api.entities.Acabamento;
import br.com.vibe3d.api.entities.Produto;
import br.com.vibe3d.api.services.ProdutoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Optional;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    private static final Log log = LogFactory.getLog(ProdutoResource.class);
    @Inject
    ProdutoService produtoService;

    @GET
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GET
    @Path("/{nome}")
    public Optional<Produto> obterProdutoPorNome(@PathParam("nome") String nome) {
        return produtoService.obterProdutoPorNome(nome);
    }

    @GET
    @Path("/{id}/acabamentos")
    public List<Acabamento> listarAcabamentosByProduto(@PathParam("id") Long id) {
        return produtoService.obterAcabamentosByIdProduto(id);
    }

    @POST
    public Response criarProduto(Produto produto) {
        Produto novoProduto = produtoService.criarProduto(produto);
        return Response.status(Response.Status.CREATED).entity(novoProduto).build();
    }

    @PUT
    @Transactional
    public Response atualizarProduto(Produto produto) {
        Optional<Produto> produtoAtualizado = produtoService.atualizarProduto(produto);
        if (produtoAtualizado.isPresent()) {
            produtoAtualizado.get().nome = produto.nome;
            produtoAtualizado.get().arquivoModelo3D = produto.arquivoModelo3D;
            produtoAtualizado.get().tituloSite = produto.tituloSite;
            produtoAtualizado.get().desconto = produto.desconto;
            produtoAtualizado.get().descricao = produto.descricao;
            produtoAtualizado.get().preco = produto.preco;
            produtoAtualizado.get().imagens = produto.imagens;
            // atualizar produto
            produtoAtualizado.get().persistAndFlush();
            // responder ok
            return Response.ok(produtoAtualizado).build();
        } else {
            // responder nok
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removerProduto(@PathParam("id") Long id) {
        boolean removido = produtoService.removerProduto(id);
        if (removido) {
            return Response.accepted().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}