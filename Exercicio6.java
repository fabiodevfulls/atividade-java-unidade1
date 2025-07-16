public class Exercicio6 {
    public static void main(String[] args) {
        System.out.println("Números primos entre 1 e 100:");

        for (int i = 2; i <= 100; i++) {
            if (ehPrimo(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Função para verificar se um número é primo
    public static boolean ehPrimo(int numero) {
        if (numero <= 1) return false;

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
