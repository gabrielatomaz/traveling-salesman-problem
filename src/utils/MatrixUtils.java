package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class MatrixUtils {
    public static int[][] readAdjacencyMatrix(String file) {
        var filepath = "./src/matrices/tsp" + file + ".txt";
        try {
            var matrixList = new ArrayList<int[]>();
            var reader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {
                var row = Arrays.stream(line.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                matrixList.add(row);
            }
            reader.close();
            var matrix = new int[matrixList.size()][];
            for (int i = 0; i < matrixList.size(); i++) {
                matrix[i] = matrixList.get(i);
            }
            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
