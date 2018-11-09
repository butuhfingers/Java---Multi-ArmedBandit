import java.util.Random;

public class Bandit {
    //Variables
    private float rewardPercent;
    private int rewardMean;
    private Random random;


    private int getReward() {
        return this.rewardMean;
    }

    public float getRewardFunction(){
        return this.rewardMean * this.rewardPercent;
    }

    //Constructors
    public Bandit(float rewardPercent, int rewardMean){
        this.rewardPercent = rewardPercent;
        this.rewardMean = rewardMean;
        random = new Random();
    }

    //Functions
    public int attempt(){
        float chance = random.nextFloat();

        if(chance <= rewardPercent){
            //Return our reward
            return rewardMean;
        }

        return 0;
    }

    @Override
    public String toString(){
        return "Single-armed bandit values: " +
                "\n Reward percent:" + this.rewardPercent +
                "\n Reward mean: " + this.rewardMean;
    }
}
