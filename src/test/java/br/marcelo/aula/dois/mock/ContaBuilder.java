package br.marcelo.aula.dois.mock;

import java.util.ArrayList;
import java.util.List;

import br.marcelo.aula.dois.Conta;
import br.marcelo.aula.dois.Usuario;

public class ContaBuilder {
	
	private List<Conta> contas;
	private Usuario usuario;
	
	public ContaBuilder(){
		contas = new ArrayList<Conta>();
	}
	
	public ContaBuilder addConta(Conta conta, Usuario usuario){
		conta.setUsuario(usuario);
		this.contas.add(conta);
		return this;
	}
	
	public List<Conta> constroi() {
		return this.contas;
	}
	
}