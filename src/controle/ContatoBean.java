package controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import dao.ContatoDAO;
import dao.ContatoDAOImpl;
import dao.GrupoDAO;
import dao.GrupoDAOImpl;
import entidades.Contato;
import entidades.Grupo;

@ManagedBean(name = "ContatoBean")
@SessionScoped

public class ContatoBean {


	private String nome;
	private String email;
	private String telefone;
	private String grupo;
	private String nomeDoGrupo;
	private Boolean erro = Boolean.FALSE;
	private List<Contato> listaContato;
	private List<Contato> listaContato2;
	private Contato contato; 
	private ContatoDAO contatoDAO;
	private GrupoDAO grupoDAO;

	@PostConstruct
 	public void init() {
	contato = new Contato();
	contatoDAO = new ContatoDAOImpl();
	grupoDAO = new GrupoDAOImpl();
 	}

 	public void CadastrarContato() {
 	
		contato.setEmail(email);
		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setGrupo(grupo);
	 	
			Grupo grupo = new Grupo();
			grupo.setNomeDoGrupo(contato.getGrupo());
			this.contatoDAO.inserir(contato);
			this.grupoDAO.inserir(grupo);
			this.contato = new Contato();
			
			FacesMessage faces = new FacesMessage("Contato cadastrado!!!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
			
			FacesContext context = FacesContext.getCurrentInstance();
			String viewId = context.getViewRoot().getViewId();
			javax.faces.application.ViewHandler handler = context.getApplication().getViewHandler();
			UIViewRoot root = handler.createView(context, viewId);
			root.setViewId(viewId);
			context.setViewRoot(root);
		}		
		
	
public void ExcluirContato(Contato contato) {	
			
		if(contato != null) {
			this.contatoDAO.remover(contato);
			FacesMessage faces = new FacesMessage("Contato Excluído!!!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
			
		}else {
			FacesMessage faces = new FacesMessage("Contato não existe!!!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		}
	}



	public void AlterarContato() {
				
		
		
		if(contato != null) {
			 this.contatoDAO.alterar(contato);
			 FacesMessage faces = new FacesMessage("Alteração Realizada!!!");
				FacesContext contexto = FacesContext.getCurrentInstance();
				contexto.addMessage(null, faces);
			
		}else {
			FacesMessage faces = new FacesMessage("Usuário não existe!!!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		}
		}
	
	
	
public void  PesquisarContato() {
		
	contato.setNome(nome);		
		boolean achou = false;		
		this.listaContato = this.contatoDAO.listarTodos();
		
		for (Contato contatoPesquisa : listaContato) {
			if (contatoPesquisa.getNome().equals(nome)) {
				achou = true;
			}
		}		
		if(achou == true) {
			contato = this.contatoDAO.pesquisar(contato);
			
		}else {
			FacesMessage faces = new FacesMessage("Usuário não existe!!!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		}
		}


    public List<Contato> listar() {
		
    	return contatoDAO.listarTodos();
	
    }
    
   public void atualizar(Contato pContato) {
		
    	contato = pContato;
	
    }
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public String getNomeDoGrupo() {
		return nomeDoGrupo;
	}


	public void setNomeDoGrupo(String nomeDoGrupo) {
		this.nomeDoGrupo = nomeDoGrupo;
	}


	public ContatoDAO getContatoDAO() {
		return contatoDAO;
	}


	public void setContatoDAO(ContatoDAO contatoDAO) {
		this.contatoDAO = contatoDAO;
	}

	public GrupoDAO getGrupoDAO() {
		return grupoDAO;
	}


	public void setGrupoDAO(GrupoDAO grupoDAO) {
		this.grupoDAO = grupoDAO;
	}


	public Boolean getErro() {
		return erro;
	}

	public void setErro(Boolean erro) {
		this.erro = erro;
	}

	public List<Contato> getListaContato() {
		return listaContato;
	}

	public void setListaContato(List<Contato> listaContato) {
		this.listaContato = listaContato;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getListaContato2() {
		return listaContato2;
	}
	public void setListaContato2(List<Contato> listaContato2) {
		this.listaContato2 = listaContato2;
	}
		
	
}

