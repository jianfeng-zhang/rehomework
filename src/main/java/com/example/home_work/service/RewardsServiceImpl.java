package com.example.home_work.service;


import com.example.home_work.entity.Rewards;
import com.example.home_work.entity.Transaction;
import com.example.home_work.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.*;


@Service
public class RewardsServiceImpl implements RewardsService {


    @Autowired
    TransactionRepository transactionRepository;



    public Rewards getRewardsByCustomerId(Integer id) {

        Date lastMonth = getDate(30);
        Date SecondMonth = getDate(60);
        Date ThirdMonth = getDate(90);
        List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(id, lastMonth, Date.from(Instant.now()));
        List<Transaction> lastSecondMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(id, SecondMonth, lastMonth);
        List<Transaction> lastThirdMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(id, ThirdMonth, SecondMonth);

        Integer lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
        Integer lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
        Integer lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

        Rewards customerRewards = new Rewards();
        customerRewards.setCustomerId(id);
        customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
        customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
        customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
        customerRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

        return customerRewards;

    }

    public Integer getRewardsPerMonth(List<Transaction> transactions) {
        int res  =0;
        for(Transaction ele: transactions)  res += computeRewards(ele);
        return res;
    }

    private Integer computeRewards(Transaction t) {
        int amount = t.getTransactionAmount();
        if (amount > 50 && amount <= 100) return amount - 50;
        else if (amount > 100) return (amount - 100) * 2 + 50;
        return 0;

    }

    private Date getDate(int days) {
        return Date.from(OffsetDateTime.now().minusDays(days).toInstant());
    }

}
