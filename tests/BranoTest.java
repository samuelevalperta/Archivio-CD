import it.unibs.ing.fp.cd.Brano;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author samuelevalperta
 *
 */
public class BranoTest {
	private static final String TITOLO = "Il pescatore";
	private static final int MM = 4;
	private static final int SS = 46;

	@Test
	public void testToString() throws Exception {
		Assert.assertEquals("Il pescatore [04:46] ", new Brano(TITOLO, MM, SS).toString());
	}
	
	
}
