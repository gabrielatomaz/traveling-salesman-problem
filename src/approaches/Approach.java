package approaches;

import utils.MatrixUtils;

public class Approach {
    private IApproach approach;
    public Approach(int approachId) {
        approach = approachId == 1 ? new MinimumSpanningTreeApproach() : new BruteForceApproach();
    }

    public void apply(String file) {
        System.out.println();
        System.out.println(file);

        var matrix = MatrixUtils.readAdjacencyMatrix(file);

        var startTime = System.nanoTime();
        var result = approach.calculate(matrix);
        var endTime = System.nanoTime();

        result.print();
        var total = (double) (endTime - startTime) / 1_000_000_000;
        System.out.printf("Tempo em segundos: %.6f%n", total);
    }
}
