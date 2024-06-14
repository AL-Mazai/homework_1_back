package org.example.homework_1_back.util.gpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TongYiTest {

    @Test
    public void tryIt() {
        GPT ZhiPu=new ZhiPu();
        System.out.println(ZhiPu.gpt("如何制作糖醋排骨"));
    }
}