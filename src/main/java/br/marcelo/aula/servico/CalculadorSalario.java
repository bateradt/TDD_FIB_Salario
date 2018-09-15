package br.marcelo.aula.servico;

import br.marcelo.aula.bean.Salario;

public class CalculadorSalario {
	
	private double salarioBruto;
	private double descontoINSS;
	private double impostoRenda;
	private double salarioLiquido;
	private Salario salario;
	
	double menorDescontoINSS = 0.085;
	double maiorDescontoINSS = 0.09;
	
	double menorDescontoIR = 0.05;
	double maiorDescontoIR = 0.07;
	
	public CalculadorSalario(Salario salario) {
		this.salario = salario;
	}
	
	public void calculaSalarioBruto() {
		salarioBruto = (salario.getHorasTrabalhadas() * salario.getValorSalarioHora()) + (50 * salario.getNumeroDependentes());
	}
	
	public void calculaDescontoINSS() {
		calculaSalarioBruto();
		if (salarioBruto <= 1000) {
			descontoINSS = salarioBruto * menorDescontoINSS;
		} else {
			descontoINSS = salarioBruto * maiorDescontoINSS;
		}
	}
	
	public void calculaDescontoIR() {
		calculaSalarioBruto();
		if (salarioBruto < 500) {
			impostoRenda = 0;
		} else if (salarioBruto > 500 && salarioBruto <= 1000) {
			impostoRenda = salarioBruto * menorDescontoIR;
		} else {
			impostoRenda = salarioBruto * maiorDescontoIR;
		}
	}
	
	public void calculaSalarioLiquido() {
		
		calculaSalarioBruto();
		calculaDescontoINSS();
		calculaDescontoIR();
		salarioLiquido = salarioBruto - descontoINSS - impostoRenda;
	}
	
	public double getSalarioBruto() {
		return salarioBruto;
	}

	public double getDescontoINSS() {
		return descontoINSS;
	}
	
	public double getImpostoRenda() {
		return impostoRenda;
	}
	
	public double getSalarioLiquido() {
		return salarioLiquido;
	}
	
	
	

}
