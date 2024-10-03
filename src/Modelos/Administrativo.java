package Modelos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Administrativo extends Funcionario{

    private int horasExtras;

    public Administrativo(String nome, String rG, BigDecimal salario){
        super(nome,rG,salario);
        this.horasExtras = 0;
    }

    @Override
    public BigDecimal calculaSalario(){
        BigDecimal salario = getSalario();
        var horas = new BigDecimal(horasExtras);
        var coeficiente = new BigDecimal("0.02");

        coeficiente = horas.multiply(coeficiente);
        coeficiente = coeficiente.add(BigDecimal.ONE);

        return salario.multiply(coeficiente).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void encerraMes() {
        horasExtras = 0;
    }

    @Override
    public void incrementaAtributo(int incremento){
        this.horasExtras += incremento;  //incrementa horas
    }

}
