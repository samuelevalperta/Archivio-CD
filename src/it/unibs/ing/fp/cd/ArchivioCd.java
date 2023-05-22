package it.unibs.ing.fp.cd;

import it.unibs.fp.mylib.NumeriCasuali;

import java.util.ArrayList;

/**
 * @author samuelevalperta
 *
 */
public class ArchivioCd {
	
	private static final int MIN_INDEX = 0;
	private static final String INTRO_VISUALIZZA_ARCHIVIO = "Ecco il tuo archivio\n";
	
	/**
	 * rappresenta la lista dei CD dell'archivio
	 */
	private ArrayList<Cd> listaCd;

	public ArchivioCd() {
		this.listaCd = new ArrayList<>();
	}

	/**
	 * Costruttore che permette la creazione di un archivio con una lista di CD
	 * @param listaCd Lista dei CD
	 */
	public ArchivioCd(ArrayList<Cd> listaCd) {
		this.listaCd = listaCd;
	}

	/**
	 * @return Ritorna la lista dei CD
	 */
	public ArrayList<Cd> getListaCd() {
		return listaCd;
	}

	/**
	 * @param listaCd Imposta la lista dei CD
	 */
	public void setListaCd(ArrayList<Cd> listaCd) {
		this.listaCd = listaCd;
	}
	
	/**
	 * Metodo per aggiungere un CD alla lista
	 * @param cd CD da aggiungere
	 */
	public void aggiungiCd(Cd cd) {
		listaCd.add(cd);
	}
	
	/**
	 * Metodo per rimuovere un CD dalla lista
	 * @param cd CD da rimuovere
	 */
	public void eliminaCd(Cd cd) {
		listaCd.remove(cd);
	}
	
	/**
	 * Metodo per rimuovere un CD dalla lista in base al titolo
	 * @param titolo Titolo del CD da rimuovere
	 */
	public void eliminaCd(String titolo) {
		for (Cd cd : listaCd) {
			if (titolo.equals(cd.getTitolo())) {
				listaCd.remove(cd);
			}
		}
	}
	
	
	/**
	 * Metodo per cercare se un CD e' presente nell'archivio
	 * @param titolo Titolo del cd da cercare
	 * @return True se il CD e' presente
	 */
	public boolean contiene(String titolo) {
		for (Cd cd : listaCd) {
			if (titolo.equals(cd.getTitolo())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo per trovare l'indice di un CD nell'archivio
	 * @param titolo Titolo dl CD da cercare
	 * @return L'indice del CD
	 */
	public Cd trovaCd(String titolo) {
		for (Cd cd : listaCd) {
			if (titolo.equals(cd.getTitolo())) {
				return cd;
			}
		}
		return null; 
	}
	
	/**
	 * Metodo per controllare se ci sono CD nell'archivio
	 * @return Ritorna true se l'archivio non ha CD
	 */
	public boolean isEmpty() {
		return listaCd.isEmpty();
	}
	
	/**
	 * Metodo per conoscere il numero di CD presenti nell'archivio
	 * @return Ritorna il numero di CD presente nell'archivio
	 */
	public int getNumeroCd() {
		return listaCd.size();
	}

	/**
	 * Metodo per estrarre casualmente un CD dall'archivio
	 * @return Ritorna il CD estratto
	 */
	public Cd cdCasuale() {
		int max = listaCd.size() - 1;
		int index = NumeriCasuali.estraiIntero(MIN_INDEX, max);
		return listaCd.get(index);
	}
	
	/**
	 * @return Una stringa formattata contente tutte le informazioni dell'archivio
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(INTRO_VISUALIZZA_ARCHIVIO);
		for (Cd cd : listaCd) {
			buffer.append(String.format("%s\n", cd.toString()));
		}
		return buffer.toString();
	}

}
