import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta " + conta.getNumero() + " adicionada ao banco.");
    }

    public void listarContas() {
        System.out.println("Contas do banco " + nome + ":");
        for (Conta conta : contas) {
            System.out.println("Número: " + conta.getNumero() + ", Saldo: " + conta.getSaldo());
        }
    }
}