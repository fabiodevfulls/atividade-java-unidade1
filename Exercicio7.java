import java.util.Scanner;

public class Exercicio7 {
    static char[][] tabuleiro = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char jogadorAtual = 'X';
        int jogadas = 0;

        while (true) {
            imprimirTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", é sua vez.");
            System.out.print("Digite a linha (0, 1 ou 2): ");
            int linha = scanner.nextInt();
            System.out.print("Digite a coluna (0, 1 ou 2): ");
            int coluna = scanner.nextInt();

            // Verifica se posição é válida
            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ') {
                System.out.println("Jogada inválida! Tente novamente.");
                continue;
            }

            tabuleiro[linha][coluna] = jogadorAtual;
            jogadas++;

            // Verifica se houve vitória
            if (verificarVitoria(jogadorAtual)) {
                imprimirTabuleiro();
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }

            // Verifica empate
            if (jogadas == 9) {
                imprimirTabuleiro();
                System.out.println("Empate!");
                break;
            }

            // Alterna jogador
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    // Função para exibir o tabuleiro
    public static void imprimirTabuleiro() {
        System.out.println("\nTabuleiro:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tabuleiro[i][0] + " | " + tabuleiro[i][1] + " | " + tabuleiro[i][2]);
            if (i < 2) System.out.println("---|---|---");
        }
        System.out.println();
    }

    // Função para verificar se o jogador venceu
    public static boolean verificarVitoria(char jogador) {
        // Linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }

        // Diagonais
        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
            (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;
        }

        return false;
    }
}
