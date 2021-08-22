package part6;

import main.Treasure;

import java.util.*;

/**
 * Calculates the optimal 0-N knapsack by optimised graph search.
 */
public class FasterGraphSearch {

    private Treasure[] items;
    private int maxWeight;
    private int totalItems;
    private int barometer = 0;
    private float bestValue = 0;
    private FasterBag bestBag;

    /**
     * Constructs a knapsack object.
     * @param items     The items on offer.
     * @param maxWeight The weight limit.
     */
    public FasterGraphSearch(Treasure[] items, int maxWeight){
        this.items = items;
        this.maxWeight = maxWeight;
        totalItems = calculateNumber();
    }

    /**
     * Calculates the optimal value the knapsack can hold.
     */
    public void calculateKnapsack(){
        int[] numbers = new int[items.length];
        FasterBag start = new FasterBag(numbers, items);
        createGraph(start);
        System.out.println("Best value by faster graph search is " + bestValue);
        System.out.println("Number of steps: " + barometer);
    }

    /**
     * Constructs the graph for calculating the optimal value.
     * @param node  The current node.
     */
    public void createGraph(FasterBag node){
        //Don't pursue infeasible solutions
        if(node.getTotalWeight() > maxWeight){
            return;
        }
        //If this is the best seen so far, record the details.
        if (node.getTotalValue() > bestValue){
            bestValue = node.getTotalValue();
            bestBag = node;
        }
        float vg = completeGreedyOnSubProblem(node, maxWeight-node.getTotalWeight());
        //Don't pursue infeasible solutions based on the greedy fractional solution to the partial solution left.
        if (node.getTotalValue() + vg <= bestValue){
            return;
        }
        barometer++;
        int[] numbers = node.getNumbers();
        int newLength = numbers.length;
        int[] newNumbers = Arrays.copyOf(numbers, newLength);
        FasterBag current;
        //Create the neighbours of this node.
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < items[i].getNumber()){
                newNumbers[i]++;
                current = new FasterBag(newNumbers, items);
                node.addNeighbour(current);
                newNumbers = Arrays.copyOf(numbers, newLength);
            }
        }
        //Recurse on the neighbours
        for (FasterBag b : node.getNeighbours()){
            createGraph(b);
        }
    }

    /**
     * Calculates the fractional greedy solution on the unfilled part of the knapsack.
     * @param node              The current node.
     * @param weightDifference  The difference between the weight limit and our weight so far.
     * @return                  The upper bound of the feasible solution.
     */
    public float completeGreedyOnSubProblem(FasterBag node, int weightDifference){
        barometer++;
        float superOptimal = 0;
        int itemsLeft = totalItems;
        Queue<Treasure> leftItems = new PriorityQueue<Treasure>();
        int[] numbers = node.getNumbers();
        //Work out the items left to select from
        for (int i = 0; i < numbers.length; i++){
            itemsLeft -= numbers[i];
            int num = items[i].getNumber() - numbers[i];
            for (int j = 0; j < num; j++){
                leftItems.add(items[i]);
            }
        }
        //Get the treasure withe best value/weight ratio.
        Treasure firstItem = leftItems.poll();
        //While still under the weight limit, add the values of the items to the upper bound value
        while(weightDifference - firstItem.getWeight() >= 0){
            superOptimal += firstItem.getValue();
            weightDifference -= firstItem.getWeight();
            firstItem = leftItems.poll();
        }
        float fractionWeight;
        //Calculate the fraction of the next item that we can add to be <= to weight limit
        fractionWeight = weightDifference/firstItem.getWeight();
        //Add the fractional value to the return value
        superOptimal += fractionWeight * firstItem.getValue();

        return superOptimal;
    }

    /**
     * Calculates the full number of items, including multiple copies.
     * @return  The full number.
     */
    public int calculateNumber(){
        int number = 0;
        for (Treasure t : items){
            number+=t.getNumber();
        }
        return number;
    }
}

