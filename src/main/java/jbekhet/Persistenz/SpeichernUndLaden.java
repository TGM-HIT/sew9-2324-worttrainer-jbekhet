package jbekhet.Persistenz;

import jbekhet.Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class SpeichernUndLaden implements Persistenz {



        private static class speicherWortEintrag implements Serializable  {
            public String wort;
            public String url;

        }

        private static class speicherWortListe implements Serializable {
          public speicherWortEintrag[] swe;
        }

        private static class speicherWortTrainer implements Serializable {
            public speicherWortListe swl;
            public int richtig;
            public int falsch;

            public int gesamt;
            public int abgefragt;
        }






    @Override
    public void speichern(String filename, WortTrainer wortTrainer) throws IOException {
        ObjectMapper om = new ObjectMapper();
        speicherWortTrainer swt= new speicherWortTrainer();
        swt.richtig=wortTrainer.getRichtige();
        swt.falsch= wortTrainer.getFalsche();
        swt.abgefragt=wortTrainer.getAnzahlAbgefragterWoerter();
        swt.gesamt= wortTrainer.leange();

       WortEintrag[] wortEintrag = wortTrainer.getalleEinträge();
       swt.= new speicherWortEintrag[wortEintrag.length];



    }

    @Override
    public void speichern() throws IOException {

    }

    @Override
    public WortTrainer laden() throws IOException {
        return null;
    }

    @Override
    public WortTrainer laden(String filename) throws IOException {
            ObjectMapper om = new ObjectMapper();

            Scanner scanner = new Scanner(new File(filename));
            String readJSON = scanner.next();
            System.out.println(readJSON);
            speicherWortTrainer swt= om.readValue(readJSON, speicherWortTrainer.class);

           speicherWortEintrag[] swe= swt.swl.swe;

            WortListe wl = new WortListe();
            for (int i=0; i<swe.length;i++) {
              wl.addWortEintrag(swe[i].wort,swe[i].url);
            }
            WortTrainer wt = new WortTrainer(wl);












        return null;
    }
}