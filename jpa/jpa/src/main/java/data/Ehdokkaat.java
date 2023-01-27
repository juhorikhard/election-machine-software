package data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ehdokkaat database table.
 * 
 */
@Entity
@NamedQuery(name="Ehdokkaat.findAll", query="SELECT e FROM Ehdokkaat e")
public class Ehdokkaat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EHDOKAS_ID")
	private int ehdokasId;

	private String etunimi;
	
	private String sukunimi;
	
	private String ammatti;
	
	private int ika;

	private String kotipaikkakunta;

	@Column(name="MIKSI_EDUSKUNTAAN")
	private String miksiEduskuntaan;

	@Column(name="MITA_ASIOITA_HALUAT_EDISTAA")
	private String mitaAsioitaHaluatEdistaa;

	private String puolue;
	
	

	public Ehdokkaat() {
	}

	public int getEhdokasId() {
		return this.ehdokasId;
	}

	public void setEhdokasId(int ehdokasId) {
		this.ehdokasId = ehdokasId;
	}
	
	public void setEhdokasId(String ehdokasId) {
		try {
			this.ehdokasId = Integer.parseInt(ehdokasId);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}

	public String getAmmatti() {
		return this.ammatti;
	}

	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}

	public String getEtunimi() {
		return this.etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public int getIka() {
		return this.ika;
	}

	public void setIka(int ika) {
		this.ika = ika;
	}
	
	public void setIka(String ika) {
		try {
			this.ika = Integer.parseInt(ika);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
	}

	public String getKotipaikkakunta() {
		return this.kotipaikkakunta;
	}

	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}

	public String getMiksiEduskuntaan() {
		return this.miksiEduskuntaan;
	}

	public void setMiksiEduskuntaan(String miksiEduskuntaan) {
		this.miksiEduskuntaan = miksiEduskuntaan;
	}

	public String getMitaAsioitaHaluatEdistaa() {
		return this.mitaAsioitaHaluatEdistaa;
	}

	public void setMitaAsioitaHaluatEdistaa(String mitaAsioitaHaluatEdistaa) {
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
	}

	public String getPuolue() {
		return this.puolue;
	}

	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}

	public String getSukunimi() {
		return this.sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	
	public Ehdokkaat(int ehdokasId, String ammatti, String etunimi, int ika, String kotipaikkakunta,
			String miksiEduskuntaan, String mitaAsioitaHaluatEdistaa, String puolue, String sukunimi) {
		this.ehdokasId = ehdokasId;
		this.ammatti = ammatti;
		this.etunimi = etunimi;
		this.ika = ika;
		this.kotipaikkakunta = kotipaikkakunta;
		this.miksiEduskuntaan = miksiEduskuntaan;
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
		this.puolue = puolue;
		this.sukunimi = sukunimi;
	}
	
	public Ehdokkaat(String ehdokasId, String ammatti, String etunimi, int ika, String kotipaikkakunta,
			String miksiEduskuntaan, String mitaAsioitaHaluatEdistaa, String puolue, String sukunimi) {
		this.setEhdokasId(ehdokasId);
		this.ammatti = ammatti;
		this.etunimi = etunimi;
		this.ika = ika;
		this.kotipaikkakunta = kotipaikkakunta;
		this.miksiEduskuntaan = miksiEduskuntaan;
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
		this.puolue = puolue;
		this.sukunimi = sukunimi;
	}
	
	public Ehdokkaat(int ehdokasId, String ammatti, String etunimi, String ika, String kotipaikkakunta,
			String miksiEduskuntaan, String mitaAsioitaHaluatEdistaa, String puolue, String sukunimi) {
		this.ehdokasId = ehdokasId;
		this.ammatti = ammatti;
		this.etunimi = etunimi;
		this.setIka(ika);
		this.kotipaikkakunta = kotipaikkakunta;
		this.miksiEduskuntaan = miksiEduskuntaan;
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
		this.puolue = puolue;
		this.sukunimi = sukunimi;
	}
	
	public Ehdokkaat(String ehdokasId, String ammatti, String etunimi, String ika, String kotipaikkakunta,
			String miksiEduskuntaan, String mitaAsioitaHaluatEdistaa, String puolue, String sukunimi) {
		this.setEhdokasId(ehdokasId);
		this.ammatti = ammatti;
		this.etunimi = etunimi;
		this.setIka(ika);
		this.kotipaikkakunta = kotipaikkakunta;
		this.miksiEduskuntaan = miksiEduskuntaan;
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
		this.puolue = puolue;
		this.sukunimi = sukunimi;
	}

	public Ehdokkaat(String ammatti, String etunimi, int ika, String kotipaikkakunta, String miksiEduskuntaan,
			String mitaAsioitaHaluatEdistaa, String puolue, String sukunimi) {
		super();
		this.ammatti = ammatti;
		this.etunimi = etunimi;
		this.ika = ika;
		this.kotipaikkakunta = kotipaikkakunta;
		this.miksiEduskuntaan = miksiEduskuntaan;
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
		this.puolue = puolue;
		this.sukunimi = sukunimi;
	}
	
	public Ehdokkaat(String ammatti, String etunimi, String ika, String kotipaikkakunta, String miksiEduskuntaan,
			String mitaAsioitaHaluatEdistaa, String puolue, String sukunimi) {
		this.ammatti = ammatti;
		this.etunimi = etunimi;
		this.setIka(ika);
		this.kotipaikkakunta = kotipaikkakunta;
		this.miksiEduskuntaan = miksiEduskuntaan;
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
		this.puolue = puolue;
		this.sukunimi = sukunimi;
	}
	
	public String toString() {
		return this.ehdokasId+": "+this.ammatti+" / "+this.etunimi+" / "+this.ika+": "+this.kotipaikkakunta+": "+this.miksiEduskuntaan+": "+this.mitaAsioitaHaluatEdistaa +": "+this.sukunimi;     
	}

}