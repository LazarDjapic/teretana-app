package org.teretana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = Clan.GET_ALL_CLANOVI, query = "Select c.id, c.ime, c.prezime from Clan c")
@NamedQuery(name = Clan.GET_CLAN_BY_IME, query = "Select c from Clan c where c.ime = :imeC")
public class Clan {

    public static final String GET_ALL_CLANOVI = "GetAllClanovi";
    public static final String GET_CLAN_BY_IME = "GetClanByIme";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clan_seq")
    @SequenceGenerator(name = "clan_seq", sequenceName = "clan_seq", allocationSize = 1)
    private Long id;

    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private String datumUclanjenja;

    public Clan() {
    }

    public Clan(Long id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    // Prvi @OneToOne relacija (Uslov 1 iz domacega)
    @OneToOne(mappedBy = "clan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Kartica kartica;

    // @OneToMany relacija (Uslov 2 iz domacega - FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id")
    private List<Clanarina> clanarine = new ArrayList<>();

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

    public Kartica getKartica() {
        return kartica;
    }

    public void setKartica(Kartica kartica) {
        this.kartica = kartica;
    }

    public List<Clanarina> getClanarine() {
        return clanarine;
    }

    public void setClanarine(List<Clanarina> clanarine) {
        this.clanarine = clanarine;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Clan clan)) return false;
        return Objects.equals(id, clan.id) && Objects.equals(ime, clan.ime) && Objects.equals(prezime, clan.prezime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime);
    }

    @Override
    public String toString() {
        return "Clan{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                '}';
    }
}