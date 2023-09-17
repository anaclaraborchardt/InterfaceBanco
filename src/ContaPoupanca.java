public class ContaPoupanca extends ContaBancaria {

    private double limite;

    public ContaPoupanca(int numeroConta, double saldo, double limite) {

        super(numeroConta, saldo);
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
        return "Conta corrente" +
                "saldo = " + this.getSaldo() +
                "número da conta" + this.getNumeroConta() +
                "Limite de crédito" + this.getLimite();

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
