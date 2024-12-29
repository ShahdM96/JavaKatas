package katas.exercises;

import java.util.*;

public class ValidGitTree {

    /**
     * Determines if a given tree structure represents a valid Git tree.
     *
     * A valid Git tree should:
     * 1. Have exactly one root (no parent).
     * 2. Contain no cycles.
     *
     * @param treeMap a map representing the Git tree (commit ID to list of child commit IDs)
     * @return true if the tree is a valid Git tree, false otherwise
     */
    public static boolean isValidGitTree(Map<String, List<String>> treeMap) {
        if (treeMap == null || treeMap.isEmpty()) {
            return false; // A valid Git tree cannot be empty or null
        }

        Map<String, Integer> inDegree = new HashMap<>();
        for (String node : treeMap.keySet()) {
            inDegree.put(node, 0);
        }

        for (List<String> children : treeMap.values()) {
            for (String child : children) {
                inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            }
        }

        List<String> roots = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                roots.add(entry.getKey());
            }
        }

        // A valid Git tree must have exactly one root
        if (roots.size() != 1) {
            return false;
        }
        String root = roots.get(0);

        Set<String> visited = new HashSet<>();
        if (!dfs(root, treeMap, visited, new HashSet<>())) {
            return false; // Cycle detected
        }

        return visited.size() == treeMap.size();

    }
    private static boolean dfs(String node, Map<String, List<String>> treeMap, Set<String> visited, Set<String> currentStack) {
        if (visited.contains(node)) {
            return true; // Already visited, no cycle here
        }

        if (currentStack.contains(node)) {
            return false; // Cycle detected
        }

        currentStack.add(node);
        visited.add(node);

        if (treeMap.containsKey(node)) {
            for (String child : treeMap.get(node)) {
                if (!dfs(child, treeMap, visited, currentStack)) {
                    return false;
                }
            }
        }

        currentStack.remove(node);
        return true;
    }
    public static void main(String[] args) {
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        System.out.println("Is valid tree: " + isValidGitTree(validTree));
        System.out.println("Is valid tree: " + isValidGitTree(invalidTree));
    }
}

