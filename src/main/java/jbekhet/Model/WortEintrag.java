package jbekhet.Model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Die Klasse WortEintrag erstellt ein WortEintrag Objekt der aus einem Namen und einer Url besteht .
 * Des Weiteren wird die URL und der Name auf Sinnhaftigkeit überprüft.
 * @author (Josef Bekhet)
 */

public class WortEintrag {

    private String wort;

    private String url;



    /**
     * Konstruktor der Klasse WortEintrag
     * @param wort Hier wird ein Name eingegeben
     * @param url Hier wird eine URL eingegeben
     */
    public WortEintrag(String wort, String url) {
        this.setWort(wort);
        this.setUrl(url);
    }



    public boolean checkURL(String url) {

        try {
            new URL(url);
            return true;
        } catch (MalformedURLException mue) {
            return false;
        }
    }


    /**
     * Diese Methode kontrolliert ob eine gültige URL eingegeben wurde
     * @param url Hier wird eine URL eingegeben
     * @return true oder false
     * @throws IllegalArgumentException wenn kein richtiges Protokoll angegeben wurde
     * @throws IndexOutOfBoundsException wenn die URL zu gering ist
     * @throws IndexOutOfBoundsException wenn zu wenige Verzechnise angegeben wurden
     * @throws IllegalArgumentException wenn Sonderzeichen verwendet werden
     */


    public  boolean checkURLselber(String url) throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {

        IllegalArgumentException iae;
        IndexOutOfBoundsException ioobe;
        NullPointerException npe;
        List<Integer> punkteanzahl = new LinkedList<>();

        if (url==null) {
            npe = new NullPointerException("Die URL ist leer");
            throw npe;
        }

        //falls die URL nicht mit https:// oder http:// beginnt
        if ((!url.startsWith("https://")) && (!url.startsWith("http://"))) {
            iae = new IllegalArgumentException("Es muss mit https:// oder mit http:// angefangen werden");
            throw iae;
        }

        // falls die url nur http:// ist
        if (url.length() <= 7) {
            ioobe = new IndexOutOfBoundsException("Es wurdee eine zu kurze URL angegeben");
            throw ioobe;
        }

        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '.') {
                punkteanzahl.add(i);
            }
        }
        // falls zuwenige Verzeichnise angegeben wurden
        if (punkteanzahl.size() <= 2) {
            ioobe = new IndexOutOfBoundsException("Es sind keine bzw zu wenige Verzeichnise vorhanden");
            throw ioobe;
        }

        // ermittelt wie viele Verzeichnise das sind und schaut drauf das der Verzeichnis aus Buchstaben besteht.
        for (int i = 0; i < punkteanzahl.size(); i++) {

            String text = "";
            if (i == 0) {
                text = url.substring(i, punkteanzahl.get(i));

            } else {
                text = url.substring(i, punkteanzahl.get(i + 1));
            }

            text = url.substring(punkteanzahl.get(i), punkteanzahl.get(i + 1));
            for (int o = 0; i < text.length(); i++) {
                char zeichen = text.charAt(o);
                if (!(zeichen >= 'a' && zeichen <= 'z') && !(zeichen >= 'A' && zeichen <= 'Z') && zeichen != '.') {
                    iae = new IllegalArgumentException("Es dürfen keine Sonderzeichen verwendet werden");
                    throw iae;
                }


            }
        }
        return true;


    }


    /**
     * Getter-Methode des Attributs wort
     * @return Wert des wort-Attributs
     */
    public String getWort() {
        return this.wort;
    }
    /**
     * Setter-Methode des Attributs wort
     * @param wort Hier wird ein Wort eingegeben
     * @throws IllegalArgumentException wenn Name weniger als 2 Zeichen beinhaltet
     */
    public void setWort(String wort) throws IllegalArgumentException {
        IllegalArgumentException iae;
        if (wort.length() >= 1) {
            this.wort = wort;
        } else {
            iae = new IllegalArgumentException("Wort muss mindestens aus zwei Zeichen bestehen");
            throw iae;
        }
    }
    /**
     * Getter-Methode des Attributs url
     * @return Wert des wort-Attributs
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter-Methode des Attributs url
     * @param url Hier wird eine URL eingegeben
     */
    public void setUrl(String url) {
        if (this.checkURL(url) == true) {
            this.url = url;
        }

    }
    /**
     * Methode toString wird überschieben und gibt den Namen und die URL in einer Zeile aus
     * @return Ausgabe des WortEintrags
     */
    @Override
    public String toString() {
        return "" + this.wort + " , " + this.url + "";
    }

}
