import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaEspera = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== Lista de Espera do Restaurante ===");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Remover cliente");
            System.out.println("3 - Exibir lista de espera");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();
                    listaEspera.add(cliente);
                    System.out.println(cliente + " foi adicionado à lista de espera.");
                    break;
                case 2:
                    System.out.print("Digite o nome do cliente a remover: ");
                    String nomeRemover = scanner.nextLine();
                    if (listaEspera.remove(nomeRemover)) {
                        System.out.println(nomeRemover + " foi removido da lista.");
                    } else {
                        System.out.println("Cliente não encontrado na lista.");
                    }
                    break;
                case 3:
                    System.out.println("\nLista atual de espera:");
                    if (listaEspera.isEmpty()) {
                        System.out.println("Nenhum cliente na lista.");
                    } else {
                        for (String nome : listaEspera) {
                            System.out.println("- " + nome);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
