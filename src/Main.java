import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Banco banco = new Banco();
    static ContaBancaria contaLogada;

    public static void main(String[] args) {
        menuInicial();
    }

    private static void menuInicial(){
        System.out.println("""
                Digite a opção desejada:
                1- Criar Conta 
                2- Selecionar Conta
                3- Remover Conta
                4- Gerar Relatório
                5- Finalizar""");
        int opcao = sc.nextInt();

        switch(opcao){
            case 1-> criarConta();
            case 2-> selecionarConta();
            case 3-> removerConta();
            case 4-> gerarRelatorio();
            case 5-> finalizar();

        }
    }

    private static void criarConta() {
        System.out.println("""
                Qual tipo de conta deseja criar?
                1- Poupança
                2- Corrente""");
        int opcao = sc.nextInt();

        System.out.println("Número da conta:");
        int numero = sc.nextInt();
        System.out.println("valor Inicial");
        double saldo = sc.nextInt();

        switch(opcao){
            case 1:
                System.out.println("limite");
                double limite = sc.nextDouble();
                ContaPoupanca contaPoupanca = new ContaPoupanca(numero, saldo, limite);
                banco.inserir(contaPoupanca);
                break;
            case 2:
                System.out.println("taxa de operação");
                double taxaOperacao = sc.nextDouble();
                ContaCorrente contaCorrente = new ContaCorrente(numero, saldo, taxaOperacao);
                banco.inserir(contaCorrente);
                break;
        }
        System.out.println(banco.getListaContas());
    }

    private static void selecionarConta(){
        System.out.println("Qual o numero da conta?");
        int numero = sc.nextInt();
        if(banco.procurarConta(numero) !=null){
            contaLogada = banco.procurarConta(numero);
            System.out.println("""
                Digite a opção desejada:
                1- Depositar 
                2- Sacar
                3- Transferir
                4- Gerar Relatório
                5- Voltar ao menu anterior""");
            int opcao = sc.nextInt();

            switch(opcao){
                case 1-> depositar();
                case 2-> sacar();
                case 3-> transferir();
            }
        }else{
            System.out.println("Conta não encontrada");
        }
    }
    private static void removerConta() {
        System.out.println("Digite o número da conta que quer remover");
        int numero = sc.nextInt();
        banco.remover(numero);
        System.out.println(banco.getListaContas());
    }

    private static void gerarRelatorio() {
    }

    private static void finalizar() {
    }

    private static void depositar() {
    }

    private static void sacar() {
    }

    private static void transferir() {
    }

}
