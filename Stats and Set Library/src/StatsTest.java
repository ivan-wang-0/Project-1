import java.util.ArrayList;

public class StatsTest {

    public static void main(String[] args) {

        // Testing StatsLibrary

        ArrayList<Double> list = new ArrayList<>();
        list.add(0.0);
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);
        list.add(5.0);

        System.out.println("Mean: " + StatsLibrary.getMean(list) + ", Expected: 2.85714");

        System.out.println("Median: " + StatsLibrary.getMedian(list) + ", Expected: 3.0");

        System.out.println("Mode: " + StatsLibrary.getMode(list) + ", Expected: 5.0");
        System.out.println("Variance: " + StatsLibrary.variance(list) + ", Expected: 3.26531");
        System.out.println("Standard Deviation: " + StatsLibrary.standardDeviation(list) + ", Expected: 1.80701");
        System.out.println("Factorial(5): " + StatsLibrary.factorial(5) + ", Expected: 120");
        System.out.println("Permutation(5, 2): " + StatsLibrary.permutation(5, 2) + ", Expected: 20");
        System.out.println("Combination(5, 2): " + StatsLibrary.combination(5, 2) + ", Expected: 10");
        System.out.println("Conditional Probability (0.3, 0.5): " + StatsLibrary.conditionalProbability(0.3, 0.5) + ", Expected: 0.6");
        System.out.println("Bayes (0.5, 0.4, 0.6): " + StatsLibrary.bayes(0.5, 0.4, 0.6) + ", Expected: 0.333...");
        System.out.println("Is Independent (0.5, 0.6, 0.3): " + StatsLibrary.isIndependent(0.5, 0.6, 0.3) + ", Expected: false");

        // Chapter 3

        System.out.println("Binomial Distribution (5, 3, 0.5): " + StatsLibrary.binomialDist(10, 3, 0.5) + ", Expected: 0.11719");
        System.out.println("Geometric Distribution (0.5, 3): " + StatsLibrary.geometricDist(0.5, 5) + ", Expected: 0.03125");
        System.out.println("Hypergeometric Distribution (100, 10, 50, 5): " + StatsLibrary.hyperGeoDist(100, 10, 50, 5) + ", Expected: 0.25933");
        System.out.println("Negative Binomial Distribution (5, 10, 0.5): " + StatsLibrary.negativeBinomialDist(5, 10, 0.5) + ", Expected: 0.12305");
        System.out.println("Poisson Distribution (10, 5): " + StatsLibrary.poisson(10, 5) + ", Expected: 0.0378...");
        System.out.println("Chebyshev's Inequality (40, 60, 50, 10): " + StatsLibrary.chebeyshev(30, 70, 50, 10) + ", Expected: 0.75");

        // Testing SetOperations

        ArrayList<Double> setA = new ArrayList<>();
        setA.add(1.0);
        setA.add(2.0);
        setA.add(3.0);

        ArrayList<Double> setB = new ArrayList<>();
        setB.add(3.0);
        setB.add(4.0);
        setB.add(5.0);

        ArrayList<Double> setS = new ArrayList<>();
        setS.add(1.0);
        setS.add(2.0);
        setS.add(3.0);
        setS.add(4.0);
        setS.add(5.0);
        setS.add(6.0);

        System.out.println("Union: " + SetOperations.union(setA, setB) + ", Expected: [1.0, 2.0, 3.0, 4.0, 5.0]");
        System.out.println("Intersection: " + SetOperations.intersect(setA, setB) + ", Expected: [3.0]");
        System.out.println("Complement of A: " + SetOperations.complement(setA, setS) + ", Expected: [4.0, 5.0, 6.0]");
    }
}


