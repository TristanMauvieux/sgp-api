package dta.sgp.entite;

import javax.persistence.Embeddable;

@Embeddable
public class Banque {

	private String nomDeBanque;
	private String iban;
	private String bic;

	public String getNomDeBanque() {
		return nomDeBanque;
	}

	public void setNomDeBanque(String nomDeBanque) {
		this.nomDeBanque = nomDeBanque;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

}
