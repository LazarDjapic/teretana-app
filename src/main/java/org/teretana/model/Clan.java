package org.teretana.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.NamedQuery;

import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(
        name = Clan.GET_ALL_CLANOVI,
        query = "SELECT c FROM Clan c"
)
public class Clan {

    public static final String GET_ALL_CLANOVI = "Clan.getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private String datumUclanjenja;

    // zakomentarisano dok ne radimo relacije
    // private Kartica kartica;
    // private List<Clanarina> clanarine;
    // private List<ProgramTreninga> programi;

    public Clan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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

    public String getDatumUclanjenja() {
        return datumUclanjenja;
    }

    public void setDatumUclanjenja(String datumUclanjenja) {
        this.datumUclanjenja = datumUclanjenja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clan clan = (Clan) o;
        return Objects.equals(id, clan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Clan{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}