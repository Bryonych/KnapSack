package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Randomly generates sets of jewels for testing.
 */
public class RandomTreasureGenerator {
    //The jewel types.
    public enum Type {
        GOLD,
        DIAMOND,
        SAPPHIRE,
        RUBY,
        AMETHYST,
        SILVER,
        BRONZE
    }

    private List<Treasure[]> testSets = new ArrayList<Treasure[]>();


    public RandomTreasureGenerator(){
    }

    /**
     * Generates the example test set from the lecture slides.
     * @return  The test set.
     */
    public Treasure[] generateTestSetOne(){
        Treasure one = new Treasure(7, 49, 1, "Gold");
        Treasure two = new Treasure(5, 30, 1, "Diamond");
        Treasure three = new Treasure(5, 25, 1, "Sapphire");
        Treasure four = new Treasure(4, 24, 1, "Ruby");
        Treasure[] items = {one, two, three, four};
        return items;
    }

    /**
     * Adjusts the test set to test 0-N algorithms.
     * @return  The test set.
     */
    public Treasure[] generateTestSetTwo(){
        Treasure one = new Treasure(7, 49, 1, "Gold");
        Treasure two = new Treasure(5, 30, 2, "Diamond");
        Treasure three = new Treasure(5, 25, 1, "Sapphire");
        Treasure four = new Treasure(4, 24, 1, "Ruby");
        Treasure[] items = {one, two, three, four};
        return items;
    }

    /**
     * Generates a test set for the 0-1 algorithm.
     * @param number    Number of items in the set.
     * @return          The Test set.
     */
    public Treasure[] generate01Set(int number){
        Treasure[] items = new Treasure[number];
        Random random = new Random();
        for (int i = 0; i < number; i++){
            int weight = random.nextInt(20);
            float value = random.nextFloat()*100;
            int type = random.nextInt(Type.values().length);
            Type jewell = Type.values()[type];
            Treasure current = new Treasure(weight, value, 1, jewell.toString());
            items[i] = current;
        }
        return items;
    }

    /**
     * Generates a test set for hte 0-N algorithms.
     * @param number    The maximum number of copies there can be of each jewel.
     * @return          The test set.
     */
    public Treasure[] generate0NSet(int number){
        Treasure[] items = new Treasure[Type.values().length];
        Random random = new Random();
        for (int i = 0; i < Type.values().length; i++){
            int weight = random.nextInt(20);
            float value = random.nextFloat()*100;
            int copies = random.nextInt(number);
            Type jewell = Type.values()[i];
            Treasure current = new Treasure(weight, value, copies, jewell.toString());
            items[i] = current;
            //Print the number of copies for analysis purposes
            System.out.print(copies + " ");
        }
        System.out.println(" ");
        testSets.add(items);
        return items;
    }

    public List<Treasure[]> getTestSets(){
        return testSets;
    }
}
