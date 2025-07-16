import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos alunos fizeram a prova? ");
        int quantidadeAlunos = scanner.nextInt();

        float[] notas = new float[quantidadeAlunos];
        float maiorNota = Float.MIN_VALUE;

        // Leitura das notas
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextFloat();

            // Verifica se é a maior nota até o momento
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }

        System.out.println("\nMaior nota da turma: " + maiorNota);
        scanner.close();
    }
}
