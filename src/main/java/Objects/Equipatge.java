package Objects;

public class Equipatge {
    int id;
    String nom;
    Double pes;

    public Equipatge(int id, String nom, Double pes) {
        this.id = id;
        this.nom = nom;
        this.pes = pes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPes() {
        return pes;
    }

    public void setPes(Double pes) {
        this.pes = pes;
    }
}
