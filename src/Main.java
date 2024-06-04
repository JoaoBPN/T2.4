import Modelos.Funcionario;
import Modelos.FuncionarioAdmistrativo;
import Modelos.FuncionarioVendedor;
import Modelos.Loja;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Loja loja1 = new Loja("Loja do João");

        int op = -1;

        while(op!= 5){
            System.out.println("""
                        Informe uma operação:
                        1 - Cadastrar funcionário
                        2 - Cadastrar uma venda
                        3 - Registrar horas extras
                        4 - Calcular a folha de pagamento
                        5 - Encerrar
                        """);

            op = scanner.nextInt();
            scanner.nextLine();
            String nome;
            switch(op){

                case 1:
                    loja1.addFuncionario(criaNovoFuncionario());
                    break;
                case 2:
                    System.out.println("Digite o nome do funcionário que realizou a venda");
                    nome = scanner.nextLine();
                    loja1.realizaVenda(nome);
                    break;
                case 3:
                    System.out.println("Digite o nome do funcionário que realizou a venda");
                    nome = scanner.nextLine();
                    System.out.println("Informe quantas horas extras foram realizadas");
                    int horasExtras = scanner.nextInt();
                    scanner.nextLine();
                    loja1.realizouHorasExtras(nome,horasExtras);
                    break;
                case 4:
                    loja1.calculaFolhaDePagamento();
                case 5:
                    break;
                default:
                    System.out.println("Operação invalida");
                    break;
            }
        }
    }

    public static Funcionario criaNovoFuncionario(){

        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o rg do funcionário: ");
        String registroGeral = scanner.nextLine();
        System.out.println("Digite o salario base do funcionário: ");
        double salarioBase = scanner.nextDouble();
        System.out.println("Digite 1 para funcionario administrativo e 2 para funcionario vendedor: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){
            return new FuncionarioAdmistrativo(nome,registroGeral,salarioBase);
        }

        return new FuncionarioVendedor(nome,registroGeral,salarioBase);

    }
}
