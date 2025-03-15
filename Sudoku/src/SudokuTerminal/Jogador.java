package SudokuTerminal;

import java.util.Scanner;

public class Jogador {
    private Scanner scanner;

    public Jogador() {
        scanner = new Scanner(System.in);
    }

    public int[] obterJogada() {
        System.out.print("Digite a linha (1-9): ");
        int linha = scanner.nextInt() - 1;
        System.out.print("Digite a coluna (1-9): ");
        int coluna = scanner.nextInt() - 1;
        System.out.print("Digite o valor (1-9): ");
        int valor = scanner.nextInt();
        return new int[]{linha, coluna, valor};
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}