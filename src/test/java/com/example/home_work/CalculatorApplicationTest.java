package com.example.home_work;

import com.example.home_work.entity.Transaction;
import com.example.home_work.service.RewardsServiceImpl;
import org.junit.Assert;
import org.junit.Test;


import java.util.*;

public class CalculatorApplicationTest {

    @Test
    public void test(){
        Transaction one = new Transaction(1,1,new Date(),100);
        Transaction two = new Transaction(2,1,new Date(),60);
        Transaction three = new Transaction(3,1,new Date(),150);
        List<Transaction> transactionList =new ArrayList<>();
        transactionList.add(one);
        transactionList.add(three);
        transactionList.add(two);
        Integer score = new RewardsServiceImpl().getRewardsPerMonth(transactionList);
        Assert.assertTrue(score ==210);
    }
}
