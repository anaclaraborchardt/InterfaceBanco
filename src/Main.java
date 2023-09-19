import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Banco banco = new Banco();
    static ContaBancaria contaLogada;

    public static void main(String[] args) {
        menuInicial();
    }

    private static void menuInicial(){
        int opcao;
        do {
            System.out.println("""
                    Digite a opção desejada:
                    1- Criar Conta 
                    2- Selecionar Conta
                    3- Remover Conta
                    4- Gerar Relatório
                    5- Finalizar""");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> selecionarConta();
                case 3 -> removerConta();
                case 4 -> System.out.println(banco.mostrarDados());
                case 5 -> System.exit(0);
            }
        }while(opcao!=5);
    }

    private static void criarConta() {
        System.out.println("""
                Qual tipo de conta deseja criar?
                1- Poupança
                2- Corrente""");
        int opcao = sc.nextInt();

        if(opcao ==1 || opcao == 2) {
            System.out.println("Número da conta:");
            int numero = sc.nextInt();
            System.out.println("Valor Inicial");
            double saldo = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Limite");
                    double limite = sc.nextDouble();
                    if(limite > 0) {
                        banco.inserir(new ContaPoupanca(numero, saldo, limite));
                    }else{
                        System.out.println("Limite deve ser maior que 0");
                    }
                    break;
                case 2:
                    System.out.println("Taxa de operação");
                    double taxaOperacao = sc.nextDouble();
                    if(taxaOperacao > 0) {
                        banco.inserir(new ContaPoupanca(numero, saldo, taxaOperacao));
                    }else{
                        System.out.println("Taxa de Operação deve ser maior que 0");
                    }
                    break;
            }
        }else{
            System.out.println("Índice inválido");
        }
        System.out.println(banco.getListaContas());
    }

    private static void selecionarConta(){
        int opcao;
        System.out.println("Qual o numero da conta?");
        int numero = sc.nextInt();
        if(banco.procurarConta(numero) !=null){
            contaLogada = banco.procurarConta(numero);
            do {
                System.out.println("""
                        Digite a opção desejada:
                        1- Depositar 
                        2- Sacar
                        3- Transferir
                        4- Gerar Relatório
                        5- Voltar ao menu anterior""");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1 -> depositar();
                    case 2 -> sacar();
                    case 3 -> transferir();
                    case 4 -> gerarRelatorio();
                    case 5 -> menuInicial();
                }
            }while(opcao !=5);
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
        Relatorio relatorio = new Relatorio();
        System.out.println(relatorio.gerarRelatorio(contaLogada));
    }

    private static void depositar() {
        System.out.println("Digite o valor que deseja depositar");
        double valor = sc.nextDouble();
        contaLogada.depositar(valor);
        System.out.println(contaLogada.getSaldo());
    }

    private static void sacar() {
        System.out.println("Digite o valor que deseja sacar");
        double valor = sc.nextDouble();
        contaLogada.sacar(valor);
        System.out.println(contaLogada.getSaldo());
    }

    private static void transferir() {
        int numero;
        do {
            System.out.println("Digite o número da conta que deseja transferir");
            numero = sc.nextInt();
        }while(banco.procurarConta(numero) == null);

        System.out.println("Conta Encontrada");
        System.out.println("Digite o valor que deseja transferir");
        double valor = sc.nextInt();
        if(contaLogada.getSaldo() > 0) {
            contaLogada.transferir(valor, numero);
            System.out.println("Novo saldo" + contaLogada.getSaldo());
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

}
