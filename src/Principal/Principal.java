package Principal;

import Modelos.Administrativo;
import Modelos.DadosFuncionario;
import Modelos.Funcionario;
import Modelos.Vendedor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Principal {

    private static final int MAX_FUNCIONARIOS = 15;

    private static final Funcionario[] funcionarios = new Funcionario[MAX_FUNCIONARIOS];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal(){
        var opcao = -1;

        while(opcao != 5){
            System.out.println("""
                    1 - Criar Funcionario
                    2 - Cadastrar venda
                    3 - Cadastrar horas extras
                    4 - Calcular folha de pagamento
                    5 - Encerrar
                    """);

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    criaFuncionario();
                    break;
                case 2:
                    incrementoDeAtributo(Vendedor.class);
                    break;
                case 3:
                    incrementoDeAtributo(Administrativo.class);
                    break;
                case 4:
                    calculaFolha();
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public static void criaFuncionario(){
        var posicao = posicaoVazia();

        if(posicao == null){
            System.out.println("Não há mais espaço para criação de funcinário");
            return;
        }

        var dados = getDadosFuncionario(true);

        if(funcionarioCadastrado(dados)){
            System.out.println("Esse funcionário já esta cadastrado");
            return;
        }

        System.out.println("""
                Digite o número da categoria do funcionário:
                1 - Administrativo
                2 - Vendedor
                """);

        var opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao){
            case 1:
                funcionarios[posicao] = new Administrativo(dados.nome(), dados.rG(), dados.salario());
                break;
            case 2:
                funcionarios[posicao] = new Vendedor(dados.nome(), dados.rG(), dados.salario());
                break;
            default:
                System.out.println("Opção inválida, retornando...");
                break;
        }
    }

    private static void incrementoDeAtributo(Class<? extends Funcionario> classe){
        var dados = getDadosFuncionario(false);
        Funcionario funcionario = null;

        for(Funcionario f : funcionarios){
            if(f.getNome().equals(dados.nome()) && f.getRG().equals(dados.rG()) && f.getClass().equals(classe)){
                funcionario = f;
                break;
            }
        }

        if(funcionario == null){
            System.out.println("Funcionário não encontrado");
            return;
        }

        System.out.println("Informe a quantidade realizada");
        var quantidade = scanner.nextInt();
        scanner.nextLine();

        funcionario.incrementaAtributo(quantidade);
        System.out.println("Incremento realizado com sucesso");
    }

    public static void calculaFolha(){
        BigDecimal salVendedor = BigDecimal.ZERO;
        BigDecimal salAdministrativo = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {

                BigDecimal salario = funcionario.calculaSalario();
                funcionario.encerraMes();

                if (funcionario instanceof Administrativo) {
                    salAdministrativo = salAdministrativo.add(salario);
                } else if(funcionario instanceof Vendedor){
                    salVendedor = salVendedor.add(salario);
                }

            }
        }

        System.out.println("Salário do setor administrativo : "+salAdministrativo.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Salário do setor vendas : "+salVendedor.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Salário total : "+salAdministrativo.add(salVendedor).setScale(2, RoundingMode.HALF_UP));
    }

    public static Integer posicaoVazia(){
        for (int i = 0; i < funcionarios.length ; i++) {
            if(funcionarios[i] == null){
                return i;
            }
        }

        return null;
    }

    private static DadosFuncionario getDadosFuncionario(boolean alsoGetSalario){
        System.out.println("Em relação ao funcionário informe:");
        System.out.print("Nome: ");
        var nome = scanner.nextLine();

        System.out.print("Rg: ");
        var rG = scanner.nextLine();

        BigDecimal salario;
        if(alsoGetSalario) {
            System.out.print("Salário: ");
            salario = BigDecimal.valueOf(scanner.nextDouble());

        }else salario = BigDecimal.ZERO;

        System.out.println(); // quebra de linha

        return new DadosFuncionario(nome,rG,salario);
    }

    private static boolean funcionarioCadastrado(DadosFuncionario dados){

        // Essa validação considera que Nome e Rg juntos não podem se repetir, se ela retorar true, quem a chamou deve
        // tratar esse problema, no caso isso está ocorrendo na criação de um funcionário, que deve impedir que isso ocorra

        for(Funcionario funcionario : funcionarios){
            if(funcionario != null && funcionario.getNome().equals(dados.nome())
                    && funcionario.getRG().equals(dados.rG())){
                return true;
            }
        }
        return false;
    }


}
