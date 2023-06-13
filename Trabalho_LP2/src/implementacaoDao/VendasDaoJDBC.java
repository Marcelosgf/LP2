package implementacaoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entidades.Vendas;
import dao.vendasDAO;
import db.DB;
import db.DbException;

public class VendasDaoJDBC implements vendasDAO {
	private Connection conn;
	
	public VendasDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Vendas vendas) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO vendas " + "(Id_cliente, Id_jogos) " + "VALUES (?, ?)",
			Statement.RETURN_GENERATED_KEYS); 
			st.setInt(1, vendas.getId_cliente());
			st.setInt(2, vendas.getId_jogos());
			
			int linhasAfetadas = st.executeUpdate();
			
			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					vendas.setId_vendas(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma inserção ocorreu");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	/*@Override
	public void update(Vendas vendas) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE vendas " + "SET id_cliente = ?, id_jogos = ? " + "WHERE id_vendas = ? "); 
			st.setInt(1, vendas.getId_cliente());
			st.setInt(2, vendas.getId_jogos());
			st.setInt(3, vendas.getId_vendas());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}	
	}
	*/
	
	
	
	
}