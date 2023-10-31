import java.util.ArrayList;

/**
 * Set theory operations on ArrayLists
 *
 * @author Ivan Wang
 */
public class SetOperations {

    /**
     * Computes the union of two sets.
     *
     * @param A the first set.
     * @param B the second set.
     * @return a new set that contains all the elements from both A and B.
     */
    public static ArrayList<Double> union(ArrayList<Double> A, ArrayList<Double> B){
        ArrayList<Double> ret = new ArrayList<>();

        for (int i = 0; i < A.size(); i++){
            if (!ret.contains(A.get(i)))
                ret.add(A.get(i));
        }
        for (int j = 0; j < B.size(); j++) {
            if (!ret.contains(B.get(j)))
                ret.add(B.get(j));
        }
        return ret;
    }

    /**
     * Computes the intersection of two sets.
     *
     * @param A the first set.
     * @param B the second set.
     * @return a new set that contains all the elements that exist in both A and B.
     */
    public static ArrayList<Double> intersect(ArrayList<Double> A, ArrayList<Double> B){
        ArrayList<Double> ret = new ArrayList<>();

        for (int i = 0; i < A.size(); i++){
            if (B.contains(A.get(i)) && !ret.contains(A.get(i)))
                ret.add(A.get(i));
        }
        return ret;
    }

    /**
     * Computes the complement of set A.
     *
     * @param A the set whose complement is to be found.
     * @param set the universal set.
     * @return a new set that contains all the elements from the universal set that are not in set A.
     */
    public static ArrayList<Double> complement(ArrayList<Double> A, ArrayList<Double> set) {
        ArrayList<Double> ret = new ArrayList<>();

        for (int i = 0; i < set.size(); i++){
            if (!A.contains(set.get(i)))
                ret.add(set.get(i));
        }

        return ret;
    }


}
