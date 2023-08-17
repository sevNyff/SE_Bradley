package ch.fhnw.richards.Week_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DepthFirst_AdjacencyList {
    private static final Map<Character, char[]> adjList = new HashMap<>();

    public static void main(String[] args) {
        initMapData();
        ArrayList<Character> path = depthFirst(adjList, 'B', 'G');
        printPath(path);
    }

    private static void initMapData() {
        adjList.put('A', new char[]{'B'});
        adjList.put('B', new char[]{'A','C','D'});
        adjList.put('C', new char[]{'B'});
        adjList.put('D', new char[]{'B','E'});
        adjList.put('E', new char[]{'D','F','G'});
        adjList.put('F', new char[]{'E','H'});
        adjList.put('G', new char[]{'E','H'});
        adjList.put('H', new char[]{'F','G'});
    }

    private static void printPath(ArrayList<Character> path) {
        System.out.print("Final solution: ");
        for (char node : path) System.out.printf("%c ", node);
        System.out.println();
    }

    private static ArrayList<Character> depthFirst(char start, char end) {
        ArrayList<Character> path = new ArrayList<>();

        // Search using a recursive method
        return depthFirstRecursive(path, start, end);
    }

    private static ArrayList<char[]> depthFirstRecursive(ArrayList<Character> path, char current, char end) {
        if (current == end) { // Base case - we are finished!
            // Nothing to do...
        } else { // Recursive case - add an edge to the path
            for (char[] edge : edges) {
                if (edge[0] == current && !haveNotBeenThere(path, edge[1])) {
                    path.add(edge);
                    depthFirstRecursive(path, edge[1], end);
                    // If we have a solution, stop the loop!
                    if (path.get(path.size() - 1)[1] == end) break;

                    // If we are here, remove the last node from the path, so we can add a different one
                    path.remove(path.size() - 1);
                }
            }
        }
        return path;
    }
}
