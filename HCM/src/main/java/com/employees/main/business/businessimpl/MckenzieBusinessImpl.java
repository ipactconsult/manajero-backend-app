package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.MckenzieDTO;
import com.employees.main.business.ibusiness.MckenzieIBusiness;
import com.employees.main.entities.Mckenzie;
import com.employees.main.entities.Pay;
import com.employees.main.repositories.MckenzieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MckenzieBusinessImpl implements MckenzieIBusiness {

    private final ModelMapper modelMapper;

    private final MckenzieRepository mckenzieRepository;

    public MckenzieBusinessImpl(ModelMapper modelMapper, MckenzieRepository mckenzieRepository) {
        this.modelMapper = modelMapper;
        this.mckenzieRepository = mckenzieRepository;
    }

    @Override
    public Mckenzie add(MckenzieDTO mckenzieDTO) {
        Mckenzie mckenzie= this.modelMapper.map(mckenzieDTO,Mckenzie.class);
        mckenzieRepository.save(mckenzie);
        return mckenzie;
    }

    @Override
    public List<Mckenzie> visualize() {
        return mckenzieRepository.findAll();
    }
}
