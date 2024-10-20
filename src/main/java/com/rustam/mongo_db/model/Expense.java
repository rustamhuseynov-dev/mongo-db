package com.rustam.mongo_db.model;

import com.rustam.mongo_db.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;

    private Category category;

    private BigDecimal amount;
}
