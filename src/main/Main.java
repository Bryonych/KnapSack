package main;

import part2.Knapsack01;
import part3.KnapsackBruteForce;
import part4.Knapsack0N;
import part5.KnapsackGraphSearch;
import part6.FasterGraphSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates test cases and passes them to the knapsack algorithms for processing.
 * @author Bryony Church
 */
public class Main {

    List<Treasure[]> testSets = new ArrayList<Treasure[]>();

    /**
     * Creates test sets for the 0-1 algorithm and creates instances of this knapsack object.
     */
    public void perform01BarometerTests(){
        RandomTreasureGenerator rtg = new RandomTreasureGenerator();
        Treasure[] items = rtg.generate01Set(10);
        System.out.println("________________________________");
        System.out.println("Number of items = 10");
        Knapsack01 ks = new Knapsack01(items);
        ks.calculateKnapsack(50);

        items = rtg.generate01Set(50);
        System.out.println("________________________________");
        System.out.println("Number of items = 50");
        ks = new Knapsack01(items);
        ks.calculateKnapsack(50);

        items = rtg.generate01Set(100);
        System.out.println("________________________________");
        System.out.println("Number of items = 100");
        ks = new Knapsack01(items);
        ks.calculateKnapsack(50);

        items = rtg.generate01Set(500);
        System.out.println("________________________________");
        System.out.println("Number of items = 500");
        ks = new Knapsack01(items);
        ks.calculateKnapsack(50);

        items = rtg.generate01Set(1000);
        System.out.println("________________________________");
        System.out.println("Number of items = 1000");
        ks = new Knapsack01(items);
        ks.calculateKnapsack(50);

        items = rtg.generate01Set(10000);
        System.out.println("________________________________");
        System.out.println("Number of items = 10000");
        ks = new Knapsack01(items);
        ks.calculateKnapsack(50);
    }

    /**
     * Creates an instance of the brute force algorithm and passes it the test sets.
     */
    public void performBruteForceTests() {
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 5");
        KnapsackBruteForce kbf = new KnapsackBruteForce(testSets.get(0), 50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 7");
        kbf = new KnapsackBruteForce(testSets.get(1), 50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 10");
        kbf = new KnapsackBruteForce(testSets.get(2), 50);
    }

    /**
     * Creates an instance of the dynamic programming algorithm and passes it the test sets.
     */
    public void perform0NDynamicTests(){
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 5");
        Knapsack0N kn = new Knapsack0N(testSets.get(0));
        kn.calculateKnapsack(50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 7");
        kn = new Knapsack0N(testSets.get(1));
        kn.calculateKnapsack(50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 10");
        kn = new Knapsack0N(testSets.get(2));
        kn.calculateKnapsack(50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 15");
        kn = new Knapsack0N(testSets.get(3));
        kn.calculateKnapsack(50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 20");
        kn = new Knapsack0N(testSets.get(4));
        kn.calculateKnapsack(50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 50");
        kn = new Knapsack0N(testSets.get(5));
        kn.calculateKnapsack(50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 100");
        kn = new Knapsack0N(testSets.get(6));
        kn.calculateKnapsack(50);
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 1000");
        kn = new Knapsack0N(testSets.get(7));
        kn.calculateKnapsack(50);
    }

    /**
     * Creates an instance of the graph search algorithm and passes it the test sets.
     */
    public void performGraphTests(){
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 5");
        KnapsackGraphSearch kgs = new KnapsackGraphSearch(testSets.get(0), 50);
        kgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 7");
        kgs = new KnapsackGraphSearch(testSets.get(1), 50);
        kgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 10");
        kgs = new KnapsackGraphSearch(testSets.get(2), 50);
        kgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 15");
        kgs = new KnapsackGraphSearch(testSets.get(3), 50);
        kgs.calculateKnapsack();
    }

    /**
     * Creates an instance of the faster graph search algorithm and passes it the test sets.
     */
    public void performFasterGraphTests(){
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 5");
        FasterGraphSearch fgs = new FasterGraphSearch(testSets.get(0), 50);
        fgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 7");
        fgs = new FasterGraphSearch(testSets.get(1), 50);
        fgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 10");
        fgs = new FasterGraphSearch(testSets.get(2), 50);
        fgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 15");
        fgs = new FasterGraphSearch(testSets.get(3), 50);
        fgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 20");
        fgs = new FasterGraphSearch(testSets.get(4), 50);
        fgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 50");
        fgs = new FasterGraphSearch(testSets.get(5), 50);
        fgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 100");
        fgs = new FasterGraphSearch(testSets.get(6), 50);
        fgs.calculateKnapsack();
        System.out.println("________________________________");
        System.out.println("Maximum number of copies = 1000");
        fgs = new FasterGraphSearch(testSets.get(7), 50);
        fgs.calculateKnapsack();
    }

    public static void main(String args[]){
        Main main = new Main();
        //Creates tests based on the lecture slides example
        RandomTreasureGenerator rtg = new RandomTreasureGenerator();
        Treasure[] items = rtg.generateTestSetOne();
        Knapsack01 ks = new Knapsack01(items);
        ks.calculateKnapsack(10);

        Treasure[] multiItems = rtg.generateTestSetTwo();

        KnapsackBruteForce kbf = new KnapsackBruteForce(items, 10);
        KnapsackBruteForce kbfm = new KnapsackBruteForce(multiItems, 10);

        Knapsack0N ksn = new Knapsack0N(items);
        ksn.calculateKnapsack(10);
        Knapsack0N ksnm = new Knapsack0N(multiItems);
        ksnm.calculateKnapsack(10);

        KnapsackGraphSearch kgs = new KnapsackGraphSearch(items, 10);
        kgs.calculateKnapsack();
        KnapsackGraphSearch kgsm = new KnapsackGraphSearch(multiItems,10);
        kgsm.calculateKnapsack();

        //Generate test sets for testing different sizes
        rtg.generate0NSet(5);
        rtg.generate0NSet(7);
        rtg.generate0NSet(10);
        rtg.generate0NSet(15);
        rtg.generate0NSet(20);
        rtg.generate0NSet(50);
        rtg.generate0NSet(100);
        rtg.generate0NSet(1000);
        main.testSets = rtg.getTestSets();

        main.perform01BarometerTests();
        main.performBruteForceTests();
        main.perform0NDynamicTests();
        main.performGraphTests();
        main.performFasterGraphTests();

    }
}
