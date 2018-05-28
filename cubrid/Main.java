package cubrid;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {
	public static void main(String[] args) throws SQLException, ParseException, ClassNotFoundException {
        ReizigerCubridDAOlmpl reizigerDao = new ReizigerCubridDAOlmpl();

        String luukGB="18-09-2000";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = sdf1.parse(luukGB);
        java.sql.Date luuk = new java.sql.Date(date.getTime());

        String niekGB="03-01-1997";
        sdf1 = new SimpleDateFormat("yyyy-mm-dd");
        date = sdf1.parse(niekGB);
        java.sql.Date niek = new java.sql.Date(date.getTime());

        String brightonGB="02-01-1999";
        sdf1 = new SimpleDateFormat("yyyy-mm-dd");
        date = sdf1.parse(brightonGB);
        java.sql.Date brighton = new java.sql.Date(date.getTime());
        
        String evanGB="13-04-2000";
        sdf1 = new SimpleDateFormat("yyyy-mm-dd");
        date = sdf1.parse(evanGB);
        java.sql.Date evan = new java.sql.Date(date.getTime());
        
        
        
 
        // Voeg reiziger toe aan database
        System.out.println("Reiziger toevoegen:");
        Reiziger reiziger1 = new Reiziger();
        reiziger1.setReizigerId(6);
        reiziger1.setAchternaam("YOUNG");
        reiziger1.setVoorletters("L");
        reiziger1.setTussenvoegsel("");
        reiziger1.setGeboortedatum(luuk);

        reizigerDao.save(reiziger1);

        System.out.println("Reiziger toevoegen:");
        Reiziger reiziger2 = new Reiziger();
        reiziger2.setReizigerId(7);
        reiziger2.setAchternaam("Hamoen");
        reiziger2.setVoorletters("PN");
        reiziger2.setTussenvoegsel(null);
        reiziger2.setGeboortedatum(niek);

        reizigerDao.save(reiziger2);
        
        System.out.println("Reiziger toevoegen:");
        Reiziger reiziger3 = new Reiziger();
        reiziger3.setReizigerId(8);
        reiziger3.setAchternaam("Bright");
        reiziger3.setVoorletters("B");
        reiziger3.setTussenvoegsel(null);
        reiziger3.setGeboortedatum(brighton);
        
        reizigerDao.save(reiziger3);
        
        System.out.println("Reiziger toevoegen:");
        Reiziger reiziger4 = new Reiziger();
        reiziger4.setReizigerId(9);
        reiziger4.setAchternaam("Essen");
        reiziger4.setVoorletters("E");
        reiziger4.setTussenvoegsel("van");
        reiziger4.setGeboortedatum(evan);
        
        reizigerDao.save(reiziger4);
        
        
        
        // Haal alle reizigers op uit database
        System.out.println("Alle reizigers:");
        for ( Reiziger reiziger : reizigerDao.findAll()) {
            System.out.println("reiziger: [reiziger Id: " + reiziger.getReizigerId()+ ", Naam : " + reiziger.getVoorletters() + "." + reiziger.getAchternaam()
                    + ", Geboortedatum: "+ reiziger.getGeboortedatum() + " ]");
        }

        // Haal reiziger met de achternaam
        System.out.println("Achternaam van Niek: ");

        reizigerDao.findByAchternaam("Rijn");

        // Update gegevens van reiziger
        reiziger1.setVoorletters("L");
        reiziger1.setTussenvoegsel(null);
        reiziger1.setAchternaam("YOUNG");
        reiziger1.setGeboortedatum(luuk);
        reizigerDao.update(reiziger1);


        System.out.println("\nAlle reizigers:");
        for ( Reiziger reiziger : reizigerDao.findAll()) {
            System.out.println("reiziger: [reiziger Id: " + reiziger.getReizigerId()+ ", Naam : " + reiziger.getVoorletters() + "." + reiziger.getAchternaam()
                    + ", Geboortedatum: "+ reiziger.getGeboortedatum() + " ]");
        }

        // Delete reiziger
        System.out.println("\nReiziger verwijderen:");
        reizigerDao.delete(reiziger1);
        System.out.println("\nReiziger verwijderen:");
        reizigerDao.delete(reiziger2);
        System.out.println("\nReiziger verwijderen:");
        reizigerDao.delete(reiziger3);
        System.out.println("\nReiziger verwijderen:");
        reizigerDao.delete(reiziger4);

        System.out.println("\nAlle reizigers:");
        for ( Reiziger reiziger : reizigerDao.findAll()) {
            System.out.println("reiziger: [reiziger Id: " + reiziger.getReizigerId()+ ", Naam : " + reiziger.getVoorletters() + "." + reiziger.getAchternaam()
                    + ", Geboortedatum: "+ reiziger.getGeboortedatum() + " ]");
        }

    }
}
