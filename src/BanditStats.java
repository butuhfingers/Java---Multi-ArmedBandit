import java.util.Comparator;
import java.util.LinkedList;

public class BanditStats implements Comparable<BanditStats>{
    //Variables
    private Bandit bandit;
    private LinkedList<Integer> rewards = new LinkedList<Integer>();

    //Getters and setters
    public Bandit getBandit(){
        return this.bandit;
    }

    public float getRewardMean(){
        float mean = 0;

        //We need a reward to calculate a reward.
        if(rewards.size() < 1){
            return 0;
        }

        //Foreach reward in rewards
        for(Integer reward : rewards){
            mean += reward;
        }

        return mean / rewards.size();
    }

    //Constructors
    public BanditStats(Bandit bandit){
        this.bandit = bandit;
    }

    //Functions
    public void addReward(int reward){
        rewards.add(reward);
    }

    public int compareTo(BanditStats banditStats){
        return banditStats.getRewardMean() < this.getRewardMean() ? -1 : 1;
    }
//    //Using the UCB1 algorithm
//    public double calculateOptimism(int totalAttempts){
//        //Calculations
//        double calculation = 0;
//
//        calculation = this.getRewardMean() +
//                (Math.sqrt((2 * Math.log(totalAttempts)) /
//                        (this.rewards.size())));
//
//        return calculation;
//    }
}
