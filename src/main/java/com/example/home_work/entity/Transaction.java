package com.example.home_work.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="customer_id")
    private Integer customerId;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "amount")
    private Integer transactionAmount;

}
