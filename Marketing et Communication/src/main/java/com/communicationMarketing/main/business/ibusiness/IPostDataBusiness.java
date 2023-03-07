package com.communicationMarketing.main.business.ibusiness;
import java.util.List;




import org.springframework.http.ResponseEntity;

import com.communicationMarketing.main.business.dtos.CommentDTO;
import com.communicationMarketing.main.business.dtos.PostDataDTO;
import com.communicationMarketing.main.entity.Comment;
import com.communicationMarketing.main.entity.PostData;
public interface IPostDataBusiness {
	

	//PostData addPost (PostDataDTO postDataDTO);
	 ResponseEntity<PostData> addPost (PostDataDTO postDataDTO);

    PostData updatePost (PostData p);
    ResponseEntity<String> deletePost (String id);
    List<PostData> getAllPublications ();
    ResponseEntity<?> getPublicationByID(String id);
    long countPosts();
	List<PostData> findAllPostASC();
	 List<PostData> findAllPostDESC();

}
