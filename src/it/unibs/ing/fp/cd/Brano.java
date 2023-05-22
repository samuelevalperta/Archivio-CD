package it.unibs.ing.fp.cd;

/**
 * @author samuelevalperta
 *
 */
public class Brano {
	
	private static final int SECONDI_PER_MINUTO = 60;
	private static final String DESCRIZIONE_BRANO = "%s [%02d:%02d] ";
	
	/**
	 * Rappresente il titolo del brano
	 */
	private String titolo;
	/**
	 * Rappresenta la durata totale del brano in secondi
	 */
	private int durataTotaleSecondi;
	/**
	 * Rappresenta la quantita' di minuti di durata del brano 
	 */
	private int minuti;
	/**
	 * Rappresenta la quantita' di secondi oltre ai minuti di durata del brano
	 */
	private int secondi;
	
	/**
	 * Costruttore che permette l'inizializzazione di un brano nel formato di durata minuti:secondi
	 * @param titolo Titolo del brano
	 * @param minuti Quantita' di minuti
	 * @param secondi Quantita' di secondi
	 */
	public Brano(String titolo, int minuti, int secondi) {
		this.titolo = titolo;
		this.minuti = minuti;
		this.secondi = secondi;
		this.durataTotaleSecondi = minuti * SECONDI_PER_MINUTO + secondi;
	}
	
	/**
	 * Costruttore che permette l'inizializzazione di un brano con durata rappresentata in secondi totali
	 * @param titolo Titolo del brano
	 * @param durataTotaleSecondi Quantita' di secondi totali
	 */
	public Brano(String titolo, int durataTotaleSecondi) {
		this.titolo = titolo;
		this.durataTotaleSecondi = durataTotaleSecondi;
		this.minuti = durataTotaleSecondi / 60;
		this.secondi = durataTotaleSecondi % 60;
	}

	/**
	 * @return Ritorna titolo del brano
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo Imposta titolo del brano
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return Ritorna durata totale in secondi
	 */
	public int getDurataTotaleSecondi() {
		return durataTotaleSecondi;
	}

	/**
	 * @param durataTotaleSecondi durata totale in secondi
	 */
	public void setDurataTotaleSecondi(int durataTotaleSecondi) {
		this.durataTotaleSecondi = durataTotaleSecondi;
	}

	/**
	 * @return Ritorna Ritorna minuti dove durata=minuti*60+secondi
	 */
	public int getMinuti() {
		return minuti;
	}

	/**
	 * @param minuti Imposta minuti nel formato durata=minuti*60+secondi
	 */
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}

	/**
	 * @return Ritorna secondi dove durata=minuti*60+secondi
	 */
	public int getSecondi() {
		return secondi;
	}

	/**
	 * @param secondi Imposta secondi dove durata=minuti*60+secondi
	 */
	public void setSecondi(int secondi) {
		this.secondi = secondi;
	}
	
	/**
	 * @return Una stringa formattata contente tutte le informazioni di un brano
	 */
	public String toString() {
		return String.format(DESCRIZIONE_BRANO, titolo, minuti, secondi);
	}
	
}
