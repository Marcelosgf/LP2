package Entidades;

import java.io.Serializable;
import java.util.Objects;

public class Vendas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_vendas;
	private Integer id_cliente;
	private Integer id_jogos;

	public Vendas() {
		
	}

	public Vendas(Integer id_vendas, Integer id_cliente, Integer id_jogos) {
		this.id_vendas = id_vendas;
		this.id_cliente = id_cliente;
		this.id_jogos = id_jogos;
	}

	public Integer getId_vendas() {
		return id_vendas;
	}

	public void setId_vendas(Integer id_vendas) {
		this.id_vendas = id_vendas;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId_jogos() {
		return id_jogos;
	}

	public void setId_jogos(Integer id_jogos) {
		this.id_jogos = id_jogos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_vendas);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendas other = (Vendas) obj;
		return Objects.equals(id_cliente, other.id_vendas);
	}

	@Override
	public String toString() {
		return "Vendas [id_vendas=" + id_vendas + ", id_cliente=" + id_cliente + ", id_jogos=" + id_jogos + "]";
	}
	
	
	
}
