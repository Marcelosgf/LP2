package implementacaoDao;

import dao.JogosDAO;
import dao.clientesDAO;
import dao.vendasDAO;
import db.DB;

public class DaoFactory {
	
	public static clientesDAO createClientesDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	}
	
	public static JogosDAO createJogosDao() {
		return new JogosDaoJDBC(DB.getConnection());
	}
	
	public static vendasDAO createVendasDao() {
		return new VendasDaoJDBC(DB.getConnection());
	}
	
}
