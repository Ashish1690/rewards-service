package com.assignment.rewards.services;


import com.assignment.rewards.dto.RewardResponse;
import com.assignment.rewards.dto.RewardsRequest;

public interface RewardService {

	RewardResponse calculateRewardPoints(RewardsRequest rewardsRequest);

}
