package it.unibs.ing.fp.cd;
import it.unibs.fp.mylib.NumeriCasuali;
import java.util.Vector;

/**
 * @author samuelevalperta
 *
 */
public class Cd {
	
	private static final String DESCRIZIONE_CD_SHORT = "Titolo: %s, Autore: %s";

	private static final String MESS_DOPPIONE = "Attenzione: non si puo' inserire un titolo gia' esistente!";

	private static final String DESCRIZIONE_CD = "Titolo: %s, Autore: %s, Lista dei brani: ";

	private static final int MIN_INDEX = 0;
	
	/**
	 * Rappresenta il titolo del CD
	 */
	private String titolo;
	/**
	 * Rappresenta l'autore del CD
	 */
	private String autore;
	/**
	 * Lista di brani che compongono il CD
	 */
	private Vector<Brano> listaBrani;

	/**
	 * @return Ritorna il titolo del CD
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo Imposta il titolo del CD
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return Ritorna l'autore del CD
	 */
	public String getAutore() {
		return autore;
	}

	/**
	 * @param autore Imposta l'autore del CD
	 */
	public void setAutore(String autore) {
		this.autore = autore;
	}

	/**
	 * @return Ritorna una lista contenente i brani del CD
	 */
	public Vector<Brano> getListaBrani() {
		return listaBrani;
	}

	/**
	 * @param listaBrani Imposta la lista di brani del CD
	 */
	public void setListaBrani(Vector<Brano> listaBrani) {
		this.listaBrani = listaBrani;
	}

	/**
	 * Costruttore che permette di impostare titolo ed autore del CD
	 * @param titolo Titolo del cd
	 * @param autore Autore del cd
	 */
	public Cd(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
		this.listaBrani = new Vector<>();
	}
	
	/**
	 * Costruttore che permette di impostare titolo, autore e brani del CD
	 * @param titolo Titolo del CD
	 * @param autore Autore del CD
	 * @param listaBrani Lista dei brani del CD
	 */
	public Cd(String titolo, String autore, Vector<Brano> listaBrani) {
		this.titolo = titolo;
		this.autore = autore;
		this.listaBrani = listaBrani;
	}

	/**
	 * Metodo che permette di aggiungere un brano ad un CD, purchè non sia gia presente un brano con lo stesso nome
	 * @param branoDaAggiungere Brano da aggiungere
	 */
	public void aggiungiBrano(Brano branoDaAggiungere) {
		for (Brano brano : listaBrani) {
			if (brano.getTitolo().equals(branoDaAggiungere.getTitolo())) {
				System.out.println(MESS_DOPPIONE);
				return;
			}
		}
		listaBrani.add(branoDaAggiungere);
	}

	/**
	 * Metodo per controllare che sia presente un brano all'interno del CD
	 * @param titolo Titolo del brano che si vuole controllare
	 * @return Ritorna true se il brano è presente
	 */
	public boolean haTitolo(String titolo) {
		return this.titolo.equals(titolo);
	}

	/**
	 * Metodo per controllare che il CD sia vuoto
	 * @return  Ritorna true se il CD non ha brani salvati al suo interno
	 */
	public boolean isEmpty() {
		return listaBrani.isEmpty();
	}
	
	/**
	 * Metodo per estrarre un brano in modo casuale tra quelli salvati sul CD
	 * @return Ritorna il brano selezionato
	 */
	public Brano branoCasuale() {
		int max = listaBrani.size() - 1;
		int index = NumeriCasuali.estraiIntero(MIN_INDEX, max);
		return listaBrani.get(index);
	}
	
	/**
	 * Metodo per avere una breve descrizione del CD
	 * @return Ritorna una stringa contente le informazioni
	 */
	public String getDescrizione() {
		return String.format(DESCRIZIONE_CD_SHORT, titolo, autore);
	}
	
	/**
	 * @return Una stringa formattata contente tutte le informazioni del CD
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format(DESCRIZIONE_CD, titolo, autore));
		for (Brano brano : listaBrani) {
			buffer.append(brano.toString());
		}
		return buffer.toString();
	}
	
}
