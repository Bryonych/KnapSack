package part2;

import main.Treasure;

/**
 * Calculates the optimal 0-1 knapsack by dynamic programming.
 */
public class Knapsack01 {

    private Treasure[] items;
    private int barometer = 0;

    /**
     * Constructs a knapsack object.
     * @param items The items that can be put into the knapsack.
     */
    public Knapsack01(Treasure[] items){
        this.items = items;
    }

    /**
     * Calculates the optimal value the knapsack can hold.
     * @param maxWeight The weight limit of the knapsack.
     */
    public void calculateKnapsack(int maxWeight){
        int number = items.length;
        float[][] values = new float[number][maxWeight+1];
        //Set up the first row in the table
        for (int w = 0; w <= maxWeight; w++){
            barometer++;
            if (w < items[0].getWeight()) {
                values[0][w] = 0;
            }
            else {
                values[0][w] = items[0].getValue();
            }
        }
        //Construct the rest of the table
        for (int i = 1; i < number; i++){
            for (int j = 0; j <= maxWeight; j++){
                barometer++;
                if (items[i].getWeight() > j){
                    values[i][j] = values[i-1][j];
                }
                else {
                    values[i][j] = (float)Math.max(values[i-1][j], values[i-1][j-items[i].getWeight()] + items[i].getValue());
                }
            }
        }
        System.out.println("0-1 problem by dynamic programming");
        System.out.println("Total value is " + values[number-1][maxWeight]);
        System.out.println("Number of steps: "  + barometer);
    }


}
