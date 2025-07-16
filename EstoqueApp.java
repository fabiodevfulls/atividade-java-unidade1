import java.util.ArrayList;
import java.util.Scanner;

public class EstoqueApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> estoque = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== Sistema de Gerenciamento de Estoque ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    estoque.add(new Produto(nome, quantidade, preco));
                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    System.out.print("Digite o nome do produto para remover: ");
                    String nomeRemover = scanner.nextLine();
                    boolean removido = estoque.removeIf(p -> p.getNome().equalsIgnoreCase(nomeRemover));
                    System.out.println(removido ? "Produto removido!" : "Produto não encontrado.");
                    break;

                case 3:
                    System.out.print("Digite o nome do produto para atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    Produto produtoEncontrado = null;
                    for (Produto p : estoque) {
                        if (p.getNome().equalsIgnoreCase(nomeAtualizar)) {
                            produtoEncontrado = p;
                            break;
                        }
                    }
                    if (produtoEncontrado != null) {
                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = scanner.nextInt();
                        System.out.print("Novo preço: ");
                        double novoPreco = scanner.nextDouble();
                        produtoEncontrado.setQuantidade(novaQuantidade);
                        produtoEncontrado.setPreco(novoPreco);
                        System.out.println("Produto atualizado!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    if (estoque.isEmpty()) {
                        System.out.println("Nenhum produto no estoque.");
                    } else {
                        System.out.println("\n--- Lista de Produtos ---");
                        for (Produto p : estoque) {
                            System.out.println(p);
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

