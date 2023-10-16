package jbekhet.GrafischeOberflaeche;

import javax.swing.*;

import jbekhet.Model.WortListe;
import jbekhet.Model.WortTrainer;
import jbekhet.Model.WortEintrag;
import jbekhet.Persistenz.Persistenz;
import jbekhet.Persistenz.SpeichernUndLaden;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TrainerGUI {

    private WortListe wortliste;
    private WortTrainer worttrainer;


    public TrainerGUI(WortListe wortliste, WortTrainer controller) {
        this.wortliste = wortliste;
        this.worttrainer= new WortTrainer(wortliste);

    }

    public void start() throws MalformedURLException {

        boolean schleife=true;

        while (schleife) {
            WortEintrag we = worttrainer.zufealligerEintrag();
            URL url = new URL(we.getUrl());

            ImageIcon bildIcon = new ImageIcon(url);


            JLabel label = new JLabel();
            label.setSize(new Dimension(20, 10));
            label.setIcon(bildIcon);

            JLabel bildLabel = new JLabel(bildIcon);




            String antwort = JOptionPane.showInputDialog(null,bildLabel,"GIb ein Wort ein",JOptionPane.QUESTION_MESSAGE);

            if (antwort != null) {



/*
            if (worttrainer.check(antwort)) {
                JOptionPane.showMessageDialog(null, "Richtig!\nBis jetzt hast du " +
                        worttrainer.getRichtige() + " von " +  wortliste.leange() + " richtig.");
            }


 */
                if (worttrainer.check(antwort)) {
                    JOptionPane.showMessageDialog(null, "Richtig!\n Richtig: " +
                            worttrainer.getRichtige() + "\n Falsch: " + worttrainer.getFalsche() + "\n Abgefragt: " + worttrainer.getAnzahlAbgefragterWoerter() +
                            "\n Insgesamt: " + wortliste.leange());
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch!\nRichtig: " +
                            worttrainer.getRichtige() + "\n Falsch: " + worttrainer.getFalsche() + "\n Abgefragt: " + worttrainer.getAnzahlAbgefragterWoerter() +
                            "\n Insgesamt: " + wortliste.leange());
                }
            } else {
                schleife = false;
                Persistenz persistenz = new SpeichernUndLaden();
                persistenz.speichern(worttrainer);
            }
        }
    }







}
