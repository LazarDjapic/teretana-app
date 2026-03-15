package org.teretana.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.teretana.model.Clan;

import java.util.List;

@Dependent
public class ClanService {

    @Inject
    private EntityManager em;

    @Transactional
    public Clan createClan(Clan clan){
        return em.merge(clan);
    }

    @Transactional
    public List<Clan> getAllClanovi(){
        return em.createNamedQuery(Clan.GET_ALL_CLANOVI, Clan.class)
                .getResultList();
    }
}