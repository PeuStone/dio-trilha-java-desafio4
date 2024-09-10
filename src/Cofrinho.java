public class Cofrinho extends Conta {

        public Cofrinho(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("==== Extrato Cofrinho ====");
        System.out.println(String.format("Rendimento final: %.2f", this.saldoCofrinho));
    }
}
