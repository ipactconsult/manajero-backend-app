package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.LevelDTO;
import com.employees.main.business.ibusiness.LevelIBusiness;
import com.employees.main.entities.Level;
import com.employees.main.repositories.LevelRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LevelBusiness implements LevelIBusiness {

     final LevelRepository levelRepository;

    public LevelBusiness(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public Level createLevel(LevelDTO levelDTO) {
        Level level = new Level();
        level.setLevelReference(levelDTO.getLevelReference());
        return levelRepository.save(level);
    }

    @Override
    public List<Level> findAllLevels() {
        return levelRepository.findAll(Sort.by("levelReference").ascending());
    }

    @Override
    public ResponseEntity<String> deleteLevel(String id) {
        boolean rmLevel = levelRepository.findById(id).isPresent();
        if(rmLevel){
            levelRepository.deleteById(id);
           return new ResponseEntity<>("Row Deleted !", HttpStatus.OK);
        }
        return new ResponseEntity<>("Something Went Wrong !", HttpStatus.NOT_FOUND);
    }

    @Transactional
    @Override
    public Level updateLevel(Level level) {
        Optional<Level> editLevel = levelRepository.findById(level.getId());
        return (editLevel.isPresent() ? levelRepository.save(level) : null);
    }

    @Override
    public long countLevels() {
        return levelRepository.count();
    }


}
