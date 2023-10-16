package jbekhet.Controller;


import jbekhet.GrafischeOberflaeche.TrainerGUI;
import jbekhet.Model.WortListe;
import jbekhet.Model.WortTrainer;
import jbekhet.Persistenz.Persistenz;
import jbekhet.Persistenz.SpeichernUndLaden;

import java.net.MalformedURLException;

public class TrainerController {


    public static void main(String[] args) {


        Persistenz persistenz = new SpeichernUndLaden();
        WortTrainer trainer = persistenz.laden();


        WortListe wortliste = new WortListe();
        TrainerGUI trainerGUI = new TrainerGUI(wortliste,trainer);


        try {
            trainerGUI.start();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }






}
