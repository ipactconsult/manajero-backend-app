package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.TrainingDTO;
import com.employees.main.business.ibusiness.ITrainingBusiness;
import com.employees.main.entities.Training;
import com.employees.main.repositories.TrainingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainingBusinessImpl implements ITrainingBusiness {

     private final TrainingRepository trainingRepository;

     final ModelMapper mapper;



    public TrainingBusinessImpl(TrainingRepository trainingRepository, ModelMapper mapper) {
        this.trainingRepository = trainingRepository;
        this.mapper = mapper;
    }

    @Override
    public Training addTraining(Training training) {

        return trainingRepository.save(training);
    }

    @Override
    public List<Training> findAllTraining() {
        return trainingRepository.findAll();
    }

    @Override
    public Training editTraining(TrainingDTO trainingDTO, String id) {
        Training training = this.mapper.map(trainingDTO,Training.class);
        Optional<Training> editObject = trainingRepository.findById(id);
        return (editObject.isPresent()? trainingRepository.save(training):null);
    }

    @Override
    public Optional<Training> showTraining(String id) {
        return trainingRepository.findById(id);
    }

    @Override
    public Training archiveTraining(TrainingDTO trainingDTO, String id) {
        Training training = this.mapper.map(trainingDTO,Training.class);
        Optional<Training> editObject = trainingRepository.findById(id);
        training.setIsArchived("Yes");
        return (editObject.isPresent()? trainingRepository.save(training):null);
    }

    @Override
    public Training restoreTraining(TrainingDTO trainingDTO, String id) {
        Training training = this.mapper.map(trainingDTO,Training.class);
        Optional<Training> editObject = trainingRepository.findById(id);
        training.setIsArchived("No");
        return (editObject.isPresent()? trainingRepository.save(training):null);
    }

    @Override
    public void deleteTraining(String id) {
            trainingRepository.deleteById(id);
    }
}
