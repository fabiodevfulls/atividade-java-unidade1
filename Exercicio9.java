import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> clientes = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== Cadastro de Clientes ===");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // limpa o buffer
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    Pessoa novaPessoa = new Pessoa(nome, idade, endereco);
                    clientes.add(novaPessoa);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("\nLista de Clientes:");
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Pessoa p : clientes) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
