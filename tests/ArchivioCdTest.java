import it.unibs.ing.fp.cd.ArchivioCd;
import it.unibs.ing.fp.cd.Brano;
import it.unibs.ing.fp.cd.Cd;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

/**
 * @author samuelevalperta
 *
 */
public class ArchivioCdTest {
	@Test
	public void testAggiuntaCd() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals(2, archivio.getNumeroCd());
	}
	
	@Test
	public void testRicercaTitoloPresente() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertTrue(archivio.contiene("Anime salve"));
	}
	
	@Test
	public void testRicercaTitoloNonPresente() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertFalse(archivio.contiene("La buona novella"));
	}
	
	@Test
	public void testEliminazioneCdPerTitolo() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals(2, archivio.getNumeroCd());
		archivio.eliminaCd("Anime salve");
		assertEquals(1, archivio.getNumeroCd());
		assertFalse(archivio.contiene("Anime salve"));
	}
	
	@Test
	public void testToString() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		final Vector<Brano> listaBrani = new Vector<Brano>();
		listaBrani.add(new Brano("Dolcenera", 4, 57));
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De Andrè", listaBrani));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals("Ecco il tuo archivio\nTitolo: Anime salve, Autore: Fabrizio De Andrè, Lista dei brani: Dolcenera [04:57] \nTitolo: Storia di un impiegato, Autore: Fabrizio De Andrè, Lista dei brani: \n", archivio.toString());
	}
}
