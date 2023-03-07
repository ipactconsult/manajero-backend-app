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
import com.communicationMarketing.main.business.dtos.PostDataDTO;
import com.communicationMarketing.main.business.ibusiness.IPostDataBusiness;
import com.communicationMarketing.main.entity.Comment;
import com.communicationMarketing.main.entity.PostData;

@RequestMapping(path = { "/PostData" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class  PostDataControlleur {
	

	@Autowired
	private  IPostDataBusiness IPostDataBusiness;

    public PostDataControlleur(IPostDataBusiness IPostDataBusiness){
        this.IPostDataBusiness=IPostDataBusiness;
    }

    
   /* @PostMapping("/add")
    public PostData addpost(@Valid @RequestBody PostDataDTO PostDataDTO){
        return IPostDataBusiness.addPost(PostDataDTO);
    }*/
    
    
    
    @PostMapping("/add")
    public ResponseEntity<PostData> addpost(@Valid @RequestBody PostDataDTO PostDataDTO){
        return IPostDataBusiness.addPost(PostDataDTO);
    }
    
    
    
    @GetMapping("/all")
    public ResponseEntity<List<PostData>> findAllPost(){
        List<PostData> rows = IPostDataBusiness.getAllPublications();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    

    @PutMapping("/update-Post")
    public PostData updatePost(@RequestBody PostData p){
        return IPostDataBusiness.updatePost(p); 
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") String id){
        return IPostDataBusiness.deletePost(id);
    }

    
    @GetMapping("/Post-by-id/{id}")
    public ResponseEntity<?> getPostByID (@PathVariable("id") String id){
        return IPostDataBusiness.getPublicationByID(id);
    	
    }


    @GetMapping("/count-Posts")
    public long countPosts(){
       // return IParternershipBusiness.countParternerships();
    	return 0 ;

    }

    
    @GetMapping( "/descending")
    public ResponseEntity<List<PostData>> listPartnerDesc(){
        return new ResponseEntity<>(IPostDataBusiness.findAllPostDESC(), HttpStatus.OK);
    }
    @GetMapping( "/ascending")
    public ResponseEntity<List<PostData>> listPartnerrAsc(){
        return new ResponseEntity<>(IPostDataBusiness.findAllPostASC(), HttpStatus.OK);
    }
    
    
   /* 
    @PostMapping("/insertcomment")
    public ResponseEntity<ResponseObjectService> insertComment(@RequestBody CommentPostRequestEntity postedComment) {
        CommentEntity inputComment = postedComment.getCommentEntity();
        IdObjectEntity inputPostId = postedComment.getPostId();
        return new ResponseEntity<ResponseObjectService>(commentService.insertComment(inputComment, inputPostId.getId()), HttpStatus.OK);
    }
    */
    
    


}
