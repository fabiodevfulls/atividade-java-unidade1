import java.util.*;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> pedidos = new ArrayList<>();

        System.out.println("Digite os códigos dos pedidos (digite -1 para encerrar):");

        while (true) {
            int codigo = scanner.nextInt();
            if (codigo == -1) break;
            pedidos.add(codigo);
        }

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido foi registrado.");
            return;
        }

        // Contar a frequência de cada código
        HashMap<Integer, Integer> frequencia = new HashMap<>();
        for (int codigo : pedidos) {
            frequencia.put(codigo, frequencia.getOrDefault(codigo, 0) + 1);
        }

        // Encontrar o código mais pedido
        int maisPedido = -1;
        int maiorFrequencia = 0;

        for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > maiorFrequencia) {
                maiorFrequencia = entry.getValue();
                maisPedido = entry.getKey();
            }
        }

        System.out.println("O item mais pedido foi o código " + maisPedido +
                " (pedido " + maiorFrequencia + " vezes).");

        scanner.close();
    }
}
