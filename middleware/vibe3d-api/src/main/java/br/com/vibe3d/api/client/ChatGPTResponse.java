package br.com.vibe3d.api.client;

import java.util.List;

public class ChatGPTResponse {
    public List<Choice> choices;

    public static class Choice {
        public String text;
    }
}
