package org.teretana.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.teretana.exception.ClanException;
import org.teretana.model.ProgramTreninga;
import org.teretana.model.Trener;
import org.teretana.model.Termin;

import java.util.List;

@Dependent
public class TrenerService {

    @Inject
    private EntityManager em;

    @Transactional
    public Trener createTrener(Trener trener) throws ClanException {
        if (trener == null) {
            throw new ClanException("Trener nije proslijedjen");
        }
        
        // Povezivanje kolekcije programa sa trenerom
        if (trener.getProgrami() != null) {
            for (ProgramTreninga p : trener.getProgrami()) {
                p.setTrener(trener);
            }
        }
        return em.merge(trener);
    }

    public List<Trener> getAllTreneri() {
        return em.createNamedQuery(Trener.GET_ALL_TRENERI, Trener.class).getResultList();
    }

    public List<Termin> getTerminiByProgramId(Long id) {
        // Dobavljanje kolekcije termina za program (Tacka 5 domaceg)
        return em.createNamedQuery(Termin.GET_TERMINI_BY_PROGRAM, Termin.class)
                 .setParameter("id", id)
                 .getResultList();
    }
}
