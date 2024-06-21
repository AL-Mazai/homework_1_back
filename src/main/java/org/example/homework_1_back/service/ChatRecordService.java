package org.example.homework_1_back.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.homework_1_back.domain.entity.ChatRecord;

/**
 * 聊天记录(ChatRecord)表服务接口
 *
 * @author makejava
 * @since 2024-06-20 21:03:06
 */
public interface ChatRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ChatRecord queryById(Integer id);


    /**
     * 新增数据
     *
     * @param chatRecord 实例对象
     * @return 实例对象
     */
    ChatRecord insert(ChatRecord chatRecord);

    /**
     * 修改数据
     *
     * @param chatRecord 实例对象
     * @return 实例对象
     */
    ChatRecord update(ChatRecord chatRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
