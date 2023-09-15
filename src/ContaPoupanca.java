public class ContaPoupanca extends ContaBancaria {

    private double limite;

    public ContaPoupanca(int numeroConta, double saldo, double limite) {
        super(numeroConta, saldo);
    }

    @Override
    public void sacar(double valor) {
        double saldo = this.getSaldo() - valor;
        if(saldo - valor < 0){
            this.setSaldo(this.getSaldo() - valor);
        }

    }

    @Override
    public void depositar(double valor) {
    }

    @Override
    public void mostrarDados() {

    }

    public boolean adicionarLimite(){
        if(this.setSaldo(this.getSaldo());)

    }
}
