package it.unibs.ing.fp.cd;

import it.unibs.fp.mylib.InputDati;

/**
 * @author samuelevalperta
 *
 */
public class IOUtil {
	
	private static final String MESS_BRANO_CASUALE = "%sda %s";
	private static final String CERCA_CD = "Inserisci il titolo del CD >";
	private static final String MESS_NON_TROVATO = "CD richiesto non trovato";
	private static final String MESS_RIMOZIONE = "Confermi la rimozione di questo CD?";
	private static final String MESS_TITOLO = "Inserisci il titolo del CD da inserire > ";
	private static final String MESS_AUTORE = "Inserisci l'autore del CD > ";
	private static final String MESS_TITOLO_BRANO = "Inserisci il titolo del brano > ";
	private static final String MESS_ALTRO_BRANO = "Vuoi inserire un altro brano?";
	private static final String MESS_DURATA_BRANO = "Inserisci la durata del brano in secondi > ";
	private static final String MESS_BRANI = "Inserimento dei brani del CD";
	private static final String MESS_ARCHIVIO_VUOTO = "L'archivio e' vuoto";
	
	/**
	 * Metodo di aggiunta di un nuovo CD all'archivio permettendo all'utente di scegliere i valori iniziali.
	 * Si può scegliere titolo, autore e brani del CD
	 * @param archivioCd archivio alla quale verra' aggiunto il CD
	 */
	public static void inserisciNuovoCd(ArchivioCd archivioCd) {
		
		String titoloCd = InputDati.leggiStringaNonVuota(MESS_TITOLO);
		String autore = InputDati.leggiStringaNonVuota(MESS_AUTORE);
		
		Cd cd = new Cd(titoloCd, autore);
		
		System.out.println(MESS_BRANI);
		
		do {
			
			String titoloBrano = InputDati.leggiStringaNonVuota(MESS_TITOLO_BRANO);
			int durataTotaleSecondi = InputDati.leggiInteroPositivo(MESS_DURATA_BRANO);
			
			cd.aggiungiBrano(new Brano(titoloBrano, durataTotaleSecondi));
			
		} while (InputDati.yesOrNo(MESS_ALTRO_BRANO));
		
		archivioCd.aggiungiCd(cd);
	}
	
	/**
	 * Metodo per rimuovere un CD dato il titolo da un archivio
	 * @param archivioCd archivio dalla quale verra' rimosso il CD
	 */
	public static void rimuoviCd(ArchivioCd archivioCd) {
		
		if (archivioCd.isEmpty()) {
			System.out.println(MESS_ARCHIVIO_VUOTO);
			return;
		}
		
		String titoloCd = InputDati.leggiStringaNonVuota(CERCA_CD);
		
		if (archivioCd.contiene(titoloCd)) {
			if (InputDati.yesOrNo(MESS_RIMOZIONE)) {
				archivioCd.eliminaCd(titoloCd);
				System.out.println();
			}
		} else {
			System.out.println(MESS_NON_TROVATO);
		}
	}
	
	/**
	 * Metodo per stampare tutte le informazioni di un CD scelto da un archivio
	 * @param archivioCd archivio dalla quale si puo' scegliere il CD
	 */
	public static void visualizzaCd(ArchivioCd archivioCd) {
		
		if (archivioCd.isEmpty()) {
			System.out.println(MESS_ARCHIVIO_VUOTO);
			return;
		}
		
		String titoloCd = InputDati.leggiStringaNonVuota(CERCA_CD);
		
		if (archivioCd.contiene(titoloCd)) {
			System.out.println(archivioCd.trovaCd(titoloCd).toString());
		} else {
			System.out.println(MESS_NON_TROVATO);
		}
		
	}
	
	/**
	 * Wrapper al metodo di delezione casuale di un brano tra quelli di un CD
	 * @param archivioCd archivio dalla quale verra' estratto il brano
	 */
	public static void selezionaBranoCasuale(ArchivioCd archivioCd) {
		
		if (archivioCd.isEmpty()) {
			System.out.println(MESS_ARCHIVIO_VUOTO);
			return;
		}
		
		Cd cdEstratto = archivioCd.cdCasuale();
		Brano branoEstratto = cdEstratto.branoCasuale();
		
		System.out.printf((MESS_BRANO_CASUALE) + "%n", branoEstratto.toString(), cdEstratto.getDescrizione());
	}
}
