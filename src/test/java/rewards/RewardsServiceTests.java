package rewards;
import com.assignment.rewards.services.RewardServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import com.assignment.rewards.dto.RewardsRequest;
import com.assignment.rewards.services.RewardService;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RewardsServiceTests {

    private RewardService rewardService = new RewardServiceImpl();

    @Test
    public void throw_exception_with_transaction_amount_less_than_1(){
        RewardsRequest rewardsRequest = new RewardsRequest();
        rewardsRequest.setTransactionAmount(0.0);
        Assertions.assertThrows(IllegalArgumentException.class,() -> rewardService.calculateRewardPoints(rewardsRequest));
    }

    @Test
    public void throw_exception_with_transaction_amount_greater_than_50_and_less_than_100(){
        RewardsRequest rewardsRequest = new RewardsRequest();
        rewardsRequest.setTransactionAmount(75.0);
        Assertions.assertEquals(rewardService.calculateRewardPoints(rewardsRequest).getRewardPoints(), 25.0);
    }

    @Test
    public void throw_exception_with_transaction_amount_greater_than_100(){
        RewardsRequest rewardsRequest = new RewardsRequest();
        rewardsRequest.setTransactionAmount(120.0);
        Assertions.assertEquals(rewardService.calculateRewardPoints(rewardsRequest).getRewardPoints(), 90.0);
    }

    @Test
    public void throw_exception_with_transaction_amount_less_than_50(){
        RewardsRequest rewardsRequest = new RewardsRequest();
        rewardsRequest.setTransactionAmount(30.0);
        Assertions.assertEquals(rewardService.calculateRewardPoints(rewardsRequest).getRewardPoints(), 0.0);
    }
}
