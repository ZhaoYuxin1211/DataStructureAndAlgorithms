package practice.yuxinzhao.algorithms.greedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Implementation of a Greedy Algorithm for solving the Set Cover Problem.
 * The goal is to find the minimum number of broadcasts needed to cover all areas.
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        // Define the broadcasts and their coverage areas
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> set1 = new HashSet<>();
        set1.add("Dublin");
        set1.add("Cork");
        set1.add("Galway");

        HashSet<String> set2 = new HashSet<>();
        set2.add("Limerick");
        set2.add("Dublin");
        set2.add("Sligo");

        HashSet<String> set3 = new HashSet<>();
        set3.add("Belfast");
        set3.add("Cork");
        set3.add("Bray");

        HashSet<String> set4 = new HashSet<>();
        set4.add("Cork");
        set4.add("Galway");

        HashSet<String> set5 = new HashSet<>();
        set5.add("Bray");
        set5.add("Waterford");

        broadcasts.put("K1", set1);
        broadcasts.put("K2", set2);
        broadcasts.put("K3", set3);
        broadcasts.put("K4", set4);
        broadcasts.put("K5", set5);

        // Create a set of all areas that need to be covered
        HashSet<String> allAreas = new HashSet<>();
        allAreas.addAll(set1);
        allAreas.addAll(set2);
        allAreas.addAll(set3);
        allAreas.addAll(set4);
        allAreas.addAll(set5);

        // Initialize the list to store selected broadcasts
        ArrayList<String> selects = new ArrayList<>();

        // Temporary set to store the areas covered by each broadcast
        HashSet<String> tempArea = new HashSet<>();

        String maxKey;

        // Greedy algorithm loop: Select the broadcast with the maximum uncovered areas until all areas are covered
        while (!allAreas.isEmpty()) {
            maxKey = null;

            // Iterate through each broadcast and find the one with the maximum uncovered areas
            for (String key : broadcasts.keySet()) {
                tempArea.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempArea.addAll(areas);
                tempArea.retainAll(allAreas);

                // Compare with the current maximum and update if needed
                if (!tempArea.isEmpty() && (maxKey == null || tempArea.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            // Add the selected broadcast to the list and remove its covered areas from the set of all areas
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        // Print the result
        System.out.println("Result: " + selects);
    }
}

