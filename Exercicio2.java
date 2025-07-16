import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do código do produto
        System.out.print("Digite o código do produto: ");
        int codigoProduto = scanner.nextInt();

        // Verificação se é par ou ímpar
        if (codigoProduto % 2 == 0) {
            System.out.println("O código do produto é PAR.");
        } else {
            System.out.println("O código do produto é ÍMPAR.");
        }

        scanner.close();
    }
}
