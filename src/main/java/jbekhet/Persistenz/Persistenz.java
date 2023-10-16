package jbekhet.Persistenz;

import jbekhet.Model.WortTrainer;

/**
 * Dieses Interface enhtält die Methoden speichern und Laden und wird für die verwendung eines Strategy-Patterns
 * @author (Josef Bekhet)
 */

public interface Persistenz  {

    public void speichern(WortTrainer wortTrainer) ;

    public WortTrainer laden();

}
