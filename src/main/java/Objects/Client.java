package Objects;

import java.time.LocalDate;

public class Client  {
    int id;
    String dni;
    String nom;
    LocalDate dataNaix;
    String telefon;
    String email;

    public Client() {
    }

    public Client( String dni, String nom, LocalDate dataNaix, String telefon, String email) {
        this.dni = dni;
        this.nom = nom;
        this.dataNaix = dataNaix;
        this.telefon = telefon;
        this.email = email;
    }
    public Client(int id, String dni, String nom, LocalDate dataNaix, String telefon, String email) {
       this.id=id;
        this.dni = dni;
        this.nom = nom;
        this.dataNaix = dataNaix;
        this.telefon = telefon;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDataNaix() {
        return dataNaix;
    }

    public void setDataNaix(LocalDate dataNaix) {
        this.dataNaix = dataNaix;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
