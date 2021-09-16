package MendelsLand;

public class Muster implements Merkmal{
    private String muster;

    public Muster(String muster) {
        this.muster = muster;
    }

    @Override
    public String getMerkmal() {
        return muster;
    }
}
