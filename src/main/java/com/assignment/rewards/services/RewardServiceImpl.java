package com.assignment.rewards.services;

import com.assignment.rewards.dto.RewardResponse;
import com.assignment.rewards.dto.RewardsRequest;
import com.assignment.rewards.enums.RewardPoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RewardServiceImpl implements RewardService {

	@Override
	public RewardResponse calculateRewardPoints(RewardsRequest rewardsRequest) {
		
		Double totalPoints  = 0.0;
		Double transactionAmount = rewardsRequest.getTransactionAmount();
		if(transactionAmount <= 0.0){
			throw new IllegalArgumentException("Transaction amount should be greater than zero");
		}
		if(transactionAmount > RewardPoints.HUNDRED_DOLLARS_REWARD.getAmount()) {
			totalPoints = (transactionAmount - RewardPoints.HUNDRED_DOLLARS_REWARD.getAmount())
					* RewardPoints.HUNDRED_DOLLARS_REWARD.getPoints();
		}
		if(transactionAmount > RewardPoints.FIFTY_DOLLARS_REWARD.getAmount()){
			totalPoints += (transactionAmount - RewardPoints.FIFTY_DOLLARS_REWARD.getAmount()) * RewardPoints.FIFTY_DOLLARS_REWARD.getPoints();
		}
		return new RewardResponse(totalPoints);
	}
	
}
