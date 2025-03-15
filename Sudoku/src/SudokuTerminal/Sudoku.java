package SudokuTerminal;

public class Sudoku {
    private Tabuleiro tabuleiro;
    private Validador validador;
    private Jogador jogador;

    public Sudoku() {
        tabuleiro = new Tabuleiro();
        validador = new Validador(tabuleiro);
        jogador = new Jogador();
    }

    public void iniciar() {
        tabuleiro.inicializarTabuleiro();
        while (true) {
            tabuleiro.exibirTabuleiro();
            int[] jogada = jogador.obterJogada();
            int linha = jogada[0];
            int coluna = jogada[1];
            int valor = jogada[2];

            if (tabuleiro.isCelulaVazia(linha, coluna)) {
                if (validador.isJogadaValida(linha, coluna, valor)) {
                    tabuleiro.setCelula(linha, coluna, valor);
                    jogador.exibirMensagem("Jogada válida!");
                } else {
                    jogador.exibirMensagem("Jogada inválida. Tente novamente.");
                }
            } else {
                jogador.exibirMensagem("Célula já preenchida. Tente novamente.");
            }
        }
    }

    public static void main(String[] args) {
        Sudoku jogo = new Sudoku();
        jogo.iniciar();
    }
}