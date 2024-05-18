package lvl3;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class SetUtils {
    public static <T> Set<T> union(LinkedList<T> set1, LinkedList<T> set2) {
        Set<T> unionSet = new TreeSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public static <T> Set<T> intersect(LinkedList<T> set1, LinkedList<T> set2) {
        Set<T> intersectSet = new TreeSet<>(set1);
        intersectSet.retainAll(set2);
        return intersectSet;
    }
}
