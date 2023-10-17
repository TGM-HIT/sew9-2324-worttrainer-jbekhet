import jbekhet.Model.WortEintrag;
import jbekhet.Model.WortListe;
import jbekhet.Model.WortTrainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WortTrainer Tests")
public class TestWortTrainer {

    private WortListe wortListe;
    private WortTrainer wortTrainer;

    @BeforeEach
    public void setUp() {
        wortListe = new WortListe();
        wortTrainer = new WortTrainer(wortListe);
    }

    @Test
    @DisplayName("Test Zufälliger Eintrag")
    public void testZufaelligerEintrag() {
        WortEintrag wortEintrag = wortTrainer.zufealligerEintrag();
        assertNotNull(wortEintrag);
        assertTrue(wortTrainer.getVorkommendeWoerter().contains(String.valueOf(wortTrainer.getDerIndex())));
    }

    @Test
    @DisplayName("Test Aktueller Eintrag")
    public void testAktuellerEintrag() {
        WortEintrag wortEintrag = wortTrainer.zufealligerEintrag();
        int index = wortTrainer.getDerIndex();
        WortEintrag aktueller = wortTrainer.aktuellerEintrag(index);
        assertEquals(wortEintrag, aktueller);
    }

    @Test
    @DisplayName("Test Abgefragt")
    public void testAbgefragt() {
        assertFalse(wortTrainer.abgefragt(0)); // Should return false for the first call
        assertTrue(wortTrainer.abgefragt(0)); // Should return true for the second call
    }

    @Test
    @DisplayName("Test Check")
    public void testCheck() {
        WortEintrag wortEintrag = wortTrainer.zufealligerEintrag();
        String correctWord = wortEintrag.getWort();
        assertTrue(wortTrainer.check(correctWord));
        assertEquals(1, wortTrainer.getRichtige());

        String incorrectWord = "IncorrectWord";
        assertFalse(wortTrainer.check(incorrectWord));
        assertEquals(1, wortTrainer.getFalsche());
    }

    @Test
    @DisplayName("Test Check Ignore Case")
    public void testCheckIgnoreCase() {
        WortEintrag wortEintrag = wortTrainer.zufealligerEintrag();
        String correctWord = wortEintrag.getWort();
        String mixedCaseWord = correctWord.substring(0, 1).toUpperCase() + correctWord.substring(1).toLowerCase();
        assertTrue(wortTrainer.checkIgnoreCase(mixedCaseWord));
        assertEquals(1, wortTrainer.getRichtige());
    }

    @Test
    @DisplayName("Test Get Statistik")
    public void testGetStatistik() {
        wortTrainer.setRichtige(3);
        wortTrainer.setFalsche(2);
        wortTrainer.setAnzahlAbgefragterWoerter(5);
        assertEquals("\n Richtig: 3\n Falsch: 2\n Abgefragt: 5\n Insgesamt: " + wortTrainer.leange(), wortTrainer.getStatistik());
    }

    @Test
    @DisplayName("Test Add WortListe")
    public void testAddWortListe() {
        WortListe neueListe = new WortListe();
        neueListe.addWortEintrag("Test", "https://www.test.com");
        wortTrainer.addWortListe(neueListe);
        assertEquals(11, wortTrainer.leange());
    }
}
