package org.example.homework_1_back.util.gpt;

import com.alibaba.dashscope.aigc.conversation.Conversation;
import com.alibaba.dashscope.aigc.conversation.ConversationParam;
import com.alibaba.dashscope.aigc.conversation.ConversationResult;
import com.alibaba.dashscope.aigc.generation.GenerationOutput;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.Constants;
import com.alibaba.dashscope.utils.JsonUtils;
import io.reactivex.Flowable;

import java.util.function.Consumer;

public class TongYi implements GPT {
    {
        Constants.apiKey = "sk-c614d7fb789f4550abdbf4e3e9837831";
    }


    public void streamOutput(String content, Consumer<String> messageCallback) {
        Conversation conversation = new Conversation();
        String prompt = content; // 使用传入的content作为prompt
        ConversationParam param = ConversationParam
                .builder()
                .model(Conversation.Models.QWEN_TURBO)
                .prompt(prompt)
                .build();
        try {
            Flowable<ConversationResult> result = conversation.streamCall(param);
            result.blockingForEach(msg -> {
                GenerationOutput generationOutput=msg.getOutput();
                // 调用回调函数处理每个消息
                messageCallback.accept(generationOutput.getText());
            });
        } catch (ApiException | InputRequiredException | NoApiKeyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void tryIt() {
        try {
            TongYi gpt = new TongYi();
            // 定义一个简单的回调函数来打印消息
            Consumer<String> printMessage = new Consumer<String>() {
                @Override
                public void accept(String text) {
                    System.out.print(text);
                }
            };
            gpt.streamOutput("用萝卜、土豆、茄子做饭，给我个菜谱。", printMessage);

        } catch (ApiException e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }

    @Override
    public void streamOutput(String content) {

    }

    public String  gpt(String content){
        Conversation conversation = new Conversation();
        ConversationParam param = ConversationParam
                .builder()
                .model(Conversation.Models.QWEN_TURBO)
                .prompt(content)
                .build();
        ConversationResult result = null;
        try {
            result = conversation.call(param);
        } catch (NoApiKeyException e) {
            throw new RuntimeException(e);
        } catch (InputRequiredException e) {
            throw new RuntimeException(e);
        }
        return JsonUtils.toJson(result.getOutput().getText());
    }
}