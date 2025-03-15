public class App {
    public static void main(String[] args) throws Exception {
         
         Cliente cliente1 = new Cliente("João Silva", "123.456.789-00");
         Cliente cliente2 = new Cliente("Maria Souza", "987.654.321-00");
 
         ContaCorrente cc = new ContaCorrente("001", cliente1, 1000.0);
         ContaPoupanca cp = new ContaPoupanca("002", cliente2, 0.01);
 
         cc.depositar(500.0);
         cc.sacar(200.0);
         cc.transferir(100.0, cp);
 
         cp.aplicarRendimento();
 
         Banco banco = new Banco("Banco Digital");
         banco.adicionarConta(cc);
         banco.adicionarConta(cp);
         banco.listarContas();
    }
}
