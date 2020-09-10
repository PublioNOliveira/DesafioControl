package dao;

import java.util.List;

import entidades.Contato;

public interface ContatoDAO {

	public void inserir(Contato contato);
	
	public void alterar(Contato contato);

	public void remover(Contato contato);

	public List<Contato> listarTodos();
	
	public Contato pesquisar(Contato contato);
	
	
	}
