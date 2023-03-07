package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.EvaluationDTO;
import com.employees.main.entities.Evaluation;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IEvaluationBusiness {

    Evaluation add(EvaluationDTO evaluationDTO, String id) throws IOException;
    Evaluation edit(EvaluationDTO evaluationDTO, String id);
    Optional<Evaluation>show(String id);
    List<Evaluation> showAll();
    Evaluation archive(EvaluationDTO evaluationDTO, String id);
    Evaluation restore(EvaluationDTO evaluationDTO, String id);
    void remove(String id);
}
