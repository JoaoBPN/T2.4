package Modelos;

public class FuncionarioAdmistrativo extends Funcionario{

    private int horasExtras;

    public FuncionarioAdmistrativo(String nome, String registroGeral, double salarioBase) {
        super(nome, registroGeral, salarioBase);
        inicializaHorasExtras();
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void inicializaHorasExtras(){
        this.horasExtras = 0;
    }

    public void incrementaHorasExtras(int incremento){
        this.horasExtras += incremento;
    }

    @Override
    public double calculaSalario() {
        return getSalarioBase() + (getHorasExtras() * (0.02 * getSalarioBase()));
    }


}
