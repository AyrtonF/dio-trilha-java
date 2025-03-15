package SudokuTerminal;

public class Validador {
    private Tabuleiro tabuleiro;

    public Validador(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean isJogadaValida(int linha, int coluna, int valor) {
        return !existeNaLinha(linha, valor) &&
               !existeNaColuna(coluna, valor) &&
               !existeNoBloco(linha, coluna, valor);
    }

    private boolean existeNaLinha(int linha, int valor) {
        for (int i = 0; i < 9; i++) {
            if (tabuleiro.getCelula(linha, i) == valor) {
                return true;
            }
        }
        return false;
    }

    private boolean existeNaColuna(int coluna, int valor) {
        for (int i = 0; i < 9; i++) {
            if (tabuleiro.getCelula(i, coluna) == valor) {
                return true;
            }
        }
        return false;
    }

    private boolean existeNoBloco(int linha, int coluna, int valor) {
        int blocoLinha = linha - linha % 3;
        int blocoColuna = coluna - coluna % 3;

        for (int i = blocoLinha; i < blocoLinha + 3; i++) {
            for (int j = blocoColuna; j < blocoColuna + 3; j++) {
                if (tabuleiro.getCelula(i, j) == valor) {
                    return true;
                }
            }
        }
        return false;
    }
}