import java.util.ArrayList;
import java.util.Scanner;

public class OrdenacaoProdutos {

    static class Produto {
        String nome;
        int vendas;

        Produto(String nome, int vendas) {
            this.nome = nome;
            this.vendas = vendas;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        System.out.println("Digite os produtos e suas vendas (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) break;

            System.out.print("Quantidade de vendas: ");
            int vendas = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            produtos.add(new Produto(nome, vendas));
        }

        quickSort(produtos, 0, produtos.size() - 1);

        System.out.println("\nProdutos ordenados por vendas (decrescente):");
        for (Produto p : produtos) {
            System.out.println(p.nome + " - " + p.vendas + " vendas");
        }

        scanner.close();
    }

    // Quick Sort - ordem decrescente
    public static void quickSort(ArrayList<Produto> lista, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(lista, inicio, fim);
            quickSort(lista, inicio, indicePivo - 1);
            quickSort(lista, indicePivo + 1, fim);
        }
    }

    public static int particionar(ArrayList<Produto> lista, int inicio, int fim) {
        Produto pivo = lista.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (lista.get(j).vendas >= pivo.vendas) { // Maior vai antes (ordem decrescente)
                i++;
                Produto temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        Produto temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fim));
        lista.set(fim, temp);

        return i + 1;
    }
}
