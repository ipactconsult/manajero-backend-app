package com.employees.main.controllers;

import com.employees.main.business.dto.TrainingDTO;
import com.employees.main.business.ibusiness.ITrainingBusiness;
import com.employees.main.entities.Training;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/training")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class TrainingController {

    private final ITrainingBusiness iTrainingBusiness;

    public TrainingController(ITrainingBusiness iTrainingBusiness) {
        this.iTrainingBusiness = iTrainingBusiness;
    }

    @PostMapping("/create")
    public Training addT(@RequestBody Training trainingDTO)
    {
      return  iTrainingBusiness.addTraining(trainingDTO);
    }

    @GetMapping("/all")
    public List<Training> findAllT()
    {
        return  iTrainingBusiness.findAllTraining();
    }

    @PutMapping("/edit/{id}")
    public Training editT(@RequestBody TrainingDTO trainingDTO,@PathVariable("id") String id)
    {
        return  iTrainingBusiness.editTraining(trainingDTO,id);
    }

    @PutMapping("/archive/{id}")
    public Training archiveT(@RequestBody TrainingDTO trainingDTO,@PathVariable("id") String id)
    {
        return  iTrainingBusiness.archiveTraining(trainingDTO,id);
    }

    @PutMapping("/restore/{id}")
    public Training restoreT(@RequestBody TrainingDTO trainingDTO,@PathVariable("id") String id)
    {
        return  iTrainingBusiness.restoreTraining(trainingDTO,id);
    }

    @GetMapping("/show/{id}")
    public Optional<Training> showT(@PathVariable("id")String id)
    {
        return iTrainingBusiness.showTraining(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteT(@PathVariable("id") String id)
    {
        iTrainingBusiness.deleteTraining(id);
    }
}
