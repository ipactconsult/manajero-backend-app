package com.stock.main.business.ibusiness;

import com.stock.main.entities.Message;
import java.util.List;

public interface IMessageBusiness {
    
    public List<Message> getAllMessages();
    public Message addNewMessage(Message message);
    public Message updateConversation(Message message, String messageId);
    
}
