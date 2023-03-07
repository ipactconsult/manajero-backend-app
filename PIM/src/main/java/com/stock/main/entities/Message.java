package com.stock.main.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
@Getter
@Setter
public class Message {
    
    @Id
    private String messageId;
    
    private String me;
    
    private String theOther;
    
    private Object[] messages;
    
    public Message() {
        super();
    }

    /**
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the me
     */
    public String getMe() {
        return me;
    }

    /**
     * @param me the me to set
     */
    public void setMe(String me) {
        this.me = me;
    }

    /**
     * @return the theOther
     */
    public String getTheOther() {
        return theOther;
    }

    /**
     * @param theOther the theOther to set
     */
    public void setTheOther(String theOther) {
        this.theOther = theOther;
    }

    /**
     * @return the messages
     */
    public Object[] getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(Object[] messages) {
        this.messages = messages;
    }
    
    
    
}
