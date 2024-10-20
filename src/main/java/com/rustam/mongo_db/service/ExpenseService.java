package com.rustam.mongo_db.service;

import com.rustam.mongo_db.model.Expense;
import com.rustam.mongo_db.repository.ExpenseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Slf4j
public class ExpenseService {

    ExpenseRepository expenseRepository;

    public Expense save(Expense expense) {
        return expenseRepository.insert(expense);
    }

    public Expense update(Expense expense) {
        Expense expenseId = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException("bele bir expense tapilmadi"));
        expenseId.setAmount(expense.getAmount());
        expenseId.setName(expense.getName());
        expenseId.setCategory(expense.getCategory());
        return expenseRepository.save(expenseId);
    }

    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(String id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("bele bir expense tapilmadi"));
    }

    public void delete(String id) {
        expenseRepository.deleteById(id);
    }
}
