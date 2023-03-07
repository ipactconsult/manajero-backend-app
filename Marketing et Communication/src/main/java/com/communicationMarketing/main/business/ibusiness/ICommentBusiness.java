package com.communicationMarketing.main.business.ibusiness;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.communicationMarketing.main.business.dtos.CommentDTO;
import com.communicationMarketing.main.entity.Comment;

public interface ICommentBusiness {
	    ResponseEntity<Comment> addComment (CommentDTO p);
	    ResponseEntity<String> deleteComment (String id);
	    List<Comment> getAllComments ();
	    long countPosts();
		List<Comment> findAllCommentASC();
		List<Comment> findAllPostDESC();
		 Comment updateComment(Comment  c) ;
		 ResponseEntity<?> getCommentByID(String id);

}
