package MendelsLand;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instanziiere Eltern
        Schmetterling mutter = new Schmetterling(new Muster("uni"), new Farbe("rot"), new Form("gerade"));
        Schmetterling vater = new Schmetterling(new Muster("uni"), new Farbe("grün"), new Form("gekrümmt"));
        Brut brut = new Brut(mutter, vater);
        brut.erzeugeBrut();

        List<Schmetterling> kinder = brut.getBrut();
        List<Schmetterling> kinderRot = brut.kinderMitMerkmal(new Farbe("rot"));

        // Gibt eine leere Liste zurueck, da zwei verschiedene Farben angegeben werden
        List<Schmetterling> kinderRotGruen = brut.kinderMitMerkmal(new Farbe("rot"), new Farbe("grün"));

        // Alle Schmetterlinge in dieser Liste haben die gleichen Merkmale
        List<Schmetterling> kinderRotGerade = brut.kinderMitMerkmal(new Farbe("rot"), new Form("gerade"));


        System.out.println(brut.toString(kinder));
        System.out.println(brut.toString(kinderRot));

        System.out.println("Anteil mit Merkmal rot: " + String.format("%.2f", brut.statistik(kinderRot) * 100) + "%");
        System.out.println("Anteil mit Merkmalen rot + gerade: " + String.format("%.2f", brut.statistik(kinderRotGerade) * 100) + "%");
    }
}
