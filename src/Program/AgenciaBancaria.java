package Program;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }
    public static void operacoes(){
        System.out.println("------------------------------------------------------");
        System.out.println("---------------Bem vindos a nossa Agência-------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|	Opção 1 - Criar conta	|");
        System.out.println("|	Opção 2 - Depoistar		|");
        System.out.println("|	Opção 3 - Sacar		    |");
        System.out.println("|	Opção 4 - Trasferir		|");
        System.out.println("|	Opção 5 - Listar		|");
        System.out.println("|	Opção 6 - Sair		    |");

        int operacao = input.nextInt();
        switch (operacao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Volte sempre! Até logo!");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
                operacoes();
                break;

        }
    }
    public static void criarConta(){
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome,cpf,email);
        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Conta Criada com Sucesso!");

        operacoes();
    }
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void  depositar(){
        System.out.println(" Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if (conta != null){
            System.out.println("Qual valor deseja depoistar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Depósito realizado com Sucesso! ");
        }else {
            System.out.println("Conta não encontrada! ");
        }
        operacoes();
        }
        public static void sacar(){
            System.out.println(" Número da conta: ");
            int numeroConta = input.nextInt();
            Conta conta = encontrarConta(numeroConta);
            if (conta != null){
                System.out.println("Qual valor deseja sacar? ");
                Double valorSaque = input.nextDouble();
                conta.sacar(valorSaque);
                // System.out.println("Saque realizado com Sucesso! ");
            }else {
                System.out.println("Conta não encontrada! ");
            }
            operacoes();
        }
        public static void transferir(){
            System.out.println("Número da conta Origem: ");
            int numeroContaOrigem = input.nextInt();
            Conta contaOrigem = encontrarConta(numeroContaOrigem);

            if (contaOrigem != null){
                System.out.println("Número da Conta Destino: ");
                int numeroContaDestino = input.nextInt();

                Conta contaDestino = encontrarConta(numeroContaDestino);

                if (contaDestino != null){
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contaOrigem.transferir(contaDestino, valor);
            }else {
                    System.out.println("Conta para Depósito não encontrada!");
                }
        }   else {
                System.out.println("Conta para Transferência não encontrada");
            }
            operacoes();
    }
    public static void listarContas(){
        if (!contasBancarias.isEmpty()) {
            for (Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.println("Nenhuma Conta Cadastrada!");
        }
        operacoes();
    }
}
