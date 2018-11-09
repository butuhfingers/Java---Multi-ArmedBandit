import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    //Variables
    private static int banditCount = 10;
    private static int iterations = 1000;
    private static float epsilom = 0.1f;
    private static LinkedList<BanditStats> bandits;

    //Main function
    public static void main(String[] args) {
        Random randomizer = new Random();
        bandits = new LinkedList<BanditStats>();

        //Create 10 bandits
        for(int bandit = 0;bandit < banditCount;bandit++){
            bandits.add(new BanditStats(new Bandit(randomizer.nextFloat(), randomizer.nextInt((10 - 0) + 1))));
        }


        //Find the bandit with the greatest potential
        //This will be using a greedy algorithm
        for(int attempt = 0;attempt < iterations;attempt++){
            Collections.sort(bandits);
            BanditStats currentBandit = bandits.getFirst();

            //Check if we fall under the random episolom and choose a random bandit
            if(randomizer.nextFloat() < epsilom) {
                currentBandit = bandits.get(randomizer.nextInt(banditCount));
            }

            int reward = currentBandit.getBandit().attempt();
            currentBandit.addReward(reward);
//            System.out.println("Bandit means: " + currentBandit.getRewardMean());
        }

        PrintBandits();
    }

    private static void PrintBandits(){
        for(int bandit = 0;bandit < banditCount;bandit++){
            BanditStats currentBandit = bandits.get(bandit);
            System.out.println("Bandit " + bandit + ":\n Total Reward mean:"
                    + currentBandit.getRewardMean()
                    + " || " + currentBandit.getBandit().getRewardFunction() + "\n"
                    + currentBandit.getBandit().toString());
        }
    }
}
