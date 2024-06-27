package approaches;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreeApproach implements IApproach {
    private long operationCount;

    @Override
    public Result calculate(int[][] coordinates) {
        operationCount = 0; 
        var numVertices = coordinates.length;
        var distanceMatrix = new int[numVertices][numVertices];
        calculateDistanceMatrix(coordinates, distanceMatrix);

        var minimumSpanningTree = findMinimumSpanningTree(distanceMatrix);
        var traversalOrder = performPreOrderTraversal(minimumSpanningTree, numVertices);

        var uniqueNodes = new LinkedHashSet<>(traversalOrder);
        var hamiltonianCycle = new int[uniqueNodes.size() + 1];
        var index = 0;
        for (var node : uniqueNodes) {
            hamiltonianCycle[index++] = node;
        }
        hamiltonianCycle[index] = hamiltonianCycle[0];

        var totalCost = calculateTourCost(hamiltonianCycle, distanceMatrix);

        return new Result(totalCost, hamiltonianCycle, operationCount); 
    }

    private List<Integer>[] findMinimumSpanningTree(int[][] matrix) {
        var numVertices = matrix.length;
        var visited = new boolean[numVertices];
        var pq = new PriorityQueue<Edge>(Comparator.comparingInt(Edge::getWeight));
        var minimumSpanningTree = initializeListArray(numVertices);

        visited[0] = true;
        for (var node = 1; node < numVertices; node++) {
            pq.add(new Edge(0, node, matrix[0][node]));
            operationCount++;
        }

        while (!pq.isEmpty()) {
            var currentEdge = pq.poll();
            operationCount++; 
            var u = currentEdge.getU();
            var v = currentEdge.getV();
            if (visited[v]) {
                continue;
            }
            minimumSpanningTree[u].add(v);
            minimumSpanningTree[v].add(u);
            visited[v] = true;
            for (var neighbor = 0; neighbor < numVertices; neighbor++) {
                if (!visited[neighbor]) {
                    var weight = matrix[v][neighbor];
                    pq.add(new Edge(v, neighbor, weight));
                    operationCount++; 
                }
            }
        }

        return minimumSpanningTree;
    }

    @SuppressWarnings("unchecked")
    private List<Integer>[] initializeListArray(int size) {
        var array = new List[size];
        for (var i = 0; i < size; i++) {
            array[i] = new ArrayList<>();
            operationCount++; 
        }
        return array;
    }

    private void calculateDistanceMatrix(int[][] coordinates, int[][] matrix) {
        var numVertices = coordinates.length;
        for (var row = 0; row < numVertices; row++) {
            for (var col = row + 1; col < numVertices; col++) {
                var dist = calculateEuclideanDistance(coordinates[row], coordinates[col]);
                matrix[row][col] = dist;
                matrix[col][row] = dist;
                operationCount++;
            }
        }
    }

    private int calculateEuclideanDistance(int[] coord1, int[] coord2) {
        var dx = coord1[0] - coord2[0];
        var dy = coord1[1] - coord2[1];
        operationCount++;
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy));
    }

    private List<Integer> performPreOrderTraversal(List<Integer>[] mst, int numVertices) {
        var traversal = new ArrayList<Integer>();
        var visited = new boolean[numVertices];
        performPreOrderTraversalUtil(0, visited, traversal, mst);
        return traversal;
    }

    private void performPreOrderTraversalUtil(int node, boolean[] visited, List<Integer> traversal, List<Integer>[] mst) {
        visited[node] = true;
        traversal.add(node);
        operationCount++; 
        for (var neighbor : mst[node]) {
            if (!visited[neighbor]) {
                performPreOrderTraversalUtil(neighbor, visited, traversal, mst);
                operationCount++;
            }
        }
    }

    private int calculateTourCost(int[] tour, int[][] matrix) {
        var cost = 0;
        var numVertices = tour.length;
        for (var i = 0; i < numVertices - 1; i++) {
            cost += matrix[tour[i]][tour[i + 1]];
            operationCount++; 
        }
        return cost;
    }
}
