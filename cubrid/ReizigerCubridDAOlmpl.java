package cubrid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReizigerCubridDAOlmpl extends CubridBaseDAO implements ReizigerDAO{
	public List<Reiziger> findAll() throws SQLException {
        Connection conn = null;
		try {
			conn = getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

        List<Reiziger> reizigerInfo = new ArrayList<Reiziger>();
        Statement st = null;
        ResultSet rs = null;

        try {
            String selectReiziger = "SELECT * FROM REIZIGER";
            st = conn.createStatement();
            rs = st.executeQuery(selectReiziger);

            while (rs.next()) {
                Reiziger reiziger = new Reiziger();
                reiziger.setReizigerId(rs.getInt("REIZIGERID"));
                reiziger.setVoorletters(rs.getString("VOORLETTERS"));
                reiziger.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
                reiziger.setAchternaam(rs.getString("ACHTERNAAM"));
                reiziger.setGeboortedatum(rs.getDate("GEBOORTEDATUM"));
                reizigerInfo.add(reiziger);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return reizigerInfo;
    }

	public List<Reiziger> findByGBdatum(String GBdatum) throws ParseException, SQLException, ClassNotFoundException {
		Connection conn = getConnection();

        List<Reiziger> reizigerInfo = new ArrayList<Reiziger>();
        Statement st = null;
        ResultSet rs = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = sdf1.parse(GBdatum);
            Date datum = new Date(date.getTime());
            System.out.println(date);

            String gbDatum = "SELECT * FROM REIZIGER WHERE GEBOORTEDATUM = TO_DATE('" + datum + "', 'yyyy-MM-dd')";
            st = conn.createStatement();
            rs = st.executeQuery(gbDatum);
            while (rs.next()) {
                Reiziger reiziger = new Reiziger();
                reiziger.setReizigerId(rs.getInt("REIZIGERID"));
                reiziger.setVoorletters(rs.getString("VOORLETTERS"));
                reiziger.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
                reiziger.setAchternaam(rs.getString("ACHTERNAAM"));
                reiziger.setGeboortedatum(rs.getDate("GEBOORTEDATUM"));
                reizigerInfo.add(reiziger);
            }
        }catch (SQLException e) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return reizigerInfo;
}
  
	public List<Reiziger> findByAchternaam(String Achternaam) throws ParseException, SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			conn = getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

        List<Reiziger> reizigerInfo = new ArrayList<Reiziger>();
        Statement st = null;
        ResultSet rs = null;

        try {
            String selectReiziger = "SELECT * FROM REIZIGER WHERE ACHTERNAAM = "+"'"+Achternaam+"'";
            st = conn.createStatement();
            rs = st.executeQuery(selectReiziger);

            while (rs.next()) {
                Reiziger reiziger = new Reiziger();
                reiziger.setReizigerId(rs.getInt("REIZIGERID"));
                reiziger.setVoorletters(rs.getString("VOORLETTERS"));
                reiziger.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
                reiziger.setAchternaam(rs.getString("ACHTERNAAM"));
                reiziger.setGeboortedatum(rs.getDate("GEBOORTEDATUM"));
                reizigerInfo.add(reiziger);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return reizigerInfo;
}

    public Reiziger save(Reiziger reiziger) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        Statement st = null;

        String insertReiziger = "INSERT INTO REIZIGER VALUES (" + reiziger.getReizigerId() + "," + "'" + reiziger.getVoorletters()
                + "'" + "," + "'" + reiziger.getTussenvoegsel() + "'" + "," + "'" + reiziger.getAchternaam() + "'" + ","
                + "(TO_DATE('" + reiziger.getGeboortedatum() + "', 'yyyy-mm-dd')))";

        try {

            st = conn.prepareStatement(insertReiziger);
            st.executeUpdate(insertReiziger);

            System.out.println("Reiziger met ID " + reiziger.getReizigerId() + " toegevoegd\n");

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
        return reiziger;
    }

    public Reiziger update(Reiziger reiziger) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        Statement st = null;

        if (reiziger == null)
            throw new IllegalArgumentException("Reiziger mag niet null zijn");

        String updateReiziger = "UPDATE REIZIGER SET VOORLETTERS = " + "'" + reiziger.getVoorletters() + "'," + "TUSSENVOEGSEL = " + "'"
                + reiziger.getTussenvoegsel() + "'," + "ACHTERNAAM = " + "'" + reiziger.getAchternaam() + "',"
                + "GEBOORTEDATUM = " +"(TO_DATE('" + reiziger.getGeboortedatum() + "', 'yyyy-mm-dd'))"  + "WHERE REIZIGERID = " + reiziger.getReizigerId();


        try {
            st = conn.prepareStatement(updateReiziger);
            st.executeUpdate(updateReiziger);
            System.out.println("\nReiziger met reizigersID " + reiziger.getReizigerId() + " geupdate");
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
        return reiziger;

    }

    public boolean delete(Reiziger reiziger) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        Statement st = null;
        boolean result = false;

        if (reiziger == null)
            throw new IllegalArgumentException("reiziger mag niet null zijn");
        try {
            String deleteReiziger = "DELETE FROM REIZIGER WHERE REIZIGERID = " + reiziger.getReizigerId();
            st = conn.createStatement();
            st.executeUpdate(deleteReiziger);
            System.out.println("Reiziger met reizigersID " + reiziger.getReizigerId() + " verwijderd\n");
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

