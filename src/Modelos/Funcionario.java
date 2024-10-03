package Modelos;

import java.math.BigDecimal;

public abstract class Funcionario{

    private final String nome;
    private final String rG;
    private final BigDecimal salario;

    public Funcionario(String nome, String rG,BigDecimal salario){
        this.nome = nome;
        this.rG = rG;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getRG() {
        return rG;
    }

    public BigDecimal getSalario(){
        return salario;
    }

    public abstract void incrementaAtributo(int incremento);
    public abstract void encerraMes();
    public abstract BigDecimal calculaSalario();
}
