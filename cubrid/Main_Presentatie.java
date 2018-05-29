package cubrid;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main_Presentatie {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        ReizigerCubridDAOlmpl reizigerDao = new ReizigerCubridDAOlmpl();
        OVChipkaartCubridDAOlmpl OVchipkaartDao = new OVChipkaartCubridDAOlmpl();
        System.out.println("ALLE REIZIGERS:");
        for ( Reiziger reiziger : reizigerDao.findAll()) {
            System.out.println("reiziger: reiziger Id: " + reiziger.getReizigerId()+ ", Naam : " + reiziger.getVoorletters() + "." + reiziger.getAchternaam()
                    + ", Geboortedatum: "+ reiziger.getGeboortedatum());
        }
        
        System.out.println("\nALLE KAARTEN");
        for ( CU_Chipkaart ovChipkaart : OVchipkaartDao.findAll()) {
            System.out.println("kaart: kaartnummer: " + ovChipkaart.getKaartnummer()+ ", geldig tot: " + ovChipkaart.getGeldigtot()+ "." + ", Klasse:" +  ovChipkaart.getKlasse()
                    + ", saldo:" + ovChipkaart.getSaldo() +  ", ReizigerID: "+ ovChipkaart.getReizigerId() );
        }
        
        String pietGB="18-09-2000";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = sdf1.parse(pietGB);
        java.sql.Date piet = new java.sql.Date(date.getTime());
        
     // Voeg reiziger toe aan database
        System.out.println("\nREIZIGER TOEVOEGEN");
        Reiziger reiziger5 = new Reiziger();
        reiziger5.setReizigerId(6);
        reiziger5.setAchternaam("Plas");
        reiziger5.setVoorletters("P");
        reiziger5.setTussenvoegsel("van der");
        reiziger5.setGeboortedatum(piet);
        
        reizigerDao.save(reiziger5);
        
        
        System.out.println("\nALLE REIZIGERS:");
        for ( Reiziger reiziger : reizigerDao.findAll()) {
            System.out.println("reiziger: reiziger Id: " + reiziger.getReizigerId()+ ", Naam : " + reiziger.getVoorletters() + "." + reiziger.getAchternaam()
                    + ", Geboortedatum: "+ reiziger.getGeboortedatum());
        }
        
        
        
        reizigerDao.delete(reiziger5);
	}
}
