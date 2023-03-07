package com.stock.main.controllers;

import com.stock.main.business.businessimpl.MessageBusiness;
import com.stock.main.business.dtos.MessageDTO;
import com.stock.main.entities.Message;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class MessageController {
    
        @Autowired
	private MessageBusiness msgBusiness;
	
	@Autowired
        private ModelMapper modelMapper;
        
        @GetMapping("/all")
	public List<Message> getAllMessages() {
		return msgBusiness.getAllMessages();
	}
        
        @PostMapping("/add")
        public Message addNewMessage(@RequestBody MessageDTO msgDTO) {
            Message message = convertToEntity(msgDTO);
            return msgBusiness.addNewMessage(message);
        }
        
        @PutMapping("/update/{messageId}")
        public Message updateConversation(@RequestBody MessageDTO msgDTO, 
                @PathVariable String messageId) {
            Message message = convertToEntity(msgDTO);
            return msgBusiness.updateConversation(message, messageId);
        }
        
        private Message convertToEntity(MessageDTO msgDTO) {
	    return modelMapper.map(msgDTO, Message.class);
	}
    
}
