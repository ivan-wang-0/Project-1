import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * A library of statistic methods
 *
 * @author Ivan Wang
 */
public class StatsLibrary {

    // Chapter 1
    /**
     * Calculate the mean of a list of numbers.
     * @param list the list of numbers.
     * @return the mean.
     */
    public static double getMean(ArrayList<Double> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        return (sum / list.size());
    }

    /**
     * Calculate the median of a list of numbers.
     * @param list the list of numbers
     * @return the median.
     */
    public static double getMedian(ArrayList<Double> list){
        list.sort(Comparator.naturalOrder());
         if (list.size() % 2 == 0)
             return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
         else
             return list.get(list.size() / 2);
    }

    /**
     * Calculate the mode of a list of numbers.
     * @param list the list of numbers.
     * @return the mode, or -1 if no unique mode exists.
     */
    public static double getMode(ArrayList<Double> list){
        int maxCount = 0;
        double mode = -1;

        for (int i = 0; i < list.size(); i++){
            double val = list.get(i);
            int count = 0;
            for (int j = 0; j < list.size(); j++){
                if (list.get(j).equals(val))
                    count++;
            }

            if (count > maxCount){
                maxCount = count;
                mode = val;
            } else if (count == maxCount && list.get(i) != mode) {
                mode = -1;
            }
        }

        return mode;
    }

    /**
     * Calculate the variance of a list of numbers.
     * @param list the list of numbers.
     * @return the variance.
     */
    public static double variance(ArrayList<Double> list){
        double mean = getMean(list);
        double sum = 0;
        for(double i: list){
            sum = sum + Math.pow(i - mean, 2);
        }
        return sum / list.size();
    }

    /**
     * Calculate the standard deviation of a list of numbers.
     * @param list the list of numbers.
     * @return the standard deviation.
     */
    public static double standardDeviation(ArrayList<Double> list){
        return Math.sqrt(variance(list));
    }


    // Chapter 2

    /**
     * Calculate factorial of a number.
     * @param n the number.
     * @return the factorial of n.
     * @throws IllegalArgumentException if n is negative or greater than 100.
     */
    public static BigInteger factorial (int n){
        BigInteger sum = BigInteger.valueOf(1);

        if (n < 0){
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n > 100){
            throw new IllegalArgumentException("Value of n is too large");
        }
        for(int i = 1; i <= n; i++){
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }

    /**
     * Calculate permutation.
     * @param n total number of items.
     * @param r number of items to choose.
     * @return the number of permutations.
     */
    public static BigInteger permutation(int n, int r){
        return ((factorial(n)).divide((factorial(n-r))));
    }

    /**
     * Calculate combination.
     * @param n total number of items.
     * @param r number of items to choose.
     * @return the number of combinations.
     */
    public static BigInteger combination(int n, int r){
        return ((factorial(n)).divide(factorial(n-r).multiply(factorial(r)))) ;
    }

    //
    /**
     * Calculate the conditional probability of two events.
     * @param pAandB the probability of both events A and B occurring.
     * @param pB the probability of event B occurring.
     * @return the conditional probability P(A|B).
     */
    public static double conditionalProbability(double pAandB, double pB){
        return pAandB / pB;
    }

    /**
     * Apply Bayes' theorem to calculate the probability of an event.
     * @param pBifA the probability of event B given event A.
     * @param pA the probability of event A.
     * @param pB the probability of event B.
     * @return the probability P(A|B).
     */
    public static double bayes(double pBifA, double pA, double pB){
        return (pBifA * pA) / pB;
    }

    /**
     * Determine if two events are independent.
     * @param pA the probability of event A.
     * @param pB the probability of event B.
     * @param pAandB the probability of both events A and B occurring.
     * @return true if the events are independent, otherwise false.
     */
    public static boolean isIndependent(double pA, double pB, double pAandB) {
        return pA * pB == pAandB;
    }


    // Chapter 3

    /**
     * Calculates binomial distribution.
     *
     * @param n total number of trials.
     * @param y number of successes.
     * @param p probability of success on a single trial.
     * @return the probability of exactly y successes in n trials.
     */
    public static double binomialDist(int n, int y, double p){
        return(combination(n,y).intValue() * Math.pow(p,y) * Math.pow(1 - p,n - y));
    }

    /**
     * Calculates geometric distribution.
     *
     * @param p probability of success on a single trial.
     * @param y number of trials needed to get the first success.
     * @return the probability that the first success will occur on the yth trial.
     */
    public static double geometricDist(double p, int y){
        return (Math.pow(1 - p, y - 1) * p);
    }

    /**
     * Calculates hypergeometric distribution.
     *
     * @param N total number of items in the population.
     * @param n number of items selected without replacement.
     * @param r number of success states in the population.
     * @param y number of success states in the selection.
     * @return the probability of getting exactly y successes from the selection.
     * @throws IllegalArgumentException if any parameters are zero
     */
    public static double hyperGeoDist(int N, int n, int r, int y){
        if (N == 0 || n == 0 || r == 0 || y == 0){
            throw new IllegalArgumentException("parameters should not be zero");
        }
        else{
            BigInteger top = combination(r,y).multiply(combination(N-r, n-y));
            BigInteger bottom = combination(N,n);
            return (top.doubleValue() / bottom.doubleValue());
        }
    }

    /**
     * Calculates negative binomial distribution.
     *
     * @param r number of successes.
     * @param y number of trials needed to get r successes.
     * @param p probability of success on a single trial.
     * @return the probability of the rth success occurring on the yth trial.
     */
    public static double negativeBinomialDist(int r, int y, double p){
        return (combination(y - 1,r - 1).intValue() * Math.pow(p,r) * (Math.pow(1 - p, y - r)));
    }

    /**
     * Calculates the Poisson distribution.
     *
     * @param lambda expected number of occurrences in a fixed interval.
     * @param y actual number of successes that occurred in a fixed interval.
     * @return the probability of observing y successes.
     */
    public static double poisson(int lambda, int y){
        return ((Math.pow(lambda,y) * Math.pow(Math.exp(1),Math.negateExact(lambda))) / factorial(y).intValue());
    }

    /**
     * Computes the Chebyshev inequality.
     *
     * @param leftRange  the left bound of the range.
     * @param rightRange the right bound of the range.
     * @param mean the mean of the distribution.
     * @param std the standard deviation of the distribution.
     * @return the result of the Chebyshev inequality.
     */
    public static double chebeyshev(double leftRange, double rightRange, double mean, double std){
        double k = findKValue(leftRange, rightRange, mean, std);
        return (1 - (1 / (Math.pow(k,2))));
    }

    /**
     * Helper method to compute the k-value used in the Chebyshev inequality.
     *
     * @param leftRange  the left bound of the range.
     * @param rightRange the right bound of the range.
     * @param mean the mean of the distribution.
     * @param std the standard deviation of the distribution.
     * @return the k-value.
     */
    public static double findKValue(double leftRange, double rightRange, double mean, double std){
        double leftDistance = Math.abs(leftRange - mean);
        double rightDistance = Math.abs(rightRange - mean);
        return Math.max(leftDistance, rightDistance) / std;

    }

}

