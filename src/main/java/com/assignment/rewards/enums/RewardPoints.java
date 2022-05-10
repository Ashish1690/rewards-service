package com.assignment.rewards.enums;

public enum RewardPoints {

    HUNDRED_DOLLARS_REWARD(100.0, 1.0),
    FIFTY_DOLLARS_REWARD(50.0, 1.0);

    private Double amount;
    private Double points;

    RewardPoints(Double amount, Double points){
        this.amount = amount;
        this.points = points;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getPoints() {
        return points;
    }
}
