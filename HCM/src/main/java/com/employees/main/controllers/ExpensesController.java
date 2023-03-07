package com.employees.main.controllers;


import com.employees.main.business.dto.ExpenseDTO;
import com.employees.main.business.ibusiness.IBusinessExpenses;
import com.employees.main.entities.Expenses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/expenses", produces = APPLICATION_JSON_VALUE)
public class ExpensesController {
    private final IBusinessExpenses iBusinessExpenses;

    public ExpensesController(IBusinessExpenses iBusinessExpenses) {
        this.iBusinessExpenses = iBusinessExpenses;
    }

    @PostMapping(value = "/create")
    public Expenses createExpenses(@Valid @RequestBody ExpenseDTO expenseDTO ){
        return  iBusinessExpenses.createExpense(expenseDTO);
    }

    @PostMapping(value = "/saveAsDraft")
    public Expenses createRequestLeaveAsDraft(@Valid @RequestBody ExpenseDTO expenseDTO){
        return  iBusinessExpenses.createExpenseAsDraft(expenseDTO);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Expenses>> findAll(){
        return new ResponseEntity<>(iBusinessExpenses.findExpenses(), HttpStatus.OK);
    }


    @PutMapping( "/update/{id}")
    public Expenses editExpense(@RequestBody ExpenseDTO expenseDTO,@PathVariable("id") String id)
    {
        return iBusinessExpenses.updateExpense(expenseDTO,id);
    }

    @PutMapping("/validate-expense/{id}")
    public Expenses validateExpense(@RequestBody ExpenseDTO expenseDTO,@PathVariable("id") String id)
    {
        return iBusinessExpenses.validateExpense(expenseDTO,id);
    }

    @PutMapping("/reject-expense/{id}")
    public Expenses rejectExpense(@RequestBody ExpenseDTO expenseDTO,@PathVariable("id") String id)
    {
        return iBusinessExpenses.rejectExpense(expenseDTO,id);
    }

    @PutMapping("/cancel-expense/{id}")
    public Expenses cancelExpense(@RequestBody ExpenseDTO expenseDTO,@PathVariable("id") String id)
    {
        return iBusinessExpenses.cancelExpense(expenseDTO,id);
    }

    @PutMapping("/archive-expense/{id}")
    public Expenses archiveExpenses(@RequestBody ExpenseDTO expenseDTO,@PathVariable("id") String id)
    {
        return iBusinessExpenses.archiveExpenses(expenseDTO,id);
    }

    @PutMapping("/restore-expense/{id}")
    public Expenses restoreExpenses(@RequestBody ExpenseDTO expenseDTO, @PathVariable("id") String id)
    {
        return iBusinessExpenses.restoreExpense(expenseDTO,id);
    }


    @GetMapping("/get-expense/{id}")
    public Expenses getExpenses(@PathVariable("id") String id)
    {
        return iBusinessExpenses.getExpense(id);
    }

    @GetMapping(value = "/allvalidate")
    public ResponseEntity<List<Expenses>> allValidate(){
        return new ResponseEntity<>(iBusinessExpenses.getAllByExpensesValidatedStatus(), HttpStatus.OK);
    }





}
