package ex1;

import java.io.Serializable;

public class Produs implements Serializable {
    private String denumire;
    private int nr_inventar;
    private float pret;
    private String state;
    private String zona_mag;

    public Produs(String denumire, int nr_inventar, float pret, String state, String zona_mag) {
        this.denumire = denumire;
        this.nr_inventar = nr_inventar;
        this.pret = pret;
        this.state = state;
        this.zona_mag = zona_mag;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNr_inventar() {
        return nr_inventar;
    }

    public void setNr_inventar(int nr_inventar) {
        this.nr_inventar = nr_inventar;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public void setZona_mag(String zona_mag) {
        this.zona_mag = zona_mag;
    }

    @Override
    public String toString(){
        return this.getDenumire() + " " + this.getNr_inventar() + " " + this.getPret() + " " + this.getState() + " " + this.getState();
    }
}
