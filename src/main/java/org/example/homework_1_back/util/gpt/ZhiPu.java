package org.example.homework_1_back.util.gpt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhipu.oapi.ClientV4;
import com.zhipu.oapi.Constants;
import com.zhipu.oapi.service.v4.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//f779df436dfc7fe987118c1112e12152.bKpyMkTCSJAsT3m3
public class ZhiPu implements GPT {
    public static ClientV4 client = new ClientV4.Builder("f779df436dfc7fe987118c1112e12152.bKpyMkTCSJAsT3m3")
            .enableTokenCache()
            .networkConfig(600, 600, 600, 600, TimeUnit.SECONDS)
            .build();


    @Override
    public void streamOutput(String content) {

    }

    public  String gpt(String content) {
        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage chatMessage = new ChatMessage(ChatMessageRole.USER.value(), content);
        messages.add(chatMessage);
        String requestId = String.format("test1 ", System.currentTimeMillis());

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model(Constants.ModelChatGLM4)
                .stream(Boolean.FALSE)
                .invokeMethod(Constants.invokeMethod)
                .messages(messages)
                .requestId(requestId)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        ModelApiResponse invokeModelApiResp = client.invokeModelApi(chatCompletionRequest);
        ModelData modelData = invokeModelApiResp.getData();
        String output = modelData.getChoices().get(0).getMessage().getContent().toString();
        return output;
    }
}
