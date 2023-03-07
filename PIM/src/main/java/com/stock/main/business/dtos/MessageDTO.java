package com.stock.main.business.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    
    private String messageId;
    
    private Object[] messages;
    
    private String theOther;
    
    private String me;
    
    public MessageDTO() {
        super();
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
