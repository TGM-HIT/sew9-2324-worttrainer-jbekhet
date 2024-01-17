package jbekhet.Model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class WortEintrag {

    private String wort;
    private String url;

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

    public boolean checkURLselber(String url) {
        if (url == null) {
            throw new NullPointerException("Die URL ist leer");
        }

        if ((!url.startsWith("https://")) && (!url.startsWith("http://"))) {
            throw new IllegalArgumentException("Es muss mit https:// oder mit http:// angefangen werden");
        }

        if (url.length() <= 7) {
            throw new IndexOutOfBoundsException("Es wurde eine zu kurze URL angegeben");
        }

        List<Integer> punkteanzahl = new LinkedList<>();
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '.') {
                punkteanzahl.add(i);
            }
        }

        if (punkteanzahl.size() < 2) {
            throw new IndexOutOfBoundsException("Es sind keine oder zu wenige Verzeichnise vorhanden");
        }

        for (int i = 0; i < punkteanzahl.size() - 1; i++) {
            String text = url.substring(punkteanzahl.get(i), punkteanzahl.get(i + 1));
            for (int o = 0; o < text.length(); o++) {
                char zeichen = text.charAt(o);
                if (!(Character.isLetter(zeichen) || zeichen == '.')) {
                    throw new IllegalArgumentException("Es dürfen keine Sonderzeichen verwendet werden");
                }
            }
        }
        return true;
    }

    public String getWort() {
        return this.wort;
    }

    public void setWort(String wort) {
        if (wort.length() >= 2) {
            this.wort = wort;
        } else {
            throw new IllegalArgumentException("Wort muss mindestens aus zwei Zeichen bestehen");
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (this.checkURL(url)) {
            this.url = url;
        }
    }

    @Override
    public String toString() {
        return this.wort + " , " + this.url;
    }
}
