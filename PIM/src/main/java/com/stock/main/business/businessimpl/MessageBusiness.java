package com.stock.main.business.businessimpl;

import com.stock.main.business.ibusiness.IMessageBusiness;
import com.stock.main.entities.Message;
import com.stock.main.repositories.MessageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageBusiness implements IMessageBusiness {
    
    @Autowired
    private MessageRepository msgRepo;
    
    @Override
    public List<Message> getAllMessages() {
		List<Message> msgs = msgRepo.findAll();
		if (!msgs.isEmpty()) {
			return msgs;
		}
		return new ArrayList<>();
	}
    
    @Override
    public Message addNewMessage(Message message) {
        try {
            msgRepo.save(message);
            return message;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @Override
    public Message updateConversation(Message message, String messageId) {
        Message existedMsg = msgRepo.findById(messageId).orElse(null);
				if (existedMsg != null) {
					existedMsg.setMessages(message.getMessages());
					msgRepo.save(existedMsg);
					return existedMsg;
				}
			return null;
    }
    
}
