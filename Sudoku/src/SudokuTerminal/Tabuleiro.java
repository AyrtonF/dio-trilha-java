package SudokuTerminal;

public class Tabuleiro {
    private int[][] tabuleiro;

    public Tabuleiro() {
        tabuleiro = new int[9][9];
    }

    public void inicializarTabuleiro() {
        // Exemplo de tabuleiro inicial (pode ser gerado dinamicamente)
        int[][] exemplo = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        tabuleiro = exemplo;
    }

    public void exibirTabuleiro() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tabuleiro[i][j] + " ");
                if ((j + 1) % 3 == 0 && j != 8) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i != 8) {
                System.out.println("---------------------");
            }
        }
    }

    public boolean isCelulaVazia(int linha, int coluna) {
        return tabuleiro[linha][coluna] == 0;
    }

    public void setCelula(int linha, int coluna, int valor) {
        tabuleiro[linha][coluna] = valor;
    }

    public int getCelula(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }
}