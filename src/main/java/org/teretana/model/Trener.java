package org.teretana.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = Trener.GET_ALL_TRENERI, query = "Select t.id, t.ime, t.prezime from Trener t")
@NamedQuery(name = Trener.GET_TRENER_BY_NAME, query = "Select t from Trener t where t.ime = :imeT")
public class Trener {

    public static final String GET_ALL_TRENERI = "GetAllTreneri";
    public static final String GET_TRENER_BY_NAME = "GetTrenerByName";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trener_seq")
    @SequenceGenerator(name = "trener_seq", sequenceName = "trener_seq", allocationSize = 1)
    private Long id;

    private String ime;
    private String prezime;
    private String specijalizacija;
    private String email;
    private String telefon;

    // Druga @OneToMany relacija (FetchType.LAZY)
    @OneToMany(mappedBy = "trener", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProgramTreninga> programi = new ArrayList<>();

    public Trener() {
    }

    public Trener(Long id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
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

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<ProgramTreninga> getProgrami() {
        return programi;
    }

    public void setProgrami(List<ProgramTreninga> programi) {
        this.programi = programi;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Trener trener)) return false;
        return Objects.equals(id, trener.id) && Objects.equals(ime, trener.ime) && Objects.equals(prezime, trener.prezime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime);
    }

    @Override
    public String toString() {
        return "Trener{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                '}';
    }
}