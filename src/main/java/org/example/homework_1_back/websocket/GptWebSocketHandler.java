package org.example.homework_1_back.websocket;
import org.example.homework_1_back.dao.ChatRecordDao;
import org.example.homework_1_back.dao.UserDao;
import org.example.homework_1_back.domain.entity.ChatRecord;
import org.example.homework_1_back.domain.entity.User;
import org.example.homework_1_back.service.ChatRecordService;
import org.example.homework_1_back.service.UserService;
import org.example.homework_1_back.util.gpt.TongYi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.Date;
@Component
public class GptWebSocketHandler extends TextWebSocketHandler {

    TongYi tongYi=new TongYi();
    private final ChatRecordDao chatRecordDao;
    private final UserDao userDao;
    private User user;

    public GptWebSocketHandler(@Autowired ChatRecordDao chatRecordDao,@Autowired  UserDao userDao) {
        this.chatRecordDao = chatRecordDao;
        this.userDao = userDao;

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("连接建立！");
        // 连接建立后，可以做一些初始化操作
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

//        此处需要实现用户的获取
        user= userDao.getUserById(1);
        String question = message.getPayload();
        // 直接传递WebSocketSession和消息处理逻辑

        // 保存用户的问题到数据库
        ChatRecord questionRecord = new ChatRecord();
        questionRecord.setUserId(user.getUserId());
        questionRecord.setChatContent(question);
        questionRecord.setCreatedTime(new Date());// 使用LocalDateTime获取当前时间
        questionRecord.setDelTag(1); // 标记为未删除
        questionRecord.setType("问题");
        chatRecordDao.insertChatRecord(questionRecord);
        ChatRecord answerRecord = new ChatRecord();

        tongYi.streamOutput2(question, text -> {
            try {
                sendMessageToClient(session, text);

                // 同时保存答案到数据库
                answerRecord.setUserId(user.getUserId()); // 与问题相同用户
                answerRecord.setChatContent(text);
                answerRecord.setCreatedTime(new Date());
                answerRecord.setDelTag(1);
                answerRecord.setType("回答");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        chatRecordDao.insertChatRecord(answerRecord);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        // 连接关闭后，可以做一些清理工作
    }

    public void sendMessageToClient(WebSocketSession session, String message) {
        try {
            if (session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}