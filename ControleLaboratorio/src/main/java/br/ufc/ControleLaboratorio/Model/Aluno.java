package br.ufc.ControleLaboratorio.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue
	private int id;
	private int matricula;
	private String nome;
	private String senha;
	private String email;
	@ManyToMany(mappedBy = "aluno")
	private List<Evento> evento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
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
	public List<Evento> getEvento() {
		return evento;
	}
	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
