package MendelsLand;

public class Farbe implements Merkmal {
    private String farbe;

    public Farbe(String farbe) {
        this.farbe = farbe;
    }

    @Override
    public String getMerkmal() {
        return farbe;
    }
}
