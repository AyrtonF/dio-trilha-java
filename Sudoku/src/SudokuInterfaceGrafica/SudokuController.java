package SudokuInterfaceGrafica;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuController {
    @FXML
    private GridPane tabuleiroGrid;

    private TextField[][] celulas = new TextField[9][9];
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Validador validador = new Validador(tabuleiro);

    @FXML
    public void initialize() {
        // Inicializa o tabuleiro gráfico
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = new TextField();
                textField.setPrefWidth(40);
                textField.setPrefHeight(40);
                textField.setStyle("-fx-font-size: 16; -fx-alignment: center;");

                int linha = i;
                int coluna = j;
                textField.textProperty().addListener((obs, oldValue, newValue) -> {
                    if (!newValue.matches("[1-9]?")) {
                        textField.setText(oldValue); // Aceita apenas números de 1 a 9
                    } else if (!newValue.isEmpty()) {
                        int valor = Integer.parseInt(newValue);
                        if (validador.isJogadaValida(linha, coluna, valor)) {
                            tabuleiro.setCelula(linha, coluna, valor);
                        } else {
                            textField.setText(""); // Limpa se a jogada for inválida
                        }
                    }
                });

                celulas[i][j] = textField;
                tabuleiroGrid.add(textField, j, i);
            }
        }

        // Preenche o tabuleiro com valores iniciais
        tabuleiro.inicializarTabuleiro();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int valor = tabuleiro.getCelula(i, j);
                if (valor != 0) {
                    celulas[i][j].setText(String.valueOf(valor));
                    celulas[i][j].setDisable(true); // Bloqueia células preenchidas
                }
            }
        }
    }

    @FXML
    public void verificarTabuleiro() {
        if (tabuleiro.isCompleto()) {
            System.out.println("Parabéns! Você completou o Sudoku!");
        } else {
            System.out.println("Ainda há células vazias ou incorretas.");
        }
    }
}