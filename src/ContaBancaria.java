public abstract class ContaBancaria implements IImprimivel {

    private int numeroConta;
    private double saldo;

    public ContaBancaria(int numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public abstract void sacar(double valor);

    public abstract void depositar(double valor);

    public String transferir(double valor, int numeroConta){
            this.setSaldo(this.getSaldo() - valor);
                if(numeroConta == this.getNumeroConta()){
                    return "Essa conta já é sua ";
                }else {
            ContaBancaria contaRecebedora = new Banco().procurarConta(numeroConta);
            contaRecebedora.setSaldo(contaRecebedora.getSaldo() + valor);
            return "Transferência bem sucedida";
        }
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
