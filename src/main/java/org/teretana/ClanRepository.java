package org.teretana;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.teretana.model.Clan;

@ApplicationScoped
public class ClanRepository implements PanacheRepository<Clan> {

}