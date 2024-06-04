package Modelos;

public class Loja{

    private final int numeroMaxDeFuncionario = 15;
    private final Funcionario[] funcionarios;
    private String nome;

    public Loja(String nome){
        setNome(nome);
        this.funcionarios = new Funcionario[numeroMaxDeFuncionario];
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void addFuncionario(Funcionario funcionario){
        for (int i = 0; i < numeroMaxDeFuncionario; i++) {
            if(funcionarios[i] == null){
                funcionarios[i] = funcionario;
                i = numeroMaxDeFuncionario + 1;
            } else if(i == numeroMaxDeFuncionario - 1){
                System.out.println("Não foi possível cadastrar o funcionário, limite maximo atingido");
            }
        }

    }

    public void realizaVenda(String nome){
        int posicao = buscaPorFuncionario(nome);
        if(posicao == -1){
            System.out.println("Funcionário inexistente, impossível realizar venda");
            return;
        }
        if(!(funcionarios[posicao] instanceof FuncionarioVendedor)){
            System.out.println("Esse funcionário não é um vendedor");
            return;
        }
        ((FuncionarioVendedor) funcionarios[posicao]).incrementaQuantidadeDeVendas();
    }

    public void realizouHorasExtras(String nome,int horasExtras){
        for(Funcionario funcionario: funcionarios){
            if(funcionario != null){
                if(nome.equals(funcionario.getNome())){
                    if(funcionario instanceof FuncionarioAdmistrativo){
                        ((FuncionarioAdmistrativo) funcionario).incrementaHorasExtras(horasExtras);
                    }
                }
            }
        }
    }

    public int buscaPorFuncionario(String nome){
        int i = 0;
        for(Funcionario funcionario: funcionarios){
            i++;
            if(funcionario != null){
                if(funcionario.getNome().equals(nome)){
                    return i;
                }
            }
        }
        return -1;
    }

    public void calculaFolhaDePagamento(){
        double salTotalADM = 0;
        double salTotalVend = 0;
        for(Funcionario funcionario: funcionarios){
            if(funcionario != null){

                double salario = funcionario.calculaSalario();

                System.out.println(funcionario.getNome() + " = " + salario);

                if(funcionario instanceof FuncionarioAdmistrativo){
                    salTotalADM += salario;
                    ((FuncionarioAdmistrativo) funcionario).inicializaHorasExtras();
                } else if (funcionario instanceof FuncionarioVendedor) {
                    salTotalVend += salario;
                    ((FuncionarioVendedor) funcionario).inicializaQuantidadeDeVendas();
                }
            }
        }

        double pagamentoTotal = salTotalADM + salTotalVend;

        System.out.println("Pagamento total dos funcionarios administrativos = " +salTotalADM);
        System.out.println("Pagamento total dos funcionarios vendedores = "+salTotalVend);
        System.out.println("Pagamento total da loja = " +pagamentoTotal);
    }

}
