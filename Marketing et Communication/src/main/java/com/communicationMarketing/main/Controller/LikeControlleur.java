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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicationMarketing.main.business.dtos.CommentDTO;
import com.communicationMarketing.main.business.dtos.LikeDTO;
import com.communicationMarketing.main.business.ibusiness.ILikeBusiness;
import com.communicationMarketing.main.entity.Like;

@RequestMapping(path = { "/Like" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class LikeControlleur {
	

	@Autowired
	private  ILikeBusiness ILikeBusiness;

    public LikeControlleur(ILikeBusiness ILikeBusiness){
        this.ILikeBusiness=ILikeBusiness;
    }

    
    @PostMapping("/add")
    public ResponseEntity<Like> addLike(@Valid @RequestBody LikeDTO likeDTO){
        return ILikeBusiness.addLike(likeDTO);
    }
    
    
    
    @GetMapping("/all")
    public ResponseEntity<List<Like>> findAllLike(){
        List<Like> rows = ILikeBusiness.getAllLikes();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    

   


    @DeleteMapping("/delete/{id}")
    public Like dislike(@PathVariable String id){
        return ILikeBusiness.dislike(id);
    }

    


    @GetMapping("/count-Likes")
    public long countPosts(){
        return ILikeBusiness.countLikes();

    }




}
