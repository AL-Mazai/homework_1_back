package org.example.homework_1_back.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.example.homework_1_back.dao.ChatRecordDao;
import org.example.homework_1_back.domain.entity.ChatRecord;
import org.example.homework_1_back.service.ChatRecordService;
import org.springframework.stereotype.Service;

/**
 * 聊天记录(ChatRecord)表服务实现类
 *
 * @author makejava
 * @since 2024-06-20 21:03:06
 */
@Service("chatRecordService")
public class ChatRecordServiceImpl implements ChatRecordService {
    @Resource
    private ChatRecordDao chatRecordDao;


}
