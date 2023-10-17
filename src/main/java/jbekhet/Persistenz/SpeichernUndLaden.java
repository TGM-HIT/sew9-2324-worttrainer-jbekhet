package jbekhet.Persistenz;

import jbekhet.Model.WortListe;
import jbekhet.Model.WortTrainer;
import org.json.JSONObject;


import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Die Klasse SpeichernUndLaden erbt vom Interface Persistenz und speichert bzw ladet die Statistiken in/von  einem .json file..
 * @author (Josef Bekhet)
 */


public class SpeichernUndLaden implements Persistenz {

    /**
     * Diese Methode speichert die Statistiken eines WortTrainers in ein json file
     * @param trainer Hier wird ein WortTrainer übergeben.
     */

    @Override
    public void speichern(WortTrainer trainer) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("richtige", trainer.getRichtige());
        jsonObject.put("falsche", trainer.getFalsche());
        jsonObject.put("abgefragt",trainer.getAnzahlAbgefragterWoerter());
        jsonObject.put("aktuellerIndex",trainer.getDerIndex());

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("WortTrainer", trainer);

        try {
            File jsonFile = new File("save.json");
            FileWriter writer = new FileWriter(jsonFile);
            writer.write(jsonObject.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    /**
     * Diese Methode ladet die Statistiken von der WortTrainer session in den WortTrainer.*/
    @Override
    public WortTrainer laden() {
        JSONObject jsonObject;
        WortListe liste = new WortListe();
        WortTrainer trainer = new WortTrainer(liste);

        try {
            jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get(new File("save.json").toURI()))));
            trainer.setRichtige(jsonObject.getInt("richtige"));
            trainer.setFalsche(jsonObject.getInt("falsche"));
            trainer.setAnzahlAbgefragterWoerter(jsonObject.getInt("abgefragt"));
            trainer.setDerIndex(jsonObject.getInt("aktuellerIndex"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return trainer;
    }


    }