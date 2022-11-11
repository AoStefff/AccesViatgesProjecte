package Objects;

public class Bitllet {
    int id;
    double preu;
    String tipusSeient;
    int idViatge;

    public Bitllet() {
    }

    public Bitllet(int id, double preu, String tipusSeient, int idViatge) {
        this.id = id;
        this.preu = preu;
        this.tipusSeient = tipusSeient;
        this.idViatge = idViatge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getTipusSeient() {
        return tipusSeient;
    }

    public void setTipusSeient(String tipusSeient) {
        this.tipusSeient = tipusSeient;
    }

    public int getIdViatge() {
        return idViatge;
    }

    public void setIdViatge(int idViatge) {
        this.idViatge = idViatge;
    }
}
