package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.entites.Comment;
import com.example.litigerecouvrement.ibusniess.CommentIBusiness;
import com.example.litigerecouvrement.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentBusiness implements CommentIBusiness {
    @Autowired
    private CommentRepository commentrepo;
    @Override
    public Comment createComment(Comment comment) {

        return commentrepo.save(comment);


    }

    @Override
    public List<Comment> findAllComment() {
        return commentrepo.findAll();
    }

    @Override
    public String deleteComment(String idc) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> findByid(String id) {
        Optional<Comment> findbyref = commentrepo.findById(id);
        return (
                findbyref.isPresent() ?
                        new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );    }

    @Override
    public long countComment() {
        return commentrepo.count();
    }

    @Override
    public Comment updateComment(Comment cmt) {
        return null;
    }
}
