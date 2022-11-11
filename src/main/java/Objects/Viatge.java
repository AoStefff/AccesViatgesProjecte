package Objects;

import java.time.LocalDateTime;

public class Viatge {
    int idViatge;
    int idOrigen;
    int idDesti;
    LocalDateTime dataHora;
    int idTransport;
    boolean habilitat;

    public Viatge() {
    }

    public Viatge(int idViatge, int idOrigen, int idDesti, LocalDateTime dataHora, int idTransport, boolean habilitat) {
        this.idViatge = idViatge;
        this.idOrigen = idOrigen;
        this.idDesti = idDesti;
        this.dataHora = dataHora;
        this.idTransport = idTransport;
        this.habilitat = habilitat;
    }

    public int getIdViatge() {
        return idViatge;
    }

    public void setIdViatge(int idViatge) {
        this.idViatge = idViatge;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public int getIdDesti() {
        return idDesti;
    }

    public void setIdDesti(int idDesti) {
        this.idDesti = idDesti;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(int idTransport) {
        this.idTransport = idTransport;
    }

    public boolean isHabilitat() {
        return habilitat;
    }

    public void setHabilitat(boolean habilitat) {
        this.habilitat = habilitat;
    }
}
