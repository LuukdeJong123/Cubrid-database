package cubrid;

import java.sql.Date;

public class CU_Chipkaart {
	private int kaartnummer;
	private Date geldigtot;
	private int klasse;
	private double saldo;
	private int reizigerID;
	
	public CU_Chipkaart() {}
	
	public CU_Chipkaart(int kaartnummer, Date geldigtot, int klasse, double saldo) {
		this.kaartnummer = kaartnummer;
		this.geldigtot = geldigtot;
		this.klasse = klasse;
		this.saldo = saldo;
	}
	
	public int getKaartnummer() {
		return kaartnummer;
	}
	
	public Date getGeldigtot() {
		return geldigtot;
	}
	
	public int getKlasse() {
		return klasse;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public int getReizigerId() {
		return reizigerID;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}
	
	public void setGeldigTot(Date geldigtot) {
		this.geldigtot = geldigtot;
	}
	
	public void setReizigerId(int reizigerID) {
		this.reizigerID = reizigerID;
	}
	
}
