package com.communicationMarketing.main.business.businessimpl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.communicationMarketing.main.business.dtos.CommentDTO;
import com.communicationMarketing.main.business.ibusiness.ICommentBusiness;
import com.communicationMarketing.main.entity.Comment;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.PostData;
import com.communicationMarketing.main.repository.CommentRepository;
import com.communicationMarketing.main.repository.PostDataRepository;




@Service
public class CommentBusiness  implements  ICommentBusiness {
	
	
	   private final CommentRepository commentRepository;
	
	    public CommentBusiness(CommentRepository commentRepository){
	        this.commentRepository=commentRepository;
	    }

	
	
	@Override
	public ResponseEntity<Comment> addComment(CommentDTO p)   throws ConstraintViolationException {

		 Date date = new Date();
        Instant instanceNow = date.toInstant();

  
    	 Comment   commentToPersist = new Comment();
			
    	 commentToPersist.setId(p.getId());
			
    	 commentToPersist.setContent(p.getContent());
    	 commentToPersist.setCreatorId(p.getCreatorId());
    	 commentToPersist.setCreatorName(p.getCreatorName());
    	// commentToPersist.setPostData(p.getPostData());
    	 commentToPersist.setCreatedAt(instanceNow);
    	 commentToPersist.setModifiedAt(instanceNow);


		 commentRepository.save(commentToPersist);
	return ResponseEntity.status(HttpStatus.CREATED).body(commentToPersist);
    	
	}
	

	@Override
	public ResponseEntity<String> deleteComment(String id) {
		 if(commentRepository.findById(id).isPresent()){
			 commentRepository.deleteById(id);
	            return new ResponseEntity<>("Comment    deleted Successfully!", HttpStatus.OK);
	        }
	        else{
	            return new ResponseEntity<>("Comment  not found", HttpStatus.NOT_FOUND);
	        }

		
	}

	@Override
	public List<Comment> getAllComments() {

		   return commentRepository.findAll();

	}
	
	
	
	@Transactional
	@Override
	public Comment updateComment(Comment  c) {
		 Optional<Comment> commentOptional= commentRepository.findById(c.getId());
	    
	        return (commentOptional.isPresent() ?
	        		commentRepository.save(c)
	                : null);
}
	
	
	@Override
	public ResponseEntity<?> getCommentByID(String id) {
		 Optional<Comment> commentData = commentRepository.findById(id);
	        return commentData.map(contract -> new ResponseEntity<>(contract, HttpStatus.OK)).orElseGet(()
	                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

	}
	
	
	
	
	

	@Override
	public long countPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Comment> findAllCommentASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findAllPostDESC() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
