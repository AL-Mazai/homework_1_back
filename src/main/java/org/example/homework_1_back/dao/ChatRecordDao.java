package org.example.homework_1_back.dao;


import org.apache.ibatis.annotations.*;
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
    @Insert("INSERT INTO chat_record(chat_content, created_time, del_tag, user_id, type) VALUES(#{chatContent}, #{createdTime}, #{delTag}, #{userId}, #{type})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertChatRecord(ChatRecord chatRecord);

    @Select("SELECT * FROM chat_record WHERE id = #{id}")
    ChatRecord getChatRecordById(@Param("id") Integer id);

    @Update("UPDATE chat_record SET chat_content=#{chatContent}, created_time=#{createdTime}, del_tag=#{delTag}, user_id=#{userId}, type=#{type} WHERE id=#{id}")
    Integer updateChatRecord(ChatRecord chatRecord);

    @Delete("DELETE FROM chat_record WHERE id=#{id}")
    Integer deleteChatRecord(@Param("id") Integer id);
    @Select("SELECT * FROM chat_record WHERE user_id = #{userId} AND del_tag = 1")
    List<ChatRecord> getUserChatRecords(@Param("userId") Integer userId);

    @Select("SELECT * FROM chat_record WHERE del_tag=1")
    @Deprecated
    ChatRecord queryById(Integer id);
    @Deprecated
    int insert(ChatRecord chatRecord);
    @Deprecated
    int update(ChatRecord chatRecord);
    @Deprecated
    int deleteById(Integer id);

}

