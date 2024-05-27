import java.util.HashSet;
import java.util.Set;

public class Unions {
    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add elements to set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        // Add elements to set2
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        // Perform union operation
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Union of set1 and set2: " + unionSet);

        // Perform intersection operation
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Intersection of set1 and set2: " + intersectionSet);

        // Perform difference operation (set1 - set2)
        Set<Integer> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        System.out.println("Difference of set1 and set2 (set1 - set2): " + differenceSet);

        // Perform difference operation (set2 - set1)
        Set<Integer> differenceSet2 = new HashSet<>(set2);
        differenceSet2.removeAll(set1);
        System.out.println("Difference of set2 and set1 (set2 - set1): " + differenceSet2);
    }
}
