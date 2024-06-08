package br.com.vibe3d.api.client;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/chatgpt")
public class ChatGPTResource {

    @Inject
    ChatGPTService chatGPTService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ask(@QueryParam("questao") String questao) {
        String base = "Use o conteto da aplicação vibe3d: ";
        return chatGPTService.askQuestion(base+questao);
    }
}