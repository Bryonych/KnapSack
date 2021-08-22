package part5;

import main.Treasure;

import java.util.*;

/**
 * Calculates the optimal 0-N knapsack by graph search.
 * @author Bryony Church
 */
public class KnapsackGraphSearch {

    private Treasure[] items;
    private int maxWeight;
    private int barometer = 0;
    private float bestValue = 0;
    private Bag bestBag;

    /**
     * Constructs a knapsack object.
     * @param items     The items on offer.
     * @param maxWeight The weight limit.
     */
    public KnapsackGraphSearch(Treasure[] items, int maxWeight){
        this.items = items;
        this.maxWeight = maxWeight;
    }

    /**
     * Calculates the optimal value of the knapsack.
     */
    public void calculateKnapsack(){
        int[] numbers = new int[items.length];
        Bag start = new Bag(numbers, items);
        createGraph(start);
        System.out.println("Best value by full graph search is " + bestValue);
        System.out.println("Number of steps: " + barometer);
    }

    /**
     * Creates a graph for finding the optimal value of the knapsack.
     * @param node  The current node.
     */
    public void createGraph(Bag node){
        //Don't explore infeasible branches.
        if(node.getTotalWeight() > maxWeight){
            return;
        }
        //If this is the best node seen so far, record the details.
        if (node.getTotalValue() > bestValue){
            bestValue = node.getTotalValue();
            bestBag = node;
        }
        barometer++;
        int[] numbers = node.getNumbers();
        int newLength = numbers.length;
        int[] newNumbers = Arrays.copyOf(numbers, newLength);
        Bag current;
        //Create the neighbours of this node.
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < items[i].getNumber()){
                newNumbers[i]++;
                current = new Bag(newNumbers, items);
                node.addNeighbour(current);
                newNumbers = Arrays.copyOf(numbers, newLength);
            }
        }
        //Recurse with the neighbours.
        for (Bag b : node.getNeighbours()){
            createGraph(b);
        }
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
