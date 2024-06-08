package br.com.vibe3d.api.client;

import java.util.List;

public class ChatGPTRequest {
    public String prompt;
    public int max_tokens;

    public ChatGPTRequest(String prompt, int max_tokens) {
        this.prompt = prompt;
        this.max_tokens = max_tokens;
    }
}

