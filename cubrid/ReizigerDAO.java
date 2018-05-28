package cubrid;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface ReizigerDAO {
	public List<Reiziger> findAll() throws SQLException, ClassNotFoundException;
	
	public List<Reiziger> findByGBdatum(String GBdatum) throws ParseException, SQLException, ClassNotFoundException;
	
	public List<Reiziger> findByAchternaam(String Achternaam) throws ParseException, SQLException, ClassNotFoundException;
	
	public Reiziger save (Reiziger reiziger) throws SQLException, ClassNotFoundException;
	
	public Reiziger update ( Reiziger reiziger) throws SQLException, ClassNotFoundException;
	
	public boolean delete (Reiziger reiziger) throws SQLException, ClassNotFoundException;
}
