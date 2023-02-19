package com.example.home_work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rewards {
    private Integer customerId;
    private Integer lastMonthRewardPoints;
    private Integer lastSecondMonthRewardPoints;
    private Integer lastThirdMonthRewardPoints;
    private Integer totalRewards;

}
