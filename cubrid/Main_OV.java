package cubrid;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main_OV {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        OVChipkaartCubridDAOlmpl ovChipkaartDao = new OVChipkaartCubridDAOlmpl();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

        String geldig="01-02-2022";
        java.util.Date date = sdf1.parse(geldig);
        java.sql.Date geldigTot = new java.sql.Date(date.getTime());

        String geldig1="01-02-2021";
        date = sdf1.parse(geldig1);
        java.sql.Date geldigTot1 = new java.sql.Date(date.getTime());

        String geldig2="01-02-2020";
        date = sdf1.parse(geldig2);
        java.sql.Date geldigTot2 = new java.sql.Date(date.getTime());
        
        String geldig3="01-02-2023";
        date = sdf1.parse(geldig3);
        java.sql.Date geldigTot3 = new java.sql.Date(date.getTime());


        System.out.println("Kaart toevoegen: ");
        CU_Chipkaart k1 = new CU_Chipkaart();
        k1.setKaartnummer(50000);
        k1.setGeldigTot(geldigTot);
        k1.setKlasse(1);
        k1.setSaldo(100.00);
        k1.setReizigerId(8);
        ovChipkaartDao.save(k1);

        System.out.println("Kaart toevoegen ");
        CU_Chipkaart k2 = new CU_Chipkaart();
        k2.setKaartnummer(50001);
        k2.setGeldigTot(geldigTot1);
        k2.setKlasse(2);
        k2.setSaldo(200.00);
        k2.setReizigerId(8);

        ovChipkaartDao.save(k2);
        
        System.out.println("Kaart toevoegen ");
        CU_Chipkaart k3 = new CU_Chipkaart();
        k3.setKaartnummer(50004);
        k3.setGeldigTot(geldigTot3);
        k3.setKlasse(1);
        k3.setSaldo(0.00);
        k3.setReizigerId(9);
        ovChipkaartDao.save(k3);

        // Haal alle kaarten op uit Database

        System.out.println("Alle kaarten: ");
        for ( CU_Chipkaart ovChipkaart : ovChipkaartDao.findAll()) {
            System.out.println("KAART: [KAARTNUMMER: " + ovChipkaart.getKaartnummer()+ ", GELDIG TOT: " + ovChipkaart.getGeldigtot()+ "." + ", Klasse:" +  ovChipkaart.getKlasse()
                    + ", SALDO:" + ovChipkaart.getSaldo() +  ", ReizigerID: "+ ovChipkaart.getReizigerId() + " ]");
        }

        // Zoek een kaart op basis van kaartnummer

        System.out.println("\nZoek kaart: ");

        for ( CU_Chipkaart kaart1 : ovChipkaartDao.findByKaartnummer(50000)) {
            System.out.println("KAART: [KAARTNUMMER: " + kaart1.getKaartnummer()+ ", GELDIG TOT: " + kaart1.getGeldigtot()+ "." + ", Klasse:" +  kaart1.getKlasse()
                    + ", SALDO:" + kaart1.getSaldo() +  ", ReizigerID: "+ kaart1.getReizigerId()+ " ]");
        }

        // Update kaart
        System.out.println("Kaart updaten: ");
        k2.setGeldigTot(geldigTot2);
        ovChipkaartDao.update(k2);


        System.out.println("Alle kaarten: ");
        for ( CU_Chipkaart ovChipkaart : ovChipkaartDao.findAll()) {
            System.out.println("KAART: [KAARTNUMMER: " + ovChipkaart.getKaartnummer()+ ", GELDIG TOT: " + ovChipkaart.getGeldigtot()+ "." + ", Klasse:" +  ovChipkaart.getKlasse()
                    + ", SALDO:" + ovChipkaart.getSaldo() +  ", ReizigerID: "+ ovChipkaart.getReizigerId() + " ]");
        }

		// -----------------------------------------------------------------------------------------
		// ovchipkaart zoeken o.b.v. reizigerId
		System.out.println("De gevonden ovchipkaarten via reiziger:");
		for (CU_Chipkaart ovChipkaart : ovChipkaartDao.findByReiziger(3)) {
			System.out.println("KAART: [KAARTNUMMER: " + ovChipkaart.getKaartnummer() + ", GELDIG TOT: "
					+ ovChipkaart.getGeldigtot() + "." + ", Klasse:" + ovChipkaart.getKlasse() + ", SALDO:"
					+ ovChipkaart.getSaldo() + ", ReizigerID: " + ovChipkaart.getReizigerId() + " ]");
		}
		// -----------------------------------------------------------------------------------------
		System.out.println();
		System.out.println();

        // Verwijder kaart op basis van ID
//        System.out.println("\nverwijder kaart:");
//        ovChipkaartDao.delete(k1);
 

        System.out.println("\nAlle kaarten: ");
        for ( CU_Chipkaart ovChipkaart : ovChipkaartDao.findAll()) {
            System.out.println("KAART: [KAARTNUMMER: " + ovChipkaart.getKaartnummer()+ ", GELDIG TOT: " + ovChipkaart.getGeldigtot()+ "." + ", Klasse:" +  ovChipkaart.getKlasse()
                    + ", SALDO:" + ovChipkaart.getSaldo() +  ", ReizigerID: "+ ovChipkaart.getReizigerId() + " ]");
        }
    }
}
