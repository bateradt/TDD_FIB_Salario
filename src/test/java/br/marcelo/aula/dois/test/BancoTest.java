package br.marcelo.aula.dois.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.marcelo.aula.dois.Banco;
import br.marcelo.aula.dois.Conta;
import br.marcelo.aula.dois.Usuario;
import br.marcelo.aula.dois.DAO.ContaDao;
import br.marcelo.aula.dois.DAO.ContaDaoFalso;
import br.marcelo.aula.dois.DAO.DAO;
import br.marcelo.aula.dois.mock.ContaBuilder;


public class BancoTest {
	
	private Conta c1;
	private Conta c2;
	private Conta c3;
	private Conta c4;
	private Conta c5;
	private Conta c6;
	private Conta c7;
	private Usuario joao;
	private Usuario manoel;
	private Usuario joaquim;
	private Usuario maria;

	@Before
	public void criarAmbiente(){
		c1 = new Conta(100.0, "Basica");
		c2 = new Conta(200.0, "Prime");
		
		joao = new Usuario("Joao da Silva", "111111111", "joaosilva@mailinator.com");
		manoel = new Usuario("Manoel da Silva", "22222222", "manoelsilva@mailinator.com");
	}
	
	@Test
	public void deveSomarTodasAsContasTrazendoOSaldoDoBanco(){
		
		List<Conta> contas = new ContaBuilder()
		.addConta(c1, joao)
		.addConta(c2, manoel)
		.constroi();
		
		 DAO dao = new ContaDaoFalso();
		 dao.salvaConta(contas.get(0));
		 dao.salvaConta(contas.get(1));
		 
		 Banco banco = new Banco(dao);
		 
		 assertEquals(2, banco.getContas().size(), 0.00001);
		 assertEquals(300, banco.totalSaldo(), 0.00001);
	}
	
	@Test
	public void deveSomarTodasAsContasTrazendoOSaldoDoBancoComMock() {

		List<Conta> contas = new ContaBuilder()
			.addConta(c1, joao)
			.addConta(c2, manoel)
			.constroi();

		DAO dao = mock(ContaDao.class);
		when(dao.getContas()).thenReturn(contas);

		Banco banco = new Banco(dao);
		
		assertEquals(2, banco.getContas().size(), 0.00001);
		assertEquals(300, banco.totalSaldo(), 0.00001);
	}
	
	@Test
	public void deveAtualizarAsContasComJurosAplicados(){
		
		List<Conta> contas = new ContaBuilder()
			.addConta(c1, joao)
			.addConta(c2, manoel)
			.constroi();
		
		DAO dao = mock(ContaDao.class);
		when(dao.getContas()).thenReturn(contas);
		
		dao.salvaConta(contas.get(0));
		dao.salvaConta(contas.get(1));
		
		Banco banco = new Banco(dao);
		banco.atualizaJuros(5);
		
		// verificando que o metodo atualizaConta foi realmente invocado!
		verify(dao, times(1)).atualizaConta(contas.get(0));
		
		assertEquals(2, banco.getContas().size(), 0.00001);
		//assertEquals(615.0, banco.totalSaldo(), 0.00001);
	}
	
	@Test
	public void deveContinuarAExecucaoMesmoQuandoDaoFalha(){
			
		List<Conta> contas = new ContaBuilder()
			.addConta(c4, joao)
			.addConta(c5, manoel)
			.addConta(c6, joaquim)
			.addConta(c7, maria)
			.constroi();
			
		DAO dao = mock(ContaDao.class);
		when(dao.getContas()).thenReturn(contas);
			
		doThrow(new RuntimeException()).when(dao).atualizaConta(c5);
		doThrow(new RuntimeException()).when(dao).atualizaConta(c6);
			
		Banco banco = new Banco(dao);
		banco.atualizaJuros(5);
			
		verify(dao, times(1)).atualizaConta(c4);
		verify(dao, times(1)).atualizaConta(c5);
		verify(dao, times(1)).atualizaConta(c6);
		verify(dao, times(1)).atualizaConta(c7);
			
	}
	
}