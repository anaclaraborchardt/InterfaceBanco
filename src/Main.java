import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        menu();
    }

    private static void menu(){
        ContaCorrente contaCorrente = new ContaCorrente(43443, 100, 0.5);
        ContaPoupanca contaPoupanca = new ContaPoupanca(46234, 6473, 1000);
        System.out.println("""
                Menu
                1- Sacar
                2- Depositar""");

        int opcao = sc.nextInt();

        switch(opcao){
            case 1:
                System.out.println(contaCorrente.getSaldo());
                System.out.println("valor");
                double valor = sc.nextDouble();
                contaCorrente.sacar(valor);
                System.out.println(contaCorrente.getSaldo());

        }
    }
}
