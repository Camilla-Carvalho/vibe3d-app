package br.com.vibe3d.api.endpoints;

import br.com.vibe3d.api.entities.Acabamento;
import br.com.vibe3d.api.entities.Produto;
import br.com.vibe3d.api.services.AcabamentoService;
import br.com.vibe3d.api.services.ProdutoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/acabamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AcabamentoResource {

    @Inject
    AcabamentoService acabamentoService;

    @GET
    public List<Acabamento> listarAcabamentos() {
        return acabamentoService.listarAcabamentos();
    }

    @GET
    @Path("/{id}")
    public Response obterAcabamentoPorId(@PathParam("id") Long id) {
        Optional<Acabamento> acabamento = acabamentoService.obterAcabamentoPorId(id);
        if (acabamento.isPresent()) {
            return Response.ok(acabamento).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response adicionarAcabamento(Acabamento acabamento) {
        Acabamento novoAcabamento = acabamentoService.adicionarNovoAcabamento(acabamento);
        return Response.status(Response.Status.CREATED).entity(novoAcabamento).build();
    }

    @PUT
    public Response atualizarAcabamento(Acabamento acabamento) {
        Optional<Acabamento> acabamentoExistente = acabamentoService.obterAcabamentoPorId(acabamento.id);
        if (acabamentoExistente.isPresent()) {
            acabamentoExistente.get().categoria = acabamento.categoria;
            acabamentoExistente.get().descricao = acabamento.descricao;
            acabamentoExistente.get().nome = acabamento.nome;
            acabamentoExistente.get().preco = acabamento.preco;
            // atualizar acabamento
            Acabamento acabamentoAtualizado = acabamentoService.atualizarAcabamento(acabamentoExistente.get());
            return Response.ok(acabamentoAtualizado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removerAcabamento(@PathParam("id") Long id) {
        boolean removido = acabamentoService.removerAcabamento(id);
        if (removido) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}