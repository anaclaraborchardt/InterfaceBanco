import java.util.ArrayList;

public class Banco implements IImprimivel{

    ArrayList<ContaBancaria> listaContas = new ArrayList<>();

    public Banco() {
        ContaPoupanca contaPoupanca = new ContaPoupanca(2, 00.00, 100.00);
        listaContas.add(contaPoupanca);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca(3, 50.00, 100.00);
        listaContas.add(contaPoupanca2);
    }

    public String remover(int numero){
        for (ContaBancaria conta : listaContas) {
            if (numero == conta.getNumeroConta()) {
                listaContas.remove(conta);
                return "Conta " + conta + " removida com sucesso";
            }
        }
        return "Não foi possível encontrar essa conta";
    }

    public void inserir(ContaBancaria conta){
        listaContas.add(conta);
    }

    public ContaBancaria procurarConta(int numero){
        for (ContaBancaria conta : listaContas){
            if(numero == conta.getNumeroConta()){
                return conta;
            }
        }
        return null;
    }

    @Override
    public String mostrarDados() {
        String dados = "";
        for (ContaBancaria conta : listaContas){
                dados += conta.mostrarDados() + "\n";
        }
        return dados;
    }

    public ArrayList<ContaBancaria> getListaContas() {
        return listaContas;
    }

    public void setListaContas(ArrayList<ContaBancaria> listaContas) {
        this.listaContas = listaContas;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "listaContas=" + listaContas +
                '}';
    }


}
