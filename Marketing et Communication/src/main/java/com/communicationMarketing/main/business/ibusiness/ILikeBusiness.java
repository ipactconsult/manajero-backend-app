package com.communicationMarketing.main.business.ibusiness;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.communicationMarketing.main.business.dtos.LikeDTO;
import com.communicationMarketing.main.entity.Like;

public interface ILikeBusiness {
    ResponseEntity<Like> addLike (LikeDTO p);
    Like dislike (String id);
    List<Like> getAllLikes ();
    long countLikes();


}
