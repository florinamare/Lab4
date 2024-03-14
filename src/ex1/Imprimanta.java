package ex1;

public class Imprimanta extends Produs{
    private int ppm, p_car;
    private String m_tiparire, dpi;

    public Imprimanta(String denumire, int nr_inventar, float pret, String state, String zona_mag, int ppm, int p_car, String m_tiparire, String dpi) {
        super(denumire, nr_inventar, pret, state, zona_mag);
        this.ppm = ppm;
        this.p_car = p_car;
        this.m_tiparire = m_tiparire;
        this.dpi = dpi;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public int getP_car() {
        return p_car;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public String getM_tiparire() {
        return m_tiparire;
    }

    public void setM_tiparire(String m_tiparire) {
        this.m_tiparire = m_tiparire;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    @Override
    public String toString(){
        return this.getDenumire() + " " + this.getNr_inventar() + " " + this.getPret() + " " + this.getState() + " " + this.getZona_mag() + " " + this.getPpm() + " " + this.getP_car() + " " + this.getM_tiparire() + " " + this.getDpi();
    }
}
