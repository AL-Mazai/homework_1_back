package org.example.homework_1_back.util.gpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TongYiTest {

    @Test
    public void tryIt() {
        TongYi tongyi = new TongYi();
        tongyi.gpt("教我如何制作糖醋排骨");
    }
    @Test
    public void gpt() {
        TongYi tongyi = new TongYi();
        System.out.println(tongyi.gpt("教我如何制作糖醋排骨"));
    }
}