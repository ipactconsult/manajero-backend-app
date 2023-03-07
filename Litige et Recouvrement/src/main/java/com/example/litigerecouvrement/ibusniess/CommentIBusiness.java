package com.example.litigerecouvrement.ibusniess;


import com.example.litigerecouvrement.entites.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentIBusiness {
    Comment createComment(Comment comment);
    List<Comment> findAllComment();
    public String deleteComment(String idc) ;
    ResponseEntity<Comment> findByid(String id);

    long countComment ();
    public Comment updateComment(Comment cmt);
}
