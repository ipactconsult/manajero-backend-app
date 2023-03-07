package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.MckenzieDTO;
import com.employees.main.entities.Mckenzie;

import java.util.List;

public interface MckenzieIBusiness {

    Mckenzie add(MckenzieDTO mckenzieDTO);
    List<Mckenzie> visualize();
}
