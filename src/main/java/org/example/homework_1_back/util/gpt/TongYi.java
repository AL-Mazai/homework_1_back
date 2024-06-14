package org.example.homework_1_back.util.gpt;

import com.alibaba.dashscope.aigc.conversation.Conversation;
import com.alibaba.dashscope.aigc.conversation.ConversationParam;
import com.alibaba.dashscope.aigc.conversation.ConversationResult;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.Constants;
import io.reactivex.Flowable;

public class TongYi implements GPT {
    {
        Constants.apiKey="sk-c614d7fb789f4550abdbf4e3e9837831";
    }
    public  void streamOutput(String content)   {
        Conversation conversation = new Conversation();
        String prompt = "用萝卜、土豆、茄子做饭，给我个菜谱。";
        ConversationParam param = ConversationParam
                .builder()
                .model(Conversation.Models.QWEN_TURBO)
                .prompt(prompt)
                .build();
        try{
            Flowable<ConversationResult> result = conversation.streamCall(param);
            result.blockingForEach(msg->{
                System.out.print(msg.getOutput());
            });
        }catch(ApiException ex){
            System.out.println(ex.getMessage());
        } catch (InputRequiredException e) {
            System.out.println(e.getMessage());
        } catch (NoApiKeyException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void tryIt(){
        try {
            TongYi gpt=new TongYi();
            gpt.streamOutput("test");

        } catch (ApiException e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }


    @Override
    public String gpt(String content) {
        return null;

    }
}
