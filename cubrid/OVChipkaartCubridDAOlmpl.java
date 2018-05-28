package cubrid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartCubridDAOlmpl extends CubridBaseDAO implements CU_ChipkaartDAO{
	public List<CU_Chipkaart> findAll() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        List<CU_Chipkaart> ovChipkaartInfo = new ArrayList<CU_Chipkaart>();
        Statement st = null;
        ResultSet rs = null;
        try {
            String selectOvChipkaart = "SELECT * FROM OV_CHIPKAART";
            st = conn.createStatement();
            rs = st.executeQuery(selectOvChipkaart);
            while (rs.next()) {
                CU_Chipkaart ovChipkaart = new CU_Chipkaart();
                ovChipkaart.setKaartnummer(rs.getInt("KAARTNUMMER"));
                ovChipkaart.setGeldigTot(rs.getDate("GELDIGTOT"));
                ovChipkaart.setKlasse(rs.getInt("KLASSE"));
                ovChipkaart.setSaldo(rs.getInt("SALDO"));
                ovChipkaart.setReizigerId(rs.getInt("REIZIGERID"));

                ovChipkaartInfo.add(ovChipkaart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }
        }
        return ovChipkaartInfo;
    }

    public List<CU_Chipkaart> findByKaartnummer(int kaartnummer) throws ParseException, SQLException, ClassNotFoundException{

        Connection conn = getConnection();

        List<CU_Chipkaart> ovChipkaartInfo = new ArrayList<CU_Chipkaart>();
        Statement st = null;
        ResultSet rs = null;
        try {
            String selectOvChipkaart = "SELECT * FROM OV_CHIPKAART where KAARTNUMMER = '" + kaartnummer + "' ";
            st = conn.createStatement();
            rs = st.executeQuery(selectOvChipkaart);
            while (rs.next()) {
                CU_Chipkaart ovChipkaart = new CU_Chipkaart();
                ovChipkaart.setKaartnummer(rs.getInt("KAARTNUMMER"));
                ovChipkaart.setGeldigTot(rs.getDate("GELDIGTOT"));
                ovChipkaart.setKlasse(rs.getInt("KLASSE"));
                ovChipkaart.setSaldo(rs.getInt("SALDO"));
                ovChipkaart.setReizigerId(rs.getInt("REIZIGERID"));

                ovChipkaartInfo.add(ovChipkaart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }
        }
        return ovChipkaartInfo;
    }
    
	public List<CU_Chipkaart> findByReiziger(int reizigerID) throws ParseException, SQLException, ClassNotFoundException {
		Connection con = getConnection();
		List<CU_Chipkaart> ovChipkaartInfo = new ArrayList<CU_Chipkaart>();

		String selectReizigerId = "SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = '" + reizigerID + "' ";

		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(selectReizigerId);

			while (rs.next()) {
				CU_Chipkaart ovchipkaart = new CU_Chipkaart();
				ovchipkaart.setKaartnummer(rs.getInt("kaartnummer"));
				ovchipkaart.setGeldigTot(rs.getDate("geldigtot"));
				ovchipkaart.setKlasse(rs.getInt("klasse"));
				ovchipkaart.setSaldo(rs.getDouble("saldo"));
				ovchipkaart.setReizigerId(rs.getInt("reizigerid"));
				ovChipkaartInfo.add(ovchipkaart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}

		return ovChipkaartInfo;
	}


    public CU_Chipkaart save(CU_Chipkaart ovChipkaart) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        Statement st = null;

        String insertOvChipkaart = "INSERT INTO OV_CHIPKAART VALUES (" + ovChipkaart.getKaartnummer() + "," + "(TO_DATE('" + ovChipkaart.getGeldigtot() + "', 'yyyy-mm-dd'))"
                + "," + "'" + ovChipkaart.getKlasse() + "'" + "," +  ovChipkaart.getSaldo() + ","
                + ovChipkaart.getReizigerId() + ")";

        try {
            st = conn.prepareStatement(insertOvChipkaart);
            st.executeUpdate(insertOvChipkaart);
            System.out.println("OvChipkaart met kaartnummer " + ovChipkaart.getKaartnummer() + " toegevoegd\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ovChipkaart;
    }

    public CU_Chipkaart update(CU_Chipkaart ovChipkaart) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        Statement st = null;

        if (ovChipkaart == null)
            throw new IllegalArgumentException("Reiziger mag niet null zijn");

		String updateReiziger = "update OV_CHIPKAART set GELDIGTOT = (TO_DATE('" + ovChipkaart.getGeldigtot() + "', 'yyyy-mm-dd')) WHERE KAARTNUMMER = " + ovChipkaart.getKaartnummer();
        try {
            st = conn.prepareStatement(updateReiziger);
            st.executeUpdate(updateReiziger);
            System.out.println("\nOvChipkaart met kaartnummer " + ovChipkaart.getKaartnummer() + " geupdatet");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ovChipkaart;
    }

    public boolean delete(CU_Chipkaart ovChipkaart) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        Statement st = null;
        boolean result = false;

        if (ovChipkaart == null)
            throw new IllegalArgumentException("Reiziger mag niet null zijn.");
        try {
            String deleteReiziger = "DELETE FROM OV_CHIPKAART WHERE KAARTNUMMER = " + ovChipkaart.getKaartnummer();
            st = conn.createStatement();
            st.executeUpdate(deleteReiziger);
            System.out.println("OvChipkaart met kaartnummer: " + ovChipkaart.getKaartnummer() + " verwijderd.");
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
