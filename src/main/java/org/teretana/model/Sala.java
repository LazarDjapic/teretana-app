package org.teretana.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name = Sala.GET_ALL_SALE, query = "Select s.id, s.naziv from Sala s")
public class Sala {

    public static final String GET_ALL_SALE = "GetAllSale";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala_seq")
    @SequenceGenerator(name = "sala_seq", sequenceName = "sala_seq", allocationSize = 1)
    private Long id;

    private String naziv;

    // Druga @OneToOne relacija 
    @OneToOne(mappedBy = "sala", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Termin termin;

    public Sala() {
    }

    public Sala(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
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

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sala sala)) return false;
        return Objects.equals(id, sala.id) && Objects.equals(naziv, sala.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv);
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}