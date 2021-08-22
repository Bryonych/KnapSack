package part3;

import main.Treasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculates the optimal 0-N knapsack by brute force.
 */
public class KnapsackBruteForce {

    private Treasure[] items;
    private int maxWeight;
    private List<Treasure> currentBag = new ArrayList<Treasure>();
    private int count = 0;
    int bestValue = 0;

    /**
     * Constructs a knapsack object.
     * @param items     The items that can go in the knapsack.
     * @param maxWeight The weight limit of the knapsack.
     */
    public KnapsackBruteForce(Treasure[] items, int maxWeight){
        this.items = items;
        this.maxWeight = maxWeight;
        List<Treasure> fullList = createFullList();
        System.out.println("Best value by brute force:");
        System.out.println(calculateKnapsack(fullList, 0, 0, 0));
        System.out.println("Number of steps: " + count);
    }

    /**
     * Creates a list containing all items, including multiple copies.
     * @return  The full list.
     */
    public List<Treasure> createFullList(){
        List<Treasure> fullList = new ArrayList<Treasure>();
        for (Treasure t : items){
            int number = t.getNumber();
            for (int i = 0; i < number; i++){
                fullList.add(t);
            }
        }
        return fullList;
    }

    /**
     * Calculates the optimal value that can be held in the knapsack.
     * @param currentList   The list of items that can go in the knapsack.
     * @param currentValue  The value of the current solution.
     * @param currentWeight The weight of the current solution.
     * @param index         Index to keep track of where we are in the list.
     * @return              The best value so far.
     */
    public float calculateKnapsack(List<Treasure> currentList, float currentValue, int currentWeight, int index){
        count++;
        Treasure currentItem;
        int weight = currentWeight;
        float value = currentValue;
        if (index > currentList.size()-1){
            //We are at the end of the list
            return currentValue;
        }
        //If under the weight limit, check if the next item can be added
        if (currentWeight < maxWeight){
            currentItem = currentList.get(index);
            if (currentWeight + currentItem.getWeight() <= maxWeight){
                currentBag.add(currentItem);
                currentValue += currentItem.getValue();
                currentWeight += currentItem.getWeight();
                //Return the higher value
                return Math.max(calculateKnapsack(currentList, value, weight, index+1),
                        calculateKnapsack(currentList, currentValue, currentWeight, index+1));
            }
            else {
                return currentValue;
            }
        }
        return currentValue;
    }
}
