package br.marcelo.aula.dois.DAO;

import java.util.List;

import br.marcelo.aula.dois.Conta;

public interface DAO {
	
	public void salvaConta(Conta conta);
	public List<Conta> getContas();
	public void atualizaConta(Conta conta);

}
