package jbekhet.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse WortListe fasst WortEinträge zusammen.
 * Des Weiteren können Einträge auch hinzugefügt oder gelöscht werden.
 * @author (Josef Bekhet)
 */

public class WortListe {

    private List<WortEintrag> liste;

    /**
     * Konstruktor der Klasse WortListe
     */
    public WortListe() {

        this.liste=new ArrayList<>();


    }
    /**
     * Diese Methode fügt ein neues WortEintrag in die WortListe hinzu
     * @param worteintrag Hier wird ein WortEintrag eingegeben
     */
    public boolean addWortEintrag(WortEintrag worteintrag) {
        // weiß nicht wie ich auf Gültigkeit überprüfe

        if (!this.liste.contains(worteintrag)) {
            this.liste.add(worteintrag);
            return true;
        }
        return false;


    }



    /**
     * Diese Methode fügt ein neues WortEintrag in die WortListe hinzu
     * @param  wort Hier wird ein Wort eingegeben
     * @param  url Hier wird eine URL eingegeben
     */
    public boolean addWortEintrag(String wort, String url) {
        // weiß nicht wie ich auf Gültigkeit überprüfe

        WortEintrag worteintrag = new WortEintrag(wort,url);
        if (!this.liste.contains(worteintrag)) {
            this.liste.add(worteintrag);
            return true;
        }
        return false;


    }



    /**
     * Diese Methode gibt den Wert eines bestimmten WortEintrags in der Liste aus
     * @param index Hier wird eine Zahl eingegeben
     * @return WortEintrag
     * @throws IndexOutOfBoundsException wenn nichts im WortEintrag drinnen steht
     * @throws IndexOutOfBoundsException wenn eine zu kleine oder große Zahl angegeben wurde
     */
    public WortEintrag ausgabe(int index) throws IndexOutOfBoundsException {
        IndexOutOfBoundsException ioobe;

        if (index <= -1 || index >= liste.size()) {
            if (index == -1) {
                ioobe = new IndexOutOfBoundsException(" Es steht nichts im WortEintrag drinnen");
                throw ioobe;
            }
            ioobe = new IndexOutOfBoundsException(" Es wurde eine zu kleine oder zu große Zahl angegeben");
            throw ioobe;
        }
        return this.liste.get(index);

    }


    /**
     * Diese Methode löscht einen WortEintrag aus der Liste
     * @param wort Hier wird das WortEintrag eingegeben, welches gelöscht werden soll
     * @return true, false
     */
    public boolean geloescht(WortEintrag wort) {

        for (int i = 0; i < liste.size(); i++) {
            if (liste.contains(wort)) {
                liste.remove(wort);
                return true;
            }
        }
        return false;
    }
    /**
     * Methode toString wird überschieben und gibt die WortListe aus
     * @return WortListe
     */

    @Override
    public String toString() {
        String ausgabe;
        ausgabe = "";
        int index;
        for (int i = 0; i < liste.size(); i++) {
            index = i + 1;
            ausgabe = ausgabe + "" + index + ". " + liste.get(i) + " \n";
        }
        return ausgabe;
    }
    /**
     * Methode gibt die Länge der WortListe zurück
     * @return zahl
     */
    public int leange() {
        return this.liste.size();
    }


    public List<WortEintrag> getListe() {
        return this.liste;
    }


}

