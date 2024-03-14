package ex1;
public class Copiator extends Produs{
    private int pagini;
    private String format;

    public Copiator(String denumire, int nr_inventar, float pret, String state, String zona_mag, int pagini, String format) {
        super(denumire, nr_inventar, pret, state, zona_mag);
        this.pagini = pagini;
        this.format = format;
    }

    public int getPagini() {
        return pagini;
    }

    public void setPagini(int pagini) {
        this.pagini = pagini;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString(){
        return this.getDenumire() + " " + this.getNr_inventar() + " " + this.getPret() + " " + this.getState() + " " + this.getZona_mag() + " " + this.getPagini() + " " + this.getFormat();
     }
}
