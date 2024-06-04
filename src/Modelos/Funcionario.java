package Modelos;

public abstract class Funcionario implements TemSalario{

    private String nome;
    private String registroGeral;
    private double salarioBase;

    public Funcionario(String nome,String registroGeral,double salarioBase){
        setNome(nome);
        setRegistroGeral(registroGeral);
        setSalarioBase(salarioBase);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setRegistroGeral(String registroGeral){
        this.registroGeral = registroGeral;
    }

    public String getRegistroGeral(){
        return this.registroGeral;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

}
