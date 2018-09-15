package br.marcelo.aula.ExercicioUm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import br.marcelo.aula.bean.Salario;
import br.marcelo.aula.servico.CalculadorSalario;

public class TestarCalculadorSalario {
	
	private Salario salarioProgramador;
	private Salario salarioTester;
	private Salario salarioPO;
	private CalculadorSalario calcSal;
	private CalculadorSalario calcSalTester;
	private CalculadorSalario calcSalPO;

	@Before
	public void init() {
		salarioProgramador = new Salario(160, 150.00, 3);
		salarioTester = new Salario(49, 10.00, 0);
		salarioPO = new Salario(50, 15.00, 2); //850
		
		calcSal = new CalculadorSalario(salarioProgramador);
		
		calcSalTester = new CalculadorSalario(salarioTester);
		
		calcSalPO = new CalculadorSalario(salarioPO);
		
	}
	
	@Test
	public void testarSalarioBruto() {
		calcSal.calculaSalarioBruto();
		
		assertEquals(24150, calcSal.getSalarioBruto(), 0.001);
		
	}
	
	@Test
	public void testarDescontoINSS() {
		calcSal.calculaDescontoINSS();
		
		assertEquals(2173.50, calcSal.getDescontoINSS(), 0.001);
		
	}
	
	@Test
	public void testarDescontoIR() {
		calcSal.calculaDescontoIR();
		
		assertEquals(1690.50, calcSal.getImpostoRenda(), 0.001);
		
	}
	
	@Test
	public void testarSalarioLiquido() {
		calcSal.calculaSalarioLiquido();
		
		assertEquals(20286, calcSal.getSalarioLiquido(), 0.001);
		
	}
	
	@Test
	public void testarDescontoIRsalarioTester() {
		calcSalTester.calculaDescontoIR();
		
		assertEquals(0, calcSalTester.getImpostoRenda(), 0.001);
		
	}
	
	@Test
	public void testarDescontoINSSsalarioTester() {
		calcSalTester.calculaDescontoINSS();
		
		assertEquals(41.65, calcSalTester.getDescontoINSS(), 0.001);
		
	}
	
	@Test
	public void testarDescontoIRsalarioPO() {
		calcSalPO.calculaDescontoIR();
		
		assertEquals(42.50, calcSalPO.getImpostoRenda(), 0.001);
		
	}
	

}
