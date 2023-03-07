package com.manazello.pm.business.implbusiness;

import com.manazello.pm.business.ibusiness.InterfaceService;
import com.manazello.pm.dtos.CharterResponseDto;
import com.manazello.pm.entities.Charter;
import com.manazello.pm.repositories.CharterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CharterImpl implements InterfaceService<Charter> {
    final
    CharterRepository charterRepository;

    public CharterImpl(CharterRepository charterRepository) {
        this.charterRepository = charterRepository;
    }

    @Override
    public Charter add(Charter charter) {
        return charterRepository.save(charter);
    }

    @Override
    public List<Charter> findAll() {
        return charterRepository.findAll();
    }
public List<CharterResponseDto> findAllSomeFields()
{   return  charterRepository.displaySomeFields();
}
    @Override
    public boolean delete(String id) {
        Optional<Charter> charterManagedEntitys = charterRepository.findById(id);
        if (charterManagedEntitys.isPresent()) {
            charterRepository.delete(charterManagedEntitys.get());
            return true;
        }
        return false;        }

    @Override
    public Charter update(Charter charter) {
        Optional<Charter> charterManagedEntitys = charterRepository.findById(charter.getId());
        return ((charterManagedEntitys.isPresent()) ? charterRepository.save(charter) : null);
    }

    @Override
    public Charter findById(String id) {
        return charterRepository.findById(id).orElse(null);
    }
}
