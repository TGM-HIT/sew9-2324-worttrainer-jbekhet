package jbekhet.Model;


/**
 * Die Klasse WortTrainer verwendet die Methode WortListe um verschiedernste Vergleiche und Ausgaben zu machen.
 * @author (Josef Bekhet)

 */

public class WortTrainer {
    private WortListe liste;
    private WortEintrag eintrag;

    private int richig;
    private int falsch;
    private String vorkommendeWoerter;

    private int anzahlAbgefragterWoerter;
    private int derIndex;

    /**
     * Leerer Konstruktor der Klasse WortTrainer
     */
    public WortTrainer(WortListe liste) {
        this.liste = liste;
        vorkommendeWoerter="";

    }


    /**
     * Diese Methode gibt eine zufälligen WortEintrag in der Liste aus.
     * Des Weiteren wird die Aktuelle position zu dem zufälligen Index .
     * @return WortEintrag
     */

    public WortEintrag zufealligerEintrag() {
        int sc = (int) (Math.random() * liste.leange());
        this.derIndex = sc;
        return liste.ausgabe(sc);

    }
    /**
     * Diese Methode gibt eine einen eingegebenen WortEintrag in der Liste aus.
     * Des Weiteren wird die Aktuelle position zum eingegebenen Index .
     * @param index Hier wird eine Zahl eingegeben
     * @return WortEintrag
     * @throws IndexOutOfBoundsException wenn ein falsche Index eingegeben wurde
     */

    public WortEintrag aktuellerEintrag(int index) throws IndexOutOfBoundsException {
        IndexOutOfBoundsException ioobe;

        if (index <= 0 || index > liste.leange()) {
            ioobe = new IndexOutOfBoundsException("Es wurde eine falsche Index eingegeben");
        }
        this.derIndex = index;
        return eintrag = liste.ausgabe(index);

    }

    /**
     * Diese Methode vergleicht, ob ein neues Wort abgefragt wird oder nicht
     * @param index Hier wird eine Zahl eingegeben
     * @throws IndexOutOfBoundsException wenn ein falsche Index eingegeben wurde
     */

    public void abgefragt(int index) {
        boolean hinzugefuegt = false;
        boolean nichtVorhanden;
        int gleich = 0;
        char schneiden = 'd';
        int vergleich;
        if (!this.vorkommendeWoerter.equals("")) {
            for (int i = 0; i < vorkommendeWoerter.length(); i++) {
                schneiden = vorkommendeWoerter.charAt(i);
                vergleich = Integer.parseInt(String.valueOf(schneiden));
                if (index == vergleich) {
                    gleich++;
                }
            }
        }
        if (gleich == 0) {

            anzahlAbgefragterWoerter++;

        }
        vorkommendeWoerter = vorkommendeWoerter + index;

    }
    /**
     * Diese Methode vergleicht, ob das eingegebene Wort mit dem schon vorhandenem Wort exakt übereinstimmt
     * @param wort Hier wird ein Wort eingegeben
     * @return true or false
     */
    public boolean check(String wort) {

        this.abgefragt(this.getDerIndex());



        if (!eintrag.getWort().equals(wort)) {
            this.addFalsche();
            return false;

        }
        this.addRichtige();
        return true;
    }
    /**
     * Diese Methode vergleicht, ob das eingegebene Wort mit dem schon vorhandenem Wort  übereinstimmt, jedoch werden hier alle Buchstaben in Kleinbuchtaben umgewandelt
     * @param wort Hier wird ein Wort eingegeben
     * @return true or false
     */
    public boolean checkIgnoreCase(String wort) {
        this.abgefragt(this.getDerIndex());

        wort = wort.toLowerCase();
        String vorhandenesWort = eintrag.getWort();
        vorhandenesWort = vorhandenesWort.toLowerCase();

        if (!vorhandenesWort.equals(wort)) {

            this.addFalsche();
            return false;
        }
        this.addRichtige();
        return true;

    }

    /**
     * Diese Methode fügt eine WortListe hinzu
     * @param liste Hier wird ein WortListe eingegeben
     */
    public void addWortListe(WortListe liste) {
        for (int i = 0; i < liste.leange(); i++) {
            this.liste.addWortEintrag(liste.ausgabe(i));
        }
    }
    /**
     * Getter-Methode des Attributs richtig
     * @return  int
     */
    public int getRichtige() {
        return this.richig;
    }
    /**
     * Getter-Methode des Attributs falsch
     * @return  int
     */
    public int getFalsche() {
        return this.falsch;
    }
    /**
     * Zum Attribut richtig wird um 1 dazu addiert
     */
    public void addRichtige() {
        this.richig++;
    }
    /**
     * Zum Attribut falsch wird um 1 dazu addiert
     */
    public void addFalsche() {
        this.falsch++;
    }
    /**
     * Getter-Methode des Attributs vorkommendeWoerter
     * @return  String
     */
    public String getVorkommendeWoerter() {
        return this.vorkommendeWoerter;
    }
    /**
     * Getter-Methode des Attributs anzahlAbgefragterWoerter
     * @return  int
     */
    public int getAnzahlAbgefragterWoerter() {
        return this.anzahlAbgefragterWoerter;
    }
    /**
     * Getter-Methode des Attributs derIndex
     * @return  int
     */
    public int getDerIndex() {
        return this.derIndex;
    }

    /**
     * Getter-Methode für die Länge der List
     * @return  int
     */
    public int leange() {
        return liste.leange();
    }

    /**
     * Setter-Methode des Attributs richtig
     */
    public void setRichtige(int richtig) {
        this.richig=richtig;
    }

    /**
     * Setter-Methode des Attributs falsch
     */
    public void setFalsche(int falsch){
        this.falsch=falsch;
    }

    /**
     * Setter-Methode des Attributs anzahlAbgefragterWoerter
     */
    public void setAnzahlAbgefragterWoerter(int anzahlAbgefragterWoerter) {
         this.anzahlAbgefragterWoerter=anzahlAbgefragterWoerter;
    }

    /**
     * Setter-Methode des Attributs derIndex
     */
    public void setDerIndex (int index) {
        this.derIndex= index;
    }



}
