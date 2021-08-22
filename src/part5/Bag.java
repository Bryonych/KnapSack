package part5;

import main.Treasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a partial solution and a node in the graph.
 * @author Bryony Church
 */
public class Bag {

    private int totalWeight = 0;
    private float totalValue = 0;
    private final int[] numbers;
    private List<Treasure> items = new ArrayList<Treasure>();
    Treasure[] possibleItems;
    List<Bag> neighbours = new ArrayList<Bag>();

    /**
     * Constructs a Bag object.
     * @param numbers   The numbers of each item in the bag.
     * @param items     The list of items on offer.
     */
    public Bag(int[] numbers, Treasure[] items){
        this.numbers = numbers;
        this.possibleItems = items;
        createBag();

    }

    /**
     * Adds items to the bag, based on the numbers in the numbers array.
     */
    public void createBag(){
        for (int p = 0; p < possibleItems.length; p++){
            for (int j = 0; j < numbers[p]; j++){
                addToBag(possibleItems[p], p);
            }
        }
    }

    /**
     * For each item added, increases the value and weight and adds the treasure object to the list.
     * @param item  The item to be added.
     * @param index The index of the item in the original list.
     */
    public void addToBag(Treasure item, int index){
        totalWeight += item.getWeight();
        totalValue += item.getValue();
        items.add(item);
    }

    /**
     * Adds a neighbouring bag to the list of neighbours.
     * @param neighbour
     */
    public void addNeighbour(Bag neighbour){
        neighbours.add(neighbour);
    }

    public List<Bag> getNeighbours(){
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


}
