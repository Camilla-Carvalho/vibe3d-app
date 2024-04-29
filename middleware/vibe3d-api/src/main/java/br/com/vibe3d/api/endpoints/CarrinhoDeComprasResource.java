package br.com.vibe3d.api.endpoints;

import br.com.vibe3d.api.entities.CarrinhoDeCompras;
import br.com.vibe3d.api.services.CarrinhoDeComprasService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/carrinho")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoDeComprasResource {

    @Inject
    CarrinhoDeComprasService carrinhoDeComprasService;

    @GET
    @Path("/{idCliente}")
    public Response obterCarrinhoDeCompras(@PathParam("idCliente") Long idCliente) {
        Optional<CarrinhoDeCompras> carrinhoDeCompras = carrinhoDeComprasService.obterCarrinhoDeComprasByClienteId(idCliente);
        if (carrinhoDeCompras.isPresent()) {
            return Response.ok(carrinhoDeCompras).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/adicionar/{idCliente}/{idItem}")
    public Response adicionarItemAoCarrinho(@PathParam("idCliente") Long idCliente, @PathParam("idItem") Long idItem) {
        boolean adicionado = carrinhoDeComprasService.adicionarItemAoCarrinho(idCliente, idItem);
        if (adicionado) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{idCliente}/{idItem}")
    public Response removerItemDoCarrinho(@PathParam("idCliente") Long idCliente, @PathParam("idItem") Long idItem) {
        boolean removido = carrinhoDeComprasService.removerItemDoCarrinho(idCliente, idItem);
        if (removido) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}