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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ChatRecord queryById(Integer id) {
        return this.chatRecordDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param chatRecord 实例对象
     * @return 实例对象
     */
    @Override
    public ChatRecord insert(ChatRecord chatRecord) {
        this.chatRecordDao.insert(chatRecord);
        return chatRecord;
    }

    /**
     * 修改数据
     *
     * @param chatRecord 实例对象
     * @return 实例对象
     */
    @Override
    public ChatRecord update(ChatRecord chatRecord) {
        this.chatRecordDao.update(chatRecord);
        return this.queryById(chatRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.chatRecordDao.deleteById(id) > 0;
    }
}
