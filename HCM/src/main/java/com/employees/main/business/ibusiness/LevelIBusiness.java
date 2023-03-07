package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.LevelDTO;
import com.employees.main.entities.Level;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LevelIBusiness {

    Level createLevel(LevelDTO levelDTO);
    List <Level> findAllLevels();
    ResponseEntity<String> deleteLevel(String id);
    Level updateLevel(Level level);
    long countLevels();


}
