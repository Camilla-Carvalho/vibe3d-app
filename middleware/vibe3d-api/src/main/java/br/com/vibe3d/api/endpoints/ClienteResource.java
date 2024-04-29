package br.com.vibe3d.api.endpoints;

import br.com.vibe3d.api.entities.Acabamento;
import br.com.vibe3d.api.entities.Cliente;
import br.com.vibe3d.api.services.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GET
    @Path("/{email}")
    public Optional<Cliente> obterClientePorEmail(@PathParam("email") String email) {
        return clienteService.obterClientePorEmail(email);
    }

    @POST
    public Response criarCliente(Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return Response.status(Response.Status.CREATED).entity(novoCliente).build();
    }


    @PUT
    public Response atualizarCliente(Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteService.obterClientePorEmail(cliente.getEmail());
        if (clienteExistente.isPresent()) {
            clienteExistente.get().setNome(cliente.getNome());
            clienteExistente.get().setSobrenome(cliente.getSobrenome());
            clienteExistente.get().setEndereco(cliente.getEndereco());
            Cliente clienteAtualizado = clienteService.atualizarCliente(clienteExistente.get());
            return Response.ok(clienteAtualizado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{email}")
    public Response removerCliente(@PathParam("email") String email) {
        boolean removido = clienteService.removerCliente(email);
        if (removido) {
            return Response.accepted().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}