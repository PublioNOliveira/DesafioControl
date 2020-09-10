package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tabela_grupo")
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_grupo", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOME_DO_GRUPO", unique=true, nullable = false)
	private String nomeDoGrupo;
	
	public Grupo() {
	}

	public Grupo(Integer id, String nomeDoGrupo) {
		this.id = id;
		this.nomeDoGrupo = nomeDoGrupo;
	}

	public Integer getId() {
		return id;
	}

	public String getNomeDoGrupo() {
		return nomeDoGrupo;
	}

	public void setNomeDoGrupo(String nomeDoGrupo) {
		this.nomeDoGrupo = nomeDoGrupo;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nomeDoGrupo=" + nomeDoGrupo + "]";
	}	
	
	
}