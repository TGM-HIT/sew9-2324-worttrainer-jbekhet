package jbekhet.Controller;

import jbekhet.GrafischeOberflaeche.TrainerFrame;
import jbekhet.GrafischeOberflaeche.TrainerGUI;
import jbekhet.GrafischeOberflaeche.TrainerPanel;
import jbekhet.Model.WortListe;
import jbekhet.Model.WortTrainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class TrainerController {


    public static void main(String[] args) {
        WortListe wortliste = new WortListe();
        WortTrainer worttrainer  = new WortTrainer(wortliste);
        TrainerGUI trainerGUI = new TrainerGUI(wortliste,worttrainer);


        try {
            trainerGUI.start();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }






}
