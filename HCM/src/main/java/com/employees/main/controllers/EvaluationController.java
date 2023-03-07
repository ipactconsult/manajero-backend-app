package com.employees.main.controllers;

import com.employees.main.business.dto.EvaluationDTO;
import com.employees.main.business.ibusiness.IEvaluationBusiness;
import com.employees.main.entities.Evaluation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/evaluation")
@CrossOrigin(origins = "http://localhost:4200/")
public class EvaluationController {

    private final IEvaluationBusiness iEvaluationBusiness;

    public EvaluationController(IEvaluationBusiness iEvaluationBusiness) {
        this.iEvaluationBusiness = iEvaluationBusiness;
    }

    @PostMapping("/add/{id}")
    public Evaluation create(@RequestBody EvaluationDTO evaluationDTO, @PathVariable String id) throws IOException {
        return iEvaluationBusiness.add(evaluationDTO,id);
    }

    @GetMapping("/all")
    public List<Evaluation> all(){
     return iEvaluationBusiness.showAll();
    }

    @PutMapping("/edit/{id}")
    public Evaluation editE(@RequestBody EvaluationDTO evaluationDTO, @PathVariable("id") String id)
    {
        return  iEvaluationBusiness.edit(evaluationDTO,id);
    }

    @PutMapping("/archive/{id}")
    public Evaluation archiveE(@RequestBody EvaluationDTO evaluationDTO,@PathVariable("id") String id)
    {
        return  iEvaluationBusiness.archive(evaluationDTO,id);
    }

    @PutMapping("/restore/{id}")
    public Evaluation restoreE(@RequestBody EvaluationDTO evaluationDTO,@PathVariable("id") String id)
    {
        return  iEvaluationBusiness.restore(evaluationDTO,id);
    }

    @GetMapping("/show/{id}")
    public Optional<Evaluation> showE(@PathVariable("id")String id)
    {
        return iEvaluationBusiness.show(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteE(@PathVariable("id") String id)
    {
        iEvaluationBusiness.remove(id);
    }
}
