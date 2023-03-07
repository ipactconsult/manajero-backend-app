package com.employees.main.business.businessimpl;


import com.employees.main.business.dto.ExpenseDTO;
import com.employees.main.business.ibusiness.IBusinessExpenses;
import com.employees.main.entities.Expenses;
import com.employees.main.repositories.ExpensesRepository;
import org.modelmapper.ModelMapper;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseBusiness implements IBusinessExpenses {
    final ModelMapper mapper;
    final ExpensesRepository expensesRepository;
    JavaMailSender javaMailSender;

    public ExpenseBusiness(ModelMapper mapper,  JavaMailSender javaMailSender,ExpensesRepository expensesRepository) {
        this.mapper = mapper;
        this.javaMailSender = javaMailSender;
        this.expensesRepository = expensesRepository;
    }


    public void sendEmail(String subject,String body,String email){
        MimeMessage emailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(emailMessage, true);
            helper.setSubject(subject);
            helper.setTo(email);
            helper.setText(body, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        javaMailSender.send(emailMessage);
    }

    @Override
    public Expenses createExpense(ExpenseDTO expenseDTO) {

        Expenses expenses=this.mapper.map(expenseDTO,Expenses.class);
        Date date = new Date();
        Instant instanceDateNow = date.toInstant();
        expenses.setCreatedAt(instanceDateNow);
        expenses.setStatus("PENDING");
        return expensesRepository.save(expenses);

    }

    @Override
    public Expenses createExpenseAsDraft(ExpenseDTO expenseDTO) {
        Expenses expenses=this.mapper.map(expenseDTO,Expenses.class);
        Date date = new Date();
        Instant instanceDateNow = date.toInstant();
        expenses.setCreatedAt(instanceDateNow);
        expenses.setStatus("DRAFT");
        return expensesRepository.save(expenses);
    }

    @Override
    public List<Expenses> findExpenses() {
        return expensesRepository.findAll();
    }


    @Override
    public Expenses updateExpense(ExpenseDTO expenseDTO, String id) {
        Expenses expenses=this.mapper.map(expenseDTO,Expenses.class);
        Date date = new Date();
        Instant instanceDateNow = date.toInstant();
        Optional<Expenses> expensesOptional= expensesRepository.findById(id);
        expensesOptional.get().setUpdateAt(instanceDateNow);

      return (expensesOptional.isPresent()? expensesRepository.save(expenses):null);
    }

    @Override
    public Expenses validateExpense(ExpenseDTO expenseDTO, String id) {
        Expenses expenses = this.mapper.map(expenseDTO, Expenses.class);
        sendEmail("Validate Expense",EmailTemplate1.template,expenses.getEmployee().getEmployeeEmail());
        Optional<Expenses> validateExpense = expensesRepository.findById(id);
        expenses.setStatus("Validated");

        return (validateExpense.isPresent()
                ? expensesRepository.save(expenses) : null);
    }

    @Override
    public Expenses rejectExpense(ExpenseDTO expenseDTO, String id) {
        Expenses expenses = this.mapper.map(expenseDTO, Expenses.class);
        sendEmail("Reject Expense",EmailTemplate1.template,expenses.getEmployee().getEmployeeEmail());

        Optional<Expenses> validateExpense = expensesRepository.findById(id);
        expenses.setStatus("Rejected");

        return (validateExpense.isPresent()
                ? expensesRepository.save(expenses) : null);
    }

    @Override
    public Expenses cancelExpense(ExpenseDTO expenseDTO, String id) {
        Expenses expenses = this.mapper.map(expenseDTO, Expenses.class);
        sendEmail("Expense Canceled",EmailTemplate1.template,expenses.getEmployee().getEmployeeEmail());

        Optional<Expenses> validateExpense = expensesRepository.findById(id);
        expenses.setStatus("Canceled");

        return (validateExpense.isPresent()
                ? expensesRepository.save(expenses) : null);
    }

    @Override
    public Expenses archiveExpenses(ExpenseDTO expenseDTO, String id) {
        Expenses expenses = this.mapper.map(expenseDTO, Expenses.class);

        Optional<Expenses> expenseToArchive = expensesRepository.findById(id);
        expenses.setArchive(true);

        return (expenseToArchive.isPresent()
                ? expensesRepository.save(expenses) : null);
    }

    @Override
    public Expenses restoreExpense(ExpenseDTO expenseDTO, String id) {
        Expenses expenses = this.mapper.map(expenseDTO, Expenses.class);

        Optional<Expenses> expenseToArchive = expensesRepository.findById(id);
        expenses.setArchive(false);

        return (expenseToArchive.isPresent()
                ? expensesRepository.save(expenses) : null);
    }

    @Override
    public Expenses getExpense(String id) {
        return expensesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Expenses> getAllByExpensesValidatedStatus() {
        return expensesRepository.findAllByStatus("Validate");
    }
    @Override
    public List<Expenses> getAllByExpensesStatus() {
        return expensesRepository.findAllByStatus("PENDING");
    }
}
