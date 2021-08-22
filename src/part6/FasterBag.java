package part6;

import main.Treasure;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Represents a partial solution and a node in the graph for the faster solution.
 * @author Bryony Church
 */
public class FasterBag implements Comparable<FasterBag> {

    private int totalWeight = 0;
    private float totalValue = 0;
    private final int[] numbers;
    private List<Treasure> items = new ArrayList<Treasure>();
    Treasure[] possibleItems;
    Queue<FasterBag> neighbours = new PriorityQueue<FasterBag>();
    Boolean visited = false;

    /**
     * Constructs an optimised bag object.
     * @param numbers   The numbers of each item in the bag.
     * @param items     The list of items on offer.
     */
    public FasterBag(int[] numbers, Treasure[] items) {
        this.numbers = numbers;
        this.possibleItems = items;
        createBag();

    }

    /**
     * Adds the items to the bag, based on the numbers in the numbers array.
     */
    public void createBag() {
        for (int p = 0; p < possibleItems.length; p++) {
            for (int j = 0; j < numbers[p]; j++) {
                addToBag(possibleItems[p], p);
            }
        }
    }

    /**
     * For an item added, the value and weight is increased and the item is added to the list.
     * @param item  The item to be added.
     * @param index The index of this item in the original list.
     */
    public void addToBag(Treasure item, int index) {
        totalWeight += item.getWeight();
        totalValue += item.getValue();
        items.add(item);
    }

    /**
     * Adds a neighbouring bag to the neighbours list.
     * @param neighbour The neighbouring bag.
     */
    public void addNeighbour(FasterBag neighbour) {
        neighbours.offer(neighbour);
    }

    public Queue<FasterBag> getNeighbours() {
        return neighbours;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public int[] getNumbers() {
        return numbers;
    }

    @Override
    public int compareTo(FasterBag other){
        if((this.totalValue/this.totalWeight) > (other.totalValue/other.totalWeight))   return -1;
        else if ((this.totalValue/this.totalWeight) < (other.totalValue/other.totalWeight)) return 1;
        else    return 0;
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj)  return true;
        if (obj==null)  return false;
        if(!(obj instanceof FasterBag)) return false;
        FasterBag other = (FasterBag)obj;
        return (this.totalValue == other.totalValue && this.totalWeight == other.totalWeight);
    }

}