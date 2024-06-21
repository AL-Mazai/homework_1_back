package org.example.homework_1_back.dao;


import org.apache.ibatis.annotations.Param;
import org.example.homework_1_back.domain.entity.ChatRecord;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 聊天记录(ChatRecord)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-20 21:03:06
 */
public interface ChatRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ChatRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param chatRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ChatRecord> queryAllByLimit(ChatRecord chatRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param chatRecord 查询条件
     * @return 总行数
     */
    long count(ChatRecord chatRecord);

    /**
     * 新增数据
     *
     * @param chatRecord 实例对象
     * @return 影响行数
     */
    int insert(ChatRecord chatRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ChatRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ChatRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ChatRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ChatRecord> entities);

    /**
     * 修改数据
     *
     * @param chatRecord 实例对象
     * @return 影响行数
     */
    int update(ChatRecord chatRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

