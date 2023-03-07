package com.recruitment.recruitmenthcmmanagement.controllers;

import com.recruitment.recruitmenthcmmanagement.business.ibusiness.IBusinessJobsCategory;
import com.recruitment.recruitmenthcmmanagement.entities.JobsCategory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"recruitment/jobsCategory"})
@CrossOrigin(origins = "http://localhost:4200/")
public class JobsCategoryController {

    final IBusinessJobsCategory iBusinessJobsCatgeory;

    public JobsCategoryController(IBusinessJobsCategory iBusinessJobsCatgeory) {
        this.iBusinessJobsCatgeory = iBusinessJobsCatgeory;
    }

    @PostMapping("/create")
    public JobsCategory postCategoryJob(@RequestBody JobsCategory jobsCategory)
    {
        return iBusinessJobsCatgeory.add(jobsCategory);
    }

    @GetMapping("/all")
    public List<JobsCategory> allCategories()
    {
        return iBusinessJobsCatgeory.records();
    }

    @PutMapping("/update/{id}")
    public JobsCategory editCategory(@RequestBody JobsCategory jobsCategory, @PathVariable("id")String id)
    {
        return iBusinessJobsCatgeory.edit(jobsCategory,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id")String id)
    {
         iBusinessJobsCatgeory.remove(id);
    }

    @GetMapping("/show/{id}")
    public Optional<JobsCategory> showCategory(@PathVariable("id")String id)
    {
        return iBusinessJobsCatgeory.show(id);
    }


}
