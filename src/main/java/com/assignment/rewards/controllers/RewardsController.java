package com.assignment.rewards.controllers;

import com.assignment.rewards.dto.RewardResponse;
import com.assignment.rewards.dto.RewardsRequest;
import com.assignment.rewards.services.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/reward")
public class RewardsController {

	@Autowired
	RewardService rewardService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RewardsController.class);

	@RequestMapping(value = "/points", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RewardResponse> calculateRewards(@RequestBody RewardsRequest request) {
		LOGGER.info("Received com.assignment.rewards calculation request for amount:{}", request.getTransactionAmount());
		return new ResponseEntity(rewardService.calculateRewardPoints(request), HttpStatus.OK);
	}

}
