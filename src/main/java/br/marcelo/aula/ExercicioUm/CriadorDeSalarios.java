package br.marcelo.aula.ExercicioUm;

import br.marcelo.aula.bean.Salario;
import br.marcelo.aula.servico.CalculadorSalario;

public class CriadorDeSalarios {
	
	private CalculadorSalario calcSal;
	
	public CriadorDeSalarios() {
		
	}
	
	public CriadorDeSalarios para(double horasTrabalhadas, double valorSalarioHora, int numeroDependentes) {
		this.calcSal = new CalculadorSalario(new Salario(horasTrabalhadas, valorSalarioHora, numeroDependentes));
		return this;
	}
	
	public CriadorDeSalarios calcular() {
		calcSal.calculaSalarioLiquido();
		return this;
	}
	
	public CalculadorSalario constroi() {
		return calcSal;
	}
	
	

}
