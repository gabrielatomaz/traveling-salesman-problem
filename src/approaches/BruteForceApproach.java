package approaches;

public class BruteForceApproach implements IApproach {
    private static int minRouteCost;
    private static int[] minCostRoute;
    private static long operationCount;

    @Override
    public Result calculate(int[][] adjacencyMatrix) {
        int numVertices = adjacencyMatrix.length;
        minRouteCost = Integer.MAX_VALUE;
        minCostRoute = new int[numVertices + 1];
        operationCount = 0;

        int[] allVertices = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            allVertices[i] = i;
        }

        generateAllCombinations(numVertices, adjacencyMatrix, allVertices, 0);
        return new Result(minRouteCost, minCostRoute, operationCount); 
    }

    private static void generateAllCombinations(int numVertices, int[][] matrix, int[] allVertices, int startVertex) {
        if (startVertex == numVertices - 1) {
            int currentRouteCost = calculateCost(numVertices, allVertices, matrix);
            if (currentRouteCost < minRouteCost) {
                minRouteCost = currentRouteCost;
                System.arraycopy(allVertices, 0, minCostRoute, 0, numVertices);
                minCostRoute[numVertices] = allVertices[0];
            }
        } else {
            for (int i = startVertex; i < numVertices; i++) {
                swap(allVertices, i, startVertex);
                generateAllCombinations(numVertices, matrix, allVertices, startVertex + 1);
                swap(allVertices, i, startVertex);
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static int calculateCost(int numVertices, int[] allVertices, int[][] matrix) {
        int totalCost = 0;
        for (int i = 0; i < numVertices - 1; i++) {
            totalCost += matrix[allVertices[i]][allVertices[i + 1]];
            operationCount++;
        }
        totalCost += matrix[allVertices[numVertices - 1]][allVertices[0]];
        operationCount++;
        return totalCost;
    }
}
