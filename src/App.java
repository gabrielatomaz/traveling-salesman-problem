import java.util.List;
import java.util.Scanner;

import approaches.Approach;

public class App {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.println("Qual approach você quer rodar primeiro?\n");
            System.out.println("1 - Arvore de Extensao Minima\n");
            System.out.println("2 - Força Bruta\n");
            var approachId = scanner.nextInt();
            var approach = new Approach(approachId);
            List.of("1_253", "2_1248", "3_1194", "4_7013", "5_27603")
                    .forEach(approach::apply);
        }
    }
}