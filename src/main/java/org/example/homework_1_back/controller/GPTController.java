package org.example.homework_1_back.controller;


import org.checkerframework.checker.units.qual.C;
import org.example.homework_1_back.dao.ChatRecordDao;
import org.example.homework_1_back.domain.ResponseResult;
import org.example.homework_1_back.domain.entity.ChatRecord;
import org.example.homework_1_back.service.ChatRecordService;
import org.example.homework_1_back.util.gpt.TongYi;
import org.example.homework_1_back.util.gpt.ZhiPu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/gpt")
public class GPTController {
    private ZhiPu zhiPu = new ZhiPu();
    private TongYi tongYi = new TongYi();
    private final ChatRecordDao chatRecordDao;

    public GPTController(@Autowired ChatRecordDao chatRecordDao) {
        this.chatRecordDao = chatRecordDao;
    }

    @PostMapping("/zhipu")
    public ResponseResult<String> zhipu(@RequestParam String input,@RequestParam Integer userId,@RequestParam Integer sessionId){
        String res = zhiPu.gpt(input);

        //        插入问题
        ChatRecord question = new ChatRecord();
        question.setUserId(userId);
        question.setChatContent(input);
        question.setCreatedTime(new Date());// 使用LocalDateTime获取当前时间
        question.setDelTag(1); // 标记为未删除
        question.setType("问题");

        chatRecordDao.insertChatRecord(question);
        //        插入答案
        ChatRecord answer = new ChatRecord();
        answer.setUserId(userId);
        answer.setChatContent(res);
        answer.setCreatedTime(new Date());// 使用LocalDateTime获取当前时间
        answer.setDelTag(1); // 标记为未删除
        answer.setType("回答");
        chatRecordDao.insertChatRecord(answer);

        return ResponseResult.okResult(res);
    }
    @PostMapping("/tongyi")
    public ResponseResult<String> tongyi(@RequestParam String input,@RequestParam Integer userId){
        String res = tongYi.gpt(input);

        //        插入问题
        ChatRecord question = new ChatRecord();
        question.setUserId(userId);
        question.setChatContent(input);
        question.setCreatedTime(new Date());// 使用LocalDateTime获取当前时间
        question.setDelTag(1); // 标记为未删除
        question.setType("问题");
        chatRecordDao.insertChatRecord(question);
        //        插入答案
        ChatRecord answer = new ChatRecord();
        answer.setUserId(userId);
        answer.setChatContent(res);
        answer.setCreatedTime(new Date());// 使用LocalDateTime获取当前时间
        answer.setDelTag(1); // 标记为未删除
        answer.setType("回答");
        chatRecordDao.insertChatRecord(answer);

        return ResponseResult.okResult(res);
    }
}
