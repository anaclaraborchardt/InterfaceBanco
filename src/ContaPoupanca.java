public class ContaPoupanca extends ContaBancaria {

    private double limite;

    public ContaPoupanca(int numeroConta, double saldo, double limite) {

        super(numeroConta, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        double saldo = this.getSaldo() - valor;
        if(saldo - valor < 0) {
            if (saldo > limite) {
                this.setSaldo(this.getSaldo() - valor);
            }
        }

    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public String mostrarDados() {
        return "Conta Poupança" +
                "\nSaldo:  " + this.getSaldo() +
                "\nNúmero da conta: " + this.getNumeroConta() +
                "\nLimite: " + this.getLimite();
    }

    public double getLimite() {
        return limite;
    }
}
