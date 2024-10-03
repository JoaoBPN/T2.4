package Modelos;

import java.math.BigDecimal;

public class Vendedor extends Funcionario{

    private int numeroDeVendas;

    public Vendedor(String nome, String rG, BigDecimal salario){
        super(nome,rG,salario);
        this.numeroDeVendas = 0;
    }

    @Override
    public BigDecimal calculaSalario() {
        BigDecimal salario = getSalario();

        var vendas = new BigDecimal(numeroDeVendas);
        BigDecimal coeficiente = BigDecimal.ONE;

        if(numeroDeVendas > 10){
            coeficiente = new BigDecimal("0.015");
            coeficiente = coeficiente.multiply(vendas);
            coeficiente = coeficiente.add(new BigDecimal("0.9"));
        }

        return salario.multiply(coeficiente);
    }

    @Override
    public void encerraMes() {
        this.numeroDeVendas = 0;
    }

    @Override
    public void incrementaAtributo(int incremento){
        numeroDeVendas += incremento; // incrementa número de vendas
    }
}
