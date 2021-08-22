package part4;

import main.Treasure;

/**
 * Calculates the optimal 0-N knapsack by dynamic programming.
 */
public class Knapsack0N {

    private Treasure[] items;
    private int barometer = 0;
    float[][] values;

    /**
     * Constructs a knapsack object.
     * @param items The items that can go in the knapsack.
     */
    public Knapsack0N(Treasure[] items){
        this.items = items;
    }

    /**
     * Calculates the optimal value the knapsack can hold.
     * @param maxWeight The weight limit.
     */
    public void calculateKnapsack(int maxWeight){
        int number = calculateNumber();
        Treasure[] fullList = createFullList(number);
        values = new float[number][maxWeight+1];
        //Set up the first row in the table
        for (int w = 0; w <= maxWeight; w++){
            barometer++;
            if (w < fullList[0].getWeight()) {
                values[0][w] = 0;
            }
            else {
                values[0][w] = fullList[0].getValue();
            }
        }
        //Construct the rest of the table
        for (int i = 1; i < number; i++){
            for (int j = 0; j <= maxWeight; j++){
                barometer++;
                if (fullList[i].getWeight() > j){
                    values[i][j] = values[i-1][j];
                }
                else {
                    values[i][j] = (float)Math.max(values[i-1][j], values[i-1][j-fullList[i].getWeight()] + fullList[i].getValue());
                }
            }
        }
        System.out.println("0-N problem by dynamic programming");
        System.out.println("Number of steps: " + barometer);
        System.out.println("Total value is " + values[number-1][maxWeight]);
    }

    /**
     * Creates a list containing all items, including multiple copies.
     * @param length    The full number of items on offer.
     * @return          The full list.
     */
    public Treasure[] createFullList(int length){
        Treasure[] newList = new Treasure[length];
        int counter = 0;
        for (int i = 0; i < items.length; i++){
            int number = items[i].getNumber();
            for (int j = 0; j < number; j++){
                newList[i+counter+j] = items[i];
            }
            counter += number-1;
        }
        return newList;
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
