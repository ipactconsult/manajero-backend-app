package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.ExpenseDTO;
import com.employees.main.entities.Expenses;

import java.util.List;

public interface IBusinessExpenses {

    Expenses createExpense(ExpenseDTO expenseDTO);
    Expenses createExpenseAsDraft(ExpenseDTO expenseDTO);
    List<Expenses> findExpenses();
    Expenses updateExpense(ExpenseDTO expenseDTO, String id);
    Expenses validateExpense(ExpenseDTO expenseDTO, String id);
    Expenses rejectExpense(ExpenseDTO expenseDTO, String id);
    Expenses cancelExpense(ExpenseDTO expenseDTO, String id);
    Expenses archiveExpenses(ExpenseDTO expenseDTO, String id);
    Expenses restoreExpense(ExpenseDTO expenseDTO, String id);

    Expenses getExpense(String id);
    List<Expenses>getAllByExpensesStatus();

    List<Expenses> getAllByExpensesValidatedStatus();

}
