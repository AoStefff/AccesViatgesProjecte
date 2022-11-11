package Objects;

public class Transport {
    int id;
    int sNormal;
    int sPreferent;
    String nom;

    public Transport() {
    }

    public Transport(int idTransport, int sNormal, int sPreferent, String nom) {
        this.id = idTransport;
        this.sNormal = sNormal;
        this.sPreferent = sPreferent;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getsNormal() {
        return sNormal;
    }

    public void setsNormal(int sNormal) {
        this.sNormal = sNormal;
    }

    public int getsPreferent() {
        return sPreferent;
    }

    public void setsPreferent(int sPreferent) {
        this.sPreferent = sPreferent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}


