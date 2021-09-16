package MendelsLand;

public class Schmetterling {
    private Muster muster;
    private Farbe farbe;
    private Form form;

    public Schmetterling(Muster muster, Farbe farbe, Form form) {
        this.muster = muster;
        this.farbe = farbe;
        this.form = form;
    }

    public Muster getMuster() {
        return muster;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public Form getForm() {
        return form;
    }
}
