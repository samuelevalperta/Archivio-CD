package it.unibs.ing.fp.cd;

import it.unibs.fp.mylib.MyMenu;

/**
 * @author samuelevalperta
 *
 */
public class CdMain {
	
	private static final String[] VOCI_MENU = {"Inserisci nuovo CD", "Rimuovi CD dall'archivio", "Visualizza CD", "Visualizza intera collezione", "Selezione casuale"};
	private static final String TITOLO = "Elenco Funzionalita'";
	private static final String ERRORE_FUNZIONE = "La funzione non rientra tra quelle disponibili!";
	private static final String BENVENUTO = "\nProgramma per la gestione dell'Archivio CD\n\n";
	private static final String MESS_FINALE = "Fine programma";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyMenu menu = new MyMenu(TITOLO, VOCI_MENU);
		ArchivioCd archivioCd = new ArchivioCd();
		boolean finito = false;
		
		System.out.println(BENVENUTO);
		
		do {
			
			int scelta = menu.scegli();

			switch(scelta) {
				case 1:
					/**
					 * L'utente inserisce un nuovo CD nella sua collezione
					 */
					IOUtil.inserisciNuovoCd(archivioCd);
					break;
				case 2:
					/**
					 * L'utente rimuove un nuovo CD dalla sua collezione
					 */
					IOUtil.rimuoviCd(archivioCd);
					break;
				case 3:
					/**
					 * L'utente visualizza le informazioni di un solo CD della sua collezione
					 */
					IOUtil.visualizzaCd(archivioCd);
					break;
				case 4:
					/**
					 * L'utente visualizza le informazioni di tutti i CD della sua collezione
					 */
					System.out.println(archivioCd.toString());
					break;
				case 5:
					/**
					 * Viene selezionato un brano casuale tra tutti quelli nella collezione
					 */
					IOUtil.selezionaBranoCasuale(archivioCd);
					break;
				case 0:
					finito = true;
					break;
				default:
					System.out.println(ERRORE_FUNZIONE);
					break;
			}
			
		} while (!finito);
		
		System.out.println(MESS_FINALE);
	}
	
}
