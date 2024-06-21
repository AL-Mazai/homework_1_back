package org.example.homework_1_back.controller;


import org.checkerframework.checker.units.qual.C;
import org.example.homework_1_back.domain.ResponseResult;
import org.example.homework_1_back.domain.entity.ChatRecord;
import org.example.homework_1_back.service.ChatRecordService;
import org.example.homework_1_back.util.gpt.ZhiPu;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("gpt")
public class GPTController {
    private ZhiPu zhiPu = new ZhiPu();

    private ChatRecordService chatRecordService;

    @PostMapping("/zhipu")
    public ResponseResult<String> zhipu(@RequestBody String input){
        String res = zhiPu.gpt(input);
        return ResponseResult.okResult(res);
    }
}
