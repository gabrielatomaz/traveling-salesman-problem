package approaches;

import java.util.Arrays;

public class Result {
    private int cost;
    private int[] tour;
    private long operationCount; 

    public Result(int cost, int[] tour, long operationCount) {
        this.cost = cost;
        this.tour = tour;
        this.operationCount = operationCount; 
    }

    public int getCost() {
        return cost;
    }

    public int[] getTour() {
        return tour;
    }

    public long getOperationCount() {
        return operationCount;
    }

    public void print() {
        System.out.println("Custo: " + this.cost);
        System.out.println("Rota: " + Arrays.toString(this.tour));
        System.out.println("Total de operaçoes: " + this.operationCount); 
    }
}
