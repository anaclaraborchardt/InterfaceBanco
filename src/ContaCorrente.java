public class ContaCorrente extends ContaBancaria{

    private double taxaOperacao;

    public ContaCorrente(int numeroConta, double saldo, double taxaOperacao) {
        super(numeroConta, saldo);
        this.taxaOperacao = taxaOperacao;
    }

    @Override
    public void sacar(double valor) {
        this.setSaldo((this.getSaldo() - valor));
        implementaTaxaOperacao();
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
                "taxa de Operação" + this.getTaxaOperacao();
    }

    public void implementaTaxaOperacao(){
        this.setSaldo(this.getSaldo() - taxaOperacao*this.getSaldo());
    }

    public double getTaxaOperacao() {
        return taxaOperacao;
    }

    public void setTaxaOperacao(double taxaOperacao) {
        this.taxaOperacao = taxaOperacao;
    }
}
