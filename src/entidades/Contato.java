package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tabela_contato")
public class Contato implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="telefone")
	private String telefone;
		
	@Column(name="email")
	private String email;
		
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grupo", nullable = false)
	private String grupo;
	
	public Contato() {
		}

	public Contato(Long id, String nome, String telefone, String email, String grupo) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.grupo = grupo;
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone="
				+ telefone + ", email=" + email + ", grupo=" + grupo + "]";
	}

	

	
		
	
}