package Entidades;

import java.io.Serializable;
import java.util.Objects;

public class Clientes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_cliente;
	private String nome;
	private String telefone;
	private String email;
	
	
	public Clientes() {
	}
		
	public Clientes(Integer id_cliente, String nome, String telefone, String email) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
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

	@Override
	public int hashCode() {
		return Objects.hash(id_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		return Objects.equals(id_cliente, other.id_cliente);
	}
	
	@Override
	public String toString() {

		return " ID DO CLIENTE: " + id_cliente + "\n NOME DO CLIENTE: " + nome + "\n TELEFONE DO CLIENTE: " + telefone + "\n EMAIL DO CLIENTE: " + email + "\n  \n";
	}
	
	
	
}
