package com.assignment.rewards.dto;

public class RewardResponse {

    private Double rewardPoints;

    public RewardResponse(Double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Double getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
