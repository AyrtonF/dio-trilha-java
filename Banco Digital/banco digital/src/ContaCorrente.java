public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, Cliente cliente, double limiteChequeEspecial) {
        super(numero, cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        double saldoDisponivel = getSaldo() + limiteChequeEspecial;
        if (valor > 0 && valor <= saldoDisponivel) {
            super.sacar(valor);
        } else {
            System.out.println("Saldo insuficiente (incluindo cheque especial) ou valor de saque inválido.");
        }
    }
}