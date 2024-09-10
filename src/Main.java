public class Main {
    public static void main(String[] args) {
        Cliente joca = new Cliente("joca");

        Conta cf = new Cofrinho(joca);
        Conta cc = new ContaCorrente(joca);
        Conta pp = new ContaPoupanca(joca);


        cc.depositar(100.18151635165);
        cf.depositarCofrinho(10);

        cc.imprimirExtrato();
        pp.imprimirExtrato();
        cf.imprimirExtrato();
    }
}
