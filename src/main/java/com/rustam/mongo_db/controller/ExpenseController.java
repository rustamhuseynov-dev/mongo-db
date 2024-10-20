package com.rustam.mongo_db.controller;

import com.rustam.mongo_db.model.Expense;
import com.rustam.mongo_db.service.ExpenseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/expense")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ExpenseController {

    ExpenseService expenseService;

    @PostMapping(path = "/save")
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense){
        return new ResponseEntity<>(expenseService.save(expense), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        return new ResponseEntity<>(expenseService.update(expense), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<List<Expense>> findAllExpense(){
        return new ResponseEntity<>(expenseService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Expense> findByName(@PathVariable String id){
        return new ResponseEntity<>(expenseService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteExpense(@PathVariable String id){
        expenseService.delete(id);
    }
}
