package Modelos;

public class FuncionarioVendedor extends Funcionario{

    private int quantidadeDeVendas;

    public FuncionarioVendedor(String nome,String registroGeral,double salarioBase){
        super(nome,registroGeral,salarioBase);
        inicializaQuantidadeDeVendas();
    }

    public int getQuantidadeDeVendas(){
        return this.quantidadeDeVendas;
    }

    public void inicializaQuantidadeDeVendas(){
        this.quantidadeDeVendas = 0;
    }

    public void incrementaQuantidadeDeVendas(){
        this.quantidadeDeVendas++;
    }

    @Override
    public double calculaSalario() {
        if(getQuantidadeDeVendas()>9) {
            return getSalarioBase() * 0.9 + getQuantidadeDeVendas() * 1.5;
        }

        return getSalarioBase();

    }



    // o texto diz o seguinte "caso o numero de vendas for inferior a 10 então eles receberão apenas o salario base",
    // "caso seja superior a 10, então o salário sera 90% do salario base, mais 1.5% adicional por venda realizada no mês.",
    // desse modo não especifica o que deve ser feito se o numero de vendar for exatamente igual a 10, portanto eu considerei que ele se enquadrará no segundo caso.
    // também achei confuso o fato dele não receber uma comissão baseada no valor do produto que ele vendeu, mas sim uma quantidade fixa
    // por exemplo, supondo que o salário do vendedor seja de R$ 3000, e que exista um produto de R$ 20 na loja, e ele realizasse apenas 30 vendas desse produto no mes
    // ele receberia um total de 3600 reais (2700 + 900), contudo ele realizou um total de vendas igual a 600 reais, então é como se ele tivesse recebido uma comissão
    // de 100% de tudo que ele vendeu.
}
