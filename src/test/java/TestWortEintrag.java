import jbekhet.Model.WortEintrag;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestWortEintrag {

    @DisplayName("Url vom Internet einfügen")
    @Test
    void test1() {
        WortEintrag we = new WortEintrag("Hund","https://www.planet-wissen.de/natur/haustiere/hunde/introhundewolfgjpg104~_v-HintergrundL.jpg");


        assertEquals(true, we.checkURL(we.getUrl()));
        assertEquals(true,we.checkURLselber(we.getUrl()));


    }
    @DisplayName("Eigene URl einsetzen")
    @Test
    void test2() {


        WortEintrag we = new WortEintrag("Hallo","https://hallo.com");

        assertEquals(true,we.checkURL(we.getUrl()));

        IndexOutOfBoundsException ioobe = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            we.checkURLselber(we.getUrl());

        });



    }
    @DisplayName("Verschiederne UseCases")
    @Test
    void test3() {

        WortEintrag we = new WortEintrag("hello","HalloWelt");

        assertEquals(false,we.checkURL(we.getUrl()));
        assertEquals(false,we.checkURLselber(we.getUrl()));


        we.setWort("https://");
        assertEquals(false,we.checkURL(we.getUrl()));
        assertEquals(false,we.checkURLselber(we.getUrl()));

        we.setWort("https://ich.bin.nicht.da!!!?");
        assertEquals(false,we.checkURL(we.getUrl()));
        assertEquals(false,we.checkURLselber(we.getUrl()));

    }

    
}
