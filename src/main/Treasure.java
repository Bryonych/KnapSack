package main;


/**
 * Represents a jewel that can go in the knapsack.
 * @author Bryony Church
 */
public class Treasure implements Comparable<Treasure> {

    private int weight;
    private float value;
    private int number;
    private String name;

    /**
     * Constructs a Treasure object.
     * @param weight    The weight of the jewel.
     * @param value     The value of the jewel.
     * @param number    The number of this jewel available.
     * @param name      The name of the jewel.
     */
    public Treasure(int weight, float value, int number, String name){
        this.weight = weight;
        this.value = value;
        this.number = number;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public float getValue() {
        return value;
    }

    public int getNumber() { return number; }

    @Override
    public int compareTo(Treasure other){
        if ((this.value/this.weight) > (other.value/other.weight))  return -1;
        else if ((this.value/this.weight) < (other.value/other.weight)) return 1;
        else    return 0;
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj)  return true;
        if (obj==null)  return false;
        if(!(obj instanceof Treasure)) return false;
        Treasure other = (Treasure)obj;
        return (this.value == other.value && this.weight == other.weight);
    }
}
