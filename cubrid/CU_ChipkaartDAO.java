package cubrid;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


public interface CU_ChipkaartDAO {
public List<CU_Chipkaart> findAll() throws SQLException, ClassNotFoundException;
	
	public List<CU_Chipkaart> findByKaartnummer(int kaartnummer) throws ParseException, SQLException, ClassNotFoundException;
	
	public List<CU_Chipkaart> findByReiziger(int reizigerId) throws ParseException, SQLException, ClassNotFoundException;
	
	public CU_Chipkaart save (CU_Chipkaart OVchipkaart) throws SQLException, ClassNotFoundException;
	
	public CU_Chipkaart update (CU_Chipkaart OVchipkaart) throws SQLException, ClassNotFoundException;
	
	public boolean delete (CU_Chipkaart OVchipkaart) throws SQLException, ClassNotFoundException;
}
