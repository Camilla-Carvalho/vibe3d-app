package br.com.vibe3d.api.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ChatGPTService {

    @Inject
    @RestClient
    ChatGPTClient chatGPTClient;

    public String askQuestion(String question) {
        ChatGPTRequest request = new ChatGPTRequest(question, 100);
        ChatGPTResponse response = chatGPTClient.sendQuestion(request);
        return response.choices.get(0).text.trim();
    }
}