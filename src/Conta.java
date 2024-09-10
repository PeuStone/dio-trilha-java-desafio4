public abstract class Conta implements IConta {

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected double saldoCofrinho;

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            throw new RuntimeException("A conta não possui saldo suficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            throw new RuntimeException("Impossível realizar deposito com esse valor");
        }
    }

    @Override
    public void transferir(IConta contaDestino, double valor) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            throw new RuntimeException("A conta não possui saldo suficiente");
        }
    }

    public void depositarCofrinho(double valor) {
        if (valor > 0) {
            double juros = 0.0083;
            double rendimento = 0;
            for (int n = 1; n <= 12; n++) {
                rendimento = valor * juros;
                valor += rendimento;
                rendimento = 0;
            }
            saldoCofrinho = valor;
        } else {
            throw new RuntimeException("Valor de deposito insuficiente");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfoComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.printf(String.format("Conta: %d%n", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
