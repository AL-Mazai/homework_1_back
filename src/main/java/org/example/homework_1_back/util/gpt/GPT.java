package org.example.homework_1_back.util.gpt;

public interface GPT {
    public  void streamOutput(String content);
    public String gpt(String content);
}
