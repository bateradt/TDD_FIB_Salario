package br.marcelo.aula.bean;

public class Salario {
	
	private double horasTrabalhadas;
	private double valorSalarioHora;
	private int numeroDependentes;
	
	
	public Salario(double horasTrabalhadas, double valorSalarioHora, int numeroDependentes) {
		super();
		this.horasTrabalhadas = horasTrabalhadas;
		this.valorSalarioHora = valorSalarioHora;
		this.numeroDependentes = numeroDependentes;
	}
	
	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
		
	public double getValorSalarioHora() {
		return valorSalarioHora;
	}
	
	
	public int getNumeroDependentes() {
		return numeroDependentes;
	}
	
	
	

}
