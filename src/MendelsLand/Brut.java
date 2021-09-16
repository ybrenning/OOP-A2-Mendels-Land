package MendelsLand;

import java.util.ArrayList;
import java.util.List;

public class Brut {
    private Schmetterling mutter;
    private Schmetterling vater;
    private List<Schmetterling> brut;
    private int kinder;

    public Brut(Schmetterling mutter, Schmetterling vater) {
        this.mutter = mutter;
        this.vater = vater;

        kinder = (int) (Math.random() * 1000) + 1000;
        brut = new ArrayList<>();
    }

    public Schmetterling erzeugeNachkomen(Schmetterling mutter, Schmetterling vater) {
        Muster muster = (Muster) waehleMerkmal(mutter.getMuster(), vater.getMuster());
        Farbe farbe = (Farbe) waehleMerkmal(mutter.getFarbe(), vater.getFarbe());
        Form form = (Form) waehleMerkmal(mutter.getForm(), vater.getForm());

        return new Schmetterling(muster, farbe, form);
    }

    public Merkmal waehleMerkmal(Merkmal m1, Merkmal m2) {
        if (Math.random() < 0.5) return m1;
        else return m2;
    }

    public void erzeugeBrut() {
        for (int i = 0; i < kinder; i++) {
            brut.add(i, erzeugeNachkomen(mutter, vater));
        }
    }

    // Vergleicht einzelnes Merkmal
    public List<Schmetterling> kinderMitMerkmal(Merkmal gesuchtesMerkmal) {
        List<Schmetterling> kinderMitMerkmal = new ArrayList<>();
        for (Schmetterling s : brut) {
            if (erkenneMerkmal(s, gesuchtesMerkmal).equals(gesuchtesMerkmal.getMerkmal())) {
                kinderMitMerkmal.add(s);
            }
        }
        return kinderMitMerkmal;
    }

    // Vergleicht zwei Merkmale
    public List<Schmetterling> kinderMitMerkmal(Merkmal gesuchtesMerkmal1, Merkmal gesuchtesMerkmal2) {
        List<Schmetterling> kinderMitMerkmal = new ArrayList<>();

        if (gesuchtesMerkmal1.getClass().equals(gesuchtesMerkmal2.getClass())) {
            System.out.println("Achtung! Merkmale dürfen nicht den gleichen Merkmalstyp haben!");
            return kinderMitMerkmal;
        }
            for (Schmetterling s : brut) {
            // Vergleicht nur einzelnes Merkmal
            if (erkenneMerkmal(s, gesuchtesMerkmal1).equals(gesuchtesMerkmal1.getMerkmal())
                && erkenneMerkmal(s, gesuchtesMerkmal2).equals(gesuchtesMerkmal2.getMerkmal())) {
                kinderMitMerkmal.add(s);
            }
        }
        return kinderMitMerkmal;
    }

    // Vergleicht drei Merkmale
    public List<Schmetterling> kinderMitMerkmal(Merkmal gesuchtesMerkmal1, Merkmal gesuchtesMerkmal2, Merkmal gesuchtesMerkmal3) {
        List<Schmetterling> kinderMitMerkmal = new ArrayList<>();

        if (gesuchtesMerkmal1.getClass().equals(gesuchtesMerkmal2.getClass())
                || gesuchtesMerkmal2.getClass().equals(gesuchtesMerkmal3.getClass())) {
            System.out.println("Achtung! Merkmale dürfen nicht den gleichen Merkmalstyp haben!");
            return kinderMitMerkmal;
        }
        for (Schmetterling s : brut) {
            if (erkenneMerkmal(s, gesuchtesMerkmal1).equals(gesuchtesMerkmal1.getMerkmal())
                    && erkenneMerkmal(s, gesuchtesMerkmal2).equals(gesuchtesMerkmal2.getMerkmal())
                    && erkenneMerkmal(s, gesuchtesMerkmal3).equals(gesuchtesMerkmal3.getMerkmal())) {
                kinderMitMerkmal.add(s);
            }
        }
        return kinderMitMerkmal;
    }

    public String erkenneMerkmal(Schmetterling schmetterling, Merkmal merkmal) {
        if (merkmal instanceof Muster) return schmetterling.getMuster().getMerkmal();
        else if (merkmal instanceof Farbe) return schmetterling.getFarbe().getMerkmal();
        else return schmetterling.getForm().getMerkmal();
    }

    public double statistik(List<Schmetterling> schmetterlingeMitMerkmal) {
        return (double) schmetterlingeMitMerkmal.size() / kinder;
    }

    public String toString(List<Schmetterling> schmetterlinge) {
        StringBuilder sb = new StringBuilder("\n");
        for (Schmetterling s : schmetterlinge) {
            sb.append("Muster: " + s.getMuster().getMerkmal()
            + "\tFarbe: " + s.getFarbe().getMerkmal()
            + "\tForm: " + s.getForm().getMerkmal() + "\n");
        }
        return sb.toString();
    }

    public List<Schmetterling> getBrut() {
        return brut;
    }
}
