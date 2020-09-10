package dao;

import java.util.List;

import entidades.Grupo;

public interface GrupoDAO {

	public void inserir(Grupo grupo);
	
	public void alterar(Grupo grupo);

	public void remover(Grupo grupo);

	public List<Grupo> listarTodos();
	
	//public Grupo pesquisar(Grupo grupo);
	
	}
