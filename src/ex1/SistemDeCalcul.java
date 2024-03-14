package ex1;

public class SistemDeCalcul extends Produs{
    private String tip_mon;
    private float viteza_procesor;
    private String sistem_de_operare;
    private int c_hdd;

    public SistemDeCalcul(String denumire, int nr_inventar, float pret, String state, String zona_mag, String tip_mon, float viteza_procesor, String sistem_de_operare, int c_hdd) {
        super(denumire, nr_inventar, pret, state, zona_mag);
        this.tip_mon = tip_mon;
        this.viteza_procesor = viteza_procesor;
        this.sistem_de_operare = sistem_de_operare;
        this.c_hdd = c_hdd;
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public float getViteza_procesor() {
        return viteza_procesor;
    }

    public void setViteza_procesor(float viteza_procesor) {
        this.viteza_procesor = viteza_procesor;
    }

    public String getSistem_de_operare() {
        return sistem_de_operare;
    }

    public void setSistem_de_operare(String sistem_de_operare) {
        this.sistem_de_operare = sistem_de_operare;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    @Override
    public String toString(){
        return this.getDenumire() + " " + this.getNr_inventar() + " " + this.getPret() + " " + this.getState() + " " + this.getZona_mag() + " " + this.getTip_mon() + " " + this.getViteza_procesor() + " " + this.getC_hdd() + " " + this.getSistem_de_operare();
    }
}
