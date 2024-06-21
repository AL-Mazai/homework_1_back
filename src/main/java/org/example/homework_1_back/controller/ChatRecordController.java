package org.example.homework_1_back.controller;


import jakarta.annotation.Resource;
import org.example.homework_1_back.domain.entity.ChatRecord;
import org.example.homework_1_back.service.ChatRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 聊天记录(ChatRecord)表控制层
 *
 * @author makejava
 * @since 2024-06-20 21:03:06
 */
@RestController
@RequestMapping("chatRecord")
public class ChatRecordController {
    /**
     * 服务对象
     */
    @Resource
    private ChatRecordService chatRecordService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ChatRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.chatRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param chatRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ChatRecord> add(ChatRecord chatRecord) {
        return ResponseEntity.ok(this.chatRecordService.insert(chatRecord));
    }

    /**
     * 编辑数据
     *
     * @param chatRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ChatRecord> edit(ChatRecord chatRecord) {
        return ResponseEntity.ok(this.chatRecordService.update(chatRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.chatRecordService.deleteById(id));
    }

}

