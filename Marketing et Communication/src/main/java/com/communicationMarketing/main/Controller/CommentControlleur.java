package com.communicationMarketing.main.Controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicationMarketing.main.business.dtos.CommentDTO;
import com.communicationMarketing.main.business.ibusiness.ICommentBusiness;
import com.communicationMarketing.main.entity.Comment;
import com.communicationMarketing.main.entity.Event;

@RequestMapping(path = { "/Comment" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class CommentControlleur {
	

	@Autowired
	private  ICommentBusiness ICommentBusiness;

    public CommentControlleur(ICommentBusiness ICommentBusiness){
        this.ICommentBusiness=ICommentBusiness;
    }

    
    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@Valid @RequestBody CommentDTO commentDataDTO){
        return ICommentBusiness.addComment(commentDataDTO);
    }
    
    
    
    @GetMapping("/all")
    public ResponseEntity<List<Comment>> findAllComment(){
        List<Comment> rows = ICommentBusiness.getAllComments();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    @GetMapping("/Comment-by-id/{id}")
    public ResponseEntity<?> getCommentByID (@PathVariable("id") String id){
        return ICommentBusiness.getCommentByID(id);
    }


   


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") String id){
        return ICommentBusiness.deleteComment(id);
    }
    
    @PutMapping("/update-comment")
    public Comment updateComment(@RequestBody Comment c){
        return ICommentBusiness.updateComment(c);
    }

    


    @GetMapping("/count-Posts")
    public long countPosts(){
       // return IParternershipBusiness.countParternerships();
    	return 0 ;

    }

    
    @GetMapping( "/descending")
    public ResponseEntity<List<Comment>> listCommentDesc(){
        //return new ResponseEntity<>(IPostDataBusiness.findAllPostDESC(), HttpStatus.OK);
    	   return null ;

    }
    @GetMapping( "/ascending")
    public ResponseEntity<List<Comment>> listCommentAsc(){
        //return new ResponseEntity<>(IPostDataBusiness.findAllPostASC(), HttpStatus.OK);
   return null ;
    }



}
