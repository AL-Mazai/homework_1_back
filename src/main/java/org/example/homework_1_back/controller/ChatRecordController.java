package org.example.homework_1_back.controller;


import org.example.homework_1_back.dao.ChatRecordDao;
import org.example.homework_1_back.domain.entity.ChatRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 聊天记录(ChatRecord)表控制层
 *
 * @author makejava
 * @since 2024-06-20 21:03:06
 */
@RestController
@RequestMapping("/record")
public class ChatRecordController {
    /**
     * 服务对象
     */
    private final ChatRecordDao chatRecordDao;

    public ChatRecordController(@Autowired ChatRecordDao chatRecordDao) {
        this.chatRecordDao = chatRecordDao;
    }
    @GetMapping
    public List<ChatRecord> getUserChatRecords(@RequestParam("userId") Integer userId) {
        return chatRecordDao.getUserChatRecords(userId);
    }
    @GetMapping("/session")
    public List<ChatRecord> getUserChatRecordsBySession(@RequestParam Integer userId, @RequestParam Integer sessionId) {
        return chatRecordDao.getUserChatRecordsBySession(userId,sessionId);
    }

}

