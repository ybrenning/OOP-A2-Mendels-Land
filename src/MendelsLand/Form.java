package MendelsLand;

public class Form implements  Merkmal{
    private String form;

    public Form(String form) {
        this.form = form;
    }

    @Override
    public String getMerkmal() {
        return form;
    }
}
