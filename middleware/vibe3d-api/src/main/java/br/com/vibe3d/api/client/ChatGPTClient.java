package br.com.vibe3d.api.client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1/engines/davinci-codex/completions")
@RegisterRestClient(configKey = "chatgpt-api")
public interface ChatGPTClient {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ChatGPTResponse sendQuestion(ChatGPTRequest request);
}