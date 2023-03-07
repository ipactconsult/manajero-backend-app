package com.communicationMarketing.main.business.businessimpl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.communicationMarketing.main.business.dtos.LikeDTO;
import com.communicationMarketing.main.business.ibusiness.ILikeBusiness;
import com.communicationMarketing.main.entity.Like;

import com.communicationMarketing.main.repository.LikeRepository;


@Service
public class LikeBusiness implements ILikeBusiness {
	
	
	   private final LikeRepository likeRepository;
		
	    public LikeBusiness(LikeRepository likeRepository){
	        this.likeRepository=likeRepository;
	    }

	@Override
	public ResponseEntity<Like> addLike(LikeDTO p)  throws ConstraintViolationException {

		

        Date date = new Date();
        Instant instanceNow = date.toInstant();

  
    	 Like   likeToPersist = new Like();
			
    	 likeToPersist.setId(p.getId());
			
    	 likeToPersist.setContent(p.getContent());
    	 likeToPersist.setCreatorId(p.getCreatorId());
    	 likeToPersist.setCreatorName(p.getCreatorName());
    	 likeToPersist.setNumber(p.getNumber());
    	 likeToPersist.setCreatedAt(instanceNow);
    	 likeToPersist.setModifiedAt(instanceNow);


    	 likeRepository.save(likeToPersist);
	   return ResponseEntity.status(HttpStatus.CREATED).body(likeToPersist);
    	
		
		
		
	}

	@Override
	public Like dislike(String id) {
            Like existedLike = likeRepository.findById(id).orElse(null);
            if (existedLike != null) {
                likeRepository.delete(existedLike);
                return existedLike;
            } else {
                return null;
            }
	}

	@Override
	public List<Like> getAllLikes() {
		   return likeRepository.findAll();

		
	}

	@Override
	public long countLikes() {
		   return likeRepository.count();

	}

}
