package com.communicationMarketing.main.business.businessimpl;

import java.time.Instant;



import java.util.Date;
import java.util.List;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.communicationMarketing.main.business.dtos.CommentDTO;
import com.communicationMarketing.main.business.dtos.PostDataDTO;
import com.communicationMarketing.main.business.ibusiness.IPostDataBusiness;
import com.communicationMarketing.main.entity.Comment;
import com.communicationMarketing.main.entity.PostData;
import com.communicationMarketing.main.repository.PostDataRepository;

@Service
public class PostDataBusiness  implements  IPostDataBusiness{
	
	
	   private final PostDataRepository postDataRepository;
	    public PostDataBusiness(PostDataRepository  postDataRepository){
	        this.postDataRepository=postDataRepository;
	    }
	    
	/*    @Override
		public PostData addPost(PostDataDTO postDataDTO) {
	        Date date = new Date();
	        Instant instanceNow = date.toInstant();

			
	    	
	    	PostData postData = new PostData(
	    			postDataDTO.getId(),
	    			postDataDTO.getDescription(),
	    			postDataDTO.getCreatorId(),
	    			postDataDTO.getImageUrl(),
	    			postDataDTO.getName() ,
	    			
	    			
	    			postDataDTO.getCreatedAt(),
	    			postDataDTO.getModifiedAt() ,
	    			postDataDTO.getComments() ,
	    			postDataDTO.getLikes() 
	    	  );
	          return postDataRepository.save(postData);
              }*/
	    
	    
		@Override
		public ResponseEntity<PostData> addPost(PostDataDTO postDataDTO)  throws ConstraintViolationException {
           
			Date date = new Date();
	        Instant instanceNow = date.toInstant();

	  
	        PostData   postDataToPersist = new PostData();
	        postDataToPersist.setId(postDataDTO.getId());
	        postDataToPersist.setDescription(postDataDTO.getDescription());
	    	//postDataToPersist.setCreatorId(postDataDTO.getCreatedAt()):
	    	postDataToPersist.setImageUrl(postDataDTO.getImageUrl());
	    	postDataToPersist.setName(postDataDTO.getName()) ;
			
			
	    	postDataToPersist.setCreatedAt(instanceNow);
	    	postDataToPersist.setModifiedAt(instanceNow) ;
	    	postDataToPersist.setComments(postDataDTO.getComments()) ;
	    	postDataToPersist.setLikes(postDataDTO.getLikes())  ;
	    	


	    	postDataRepository.save(postDataToPersist);
		return ResponseEntity.status(HttpStatus.CREATED).body(postDataToPersist);
	    	
			
			
			
		}


	


	
	@Transactional
	@Override
	public PostData updatePost(PostData p) {
	
		  Date date= new Date();
	       Instant dateToUpdate= date.toInstant();
	       p.setModifiedAt(dateToUpdate);


		 Optional<PostData> postOptional= postDataRepository.findById(p.getId());
		    
	        return (postOptional.isPresent() ?
	        		postDataRepository.save(p)
	                : null);


		}

	@Override
	public ResponseEntity<String> deletePost(String id) {
		 if(postDataRepository.findById(id).isPresent()){
			 postDataRepository.deleteById(id);
	            return new ResponseEntity<>("Post   deleted Successfully!", HttpStatus.OK);
	        }
	        else{
	            return new ResponseEntity<>("Post  not found", HttpStatus.NOT_FOUND);
	        }

	}

	@Override
	public List<PostData> getAllPublications() {
		   return postDataRepository.findAll();

	}

	@Override
	public ResponseEntity<?> getPublicationByID(String id) {
		 Optional<PostData> partnerdata = postDataRepository.findById(id);
	        return partnerdata.map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElseGet(()
	                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@Override
	public long countPosts() {
		   return postDataRepository.count();

	}

	@Override
	public List<PostData> findAllPostASC() {
        return postDataRepository.findAll(Sort.by(Sort.Direction.ASC,"createdAt"));

	}

	@Override
	public List<PostData> findAllPostDESC() {
        return postDataRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

	}
	
	
	 public ResponseObjectService updatePostByComment(PostData inputPost) {
	        ResponseObjectService responseObj = new ResponseObjectService();
	        Optional<PostData> optPost = postDataRepository.findById(inputPost.getId());
	      /*  if (optPost.isEmpty()) {
	            responseObj.setStatus("fail");
	            responseObj.setMessage("cannot find post id: " + inputPost.getId());
	            responseObj.setPayload(null);
	            return responseObj;
	        } else {*/
	            // inputPost.setCreatedAt(Instant.now());
	            postDataRepository.save(inputPost);
	            responseObj.setStatus("success");
	            responseObj.setMessage("post is updated successfully");
	            responseObj.setPayload(inputPost);
	            return responseObj;
	        //}
	    }



	
	

}
