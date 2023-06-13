package Entidades;

import java.io.Serializable;
import java.util.Objects;

public class Jogos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_jogos;
	private String nome;
	private String plataforma;
	private String genero;
	private int preco;
	
	
	public Jogos(){
	}
	
	public Jogos(Integer id_jogos, String nome, String plataforma, String genero, int preco) {
		this.id_jogos = id_jogos;
		this.nome = nome;
		this.plataforma = plataforma;
		this.genero = genero;
		this.preco = preco;
	}

	public Integer getId_jogos() {
		return id_jogos;
	}

	public void setId_jogos(Integer id_jogos) {
		this.id_jogos = id_jogos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_jogos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogos other = (Jogos) obj;
		return Objects.equals(id_jogos, other.id_jogos);
	}
	
	@Override
	public String toString() {
		return "ID DO JOGO: " + id_jogos + "\nNOME DO JOGO: " + nome + "\nPLATAFORMA DO JOGO: " + plataforma + "\nGENERO DO JOGO: " + genero + "\nPREÇO DO JOGO: " + preco + "\n \n";
	}
	
	
	
}
