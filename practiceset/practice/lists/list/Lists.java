import java.util.*;
public class Lists {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("Apple");
        System.out.println("Initial List1: " + list1);
        list1.set(0, "Blueberry");  // Replaces "Banana" with "Blueberry"
        list1.remove(0);  // Removes "Zulu"
        System.out.println("lsit1 after removal: " + list1);
        list1.add("Apple");
        list2.addAll(list1);
        System.out.println("List2 after merging with List1: " + list2);
    }
}