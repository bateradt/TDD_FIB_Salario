package br.marcelo.aula.dois.DAO;

import java.util.ArrayList;
import java.util.List;

import br.marcelo.aula.dois.Conta;

public class ContaDaoFalso implements DAO {

	private static List<Conta> contas = new ArrayList<Conta>();
	
	public void salvaConta(Conta conta) {
		contas.add(conta);
	}

	public List<Conta> getContas(){
		return contas;
	}

	public void atualizaConta(Conta conta) { /* faz nada! */ }
}