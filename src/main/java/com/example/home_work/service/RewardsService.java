package com.example.home_work.service;


import com.example.home_work.entity.Rewards;
import org.springframework.stereotype.Service;

@Service
public interface RewardsService {
    public Rewards getRewardsByCustomerId(Integer id);
}
