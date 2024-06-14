package org.example.homework_1_back.controller;


import org.example.homework_1_back.domain.ResponseResult;
import org.example.homework_1_back.util.gpt.ZhiPu;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gpt")
public class GPTController {
    private ZhiPu zhiPu = new ZhiPu();

    @PostMapping("/zhipu")
    public ResponseResult<String> zhipu(@RequestBody String input){
        String res = zhiPu.gpt(input);
        return ResponseResult.okResult(res);
    }
}
