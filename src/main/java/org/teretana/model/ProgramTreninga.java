package org.teretana.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = ProgramTreninga.GET_ALL_PROGRAMI, query = "Select p.id, p.naziv from ProgramTreninga p")
public class ProgramTreninga {

    public static final String GET_ALL_PROGRAMI = "GetAllProgrami";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_seq")
    @SequenceGenerator(name = "program_seq", sequenceName = "program_seq", allocationSize = 1)
    private Long id;

    private String naziv;
    private String opis;
    private String nivoTezine;
    private int trajanjeUMinutama;

    // Druga @ManyToOne relacija (Uslov 2 iz domacega - FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trener_id")
    private Trener trener;

    // Relacija ka terminima (Kolekcija - FetchType.LAZY)
    @OneToMany(mappedBy = "programTreninga", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Termin> termini = new ArrayList<>();

    public ProgramTreninga() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNivoTezine() {
        return nivoTezine;
    }

    public void setNivoTezine(String nivoTezine) {
        this.nivoTezine = nivoTezine;
    }

    public int getTrajanjeUMinutama() {
        return trajanjeUMinutama;
    }

    public void setTrajanjeUMinutama(int trajanjeUMinutama) {
        this.trajanjeUMinutama = trajanjeUMinutama;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProgramTreninga p)) return false;
        return Objects.equals(id, p.id) && Objects.equals(naziv, p.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv);
    }

    @Override
    public String toString() {
        return "ProgramTreninga{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}