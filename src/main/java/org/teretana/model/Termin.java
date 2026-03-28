package org.teretana.model;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name = Termin.GET_TERMINI_BY_PROGRAM, query = "Select t from Termin t where t.programTreninga.id = :id")
public class Termin {

    public static final String GET_TERMINI_BY_PROGRAM = "GetTerminiByProgram";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "termin_seq")
    @SequenceGenerator(name = "termin_seq", sequenceName = "termin_seq", allocationSize = 1)
    private Long id;

    private String datum;
    private String vrijeme;

    // Druga @OneToOne relacija (Vlasnik veze - Uslov 1 iz domacega)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id")
    private Sala sala;

    // @ManyToOne relacija (Uslov 2 iz domacega - FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id")
    private ProgramTreninga programTreninga;

    public Termin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public ProgramTreninga getProgramTreninga() {
        return programTreninga;
    }

    public void setProgramTreninga(ProgramTreninga programTreninga) {
        this.programTreninga = programTreninga;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Termin termin)) return false;
        return Objects.equals(id, termin.id) && Objects.equals(datum, termin.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum);
    }

    @Override
    public String toString() {
        return "Termin{" +
                "id=" + id +
                ", datum='" + datum + '\'' +
                ", vrijeme='" + vrijeme + '\'' +
                '}';
    }
}