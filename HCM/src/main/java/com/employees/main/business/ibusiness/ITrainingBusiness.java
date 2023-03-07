package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.TrainingDTO;
import com.employees.main.entities.Training;

import java.util.List;
import java.util.Optional;

public interface ITrainingBusiness {

    Training addTraining(Training training);
    List<Training>findAllTraining();
    Training editTraining(TrainingDTO trainingDTO, String id);
    Optional<Training> showTraining(String id);
    Training archiveTraining(TrainingDTO trainingDTO, String id);
    Training restoreTraining(TrainingDTO trainingDTO, String id);
    void deleteTraining(String id);

}
