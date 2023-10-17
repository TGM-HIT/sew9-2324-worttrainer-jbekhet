import jbekhet.Model.WortEintrag;
import jbekhet.Model.WortListe;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WortListe Tests")
public class TestWortListe {

    private WortListe wortListe;

    @BeforeEach
    public void setUp() {
        wortListe = new WortListe();
    }

    @Test
    @DisplayName("Test Add WortEintrag")
    public void testAddWortEintrag() {
        WortEintrag wortEintrag = new WortEintrag("Test", "https://www.test.com");
        assertTrue(wortListe.addWortEintrag(wortEintrag));
        assertEquals(wortEintrag, wortListe.ausgabe(5));
    }

    @Test
    @DisplayName("Test Add WortEintrag With Strings")
    public void testAddWortEintragWithStrings() {
        assertTrue(wortListe.addWortEintrag("Test1", "https://www.test1.com"));
        assertTrue(wortListe.addWortEintrag("Test2", "https://www.test2.com"));
        assertTrue(wortListe.addWortEintrag("Test1", "https://www.test1.com"));
    }

    @Test
    @DisplayName("Test Ausgabe")
    public void testAusgabe() {
        WortEintrag wortEintrag = wortListe.ausgabe(0);
        assertEquals("Hund", wortEintrag.getWort());
    }

    @Test
    @DisplayName("Test Invalid Ausgabe")
    public void testInvalidAusgabe() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            wortListe.ausgabe(-1); // Negative index
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            wortListe.ausgabe(10); // Index exceeds list size
        });
    }

    @Test
    @DisplayName("Test Geloescht")
    public void testGeloescht() {
        WortEintrag wortEintrag = wortListe.ausgabe(0);
        assertTrue(wortListe.geloescht(wortEintrag));
        assertFalse(wortListe.geloescht(wortEintrag)); // Should return false for already deleted item
    }

    @Test
    @DisplayName("Test ToString")
    public void testToString() {
        String expected = "1. Hund , https://www.hunde-kausnacks.de/magazin/wp-content/uploads/2022/02/kleine-hunderassen-hunde-kausnack-660x330.jpg \n" +
                "2. Affe , https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0rjci0PqO-nPOPX_8wSA4PJVwQfRKKpfnZ1rfrJPvwQ&s \n" +
                "3. Java , https://www.heise.de/imgs/18/2/4/3/3/5/8/1/Bildschirmfoto_2018-05-30_um_08-6aae3c7af906438d.png \n" +
                "4. TGM , https://files.structurae.net/files/photos/2565/tgm/dsc8341.jpg \n" +
                "5. Wasser , https://www.helmholtz.de/assets/helmholtz_gemeinschaft/_processed_/1/e/csm_shutterstock_793184827_Peter_Bocklandt_1920x_ed266c0350.jpg \n";
        assertEquals(expected, wortListe.toString());
    }

    @Test
    @DisplayName("Test Leange")
    public void testLeange() {
        assertEquals(5, wortListe.leange());
    }
}
