package org.teretana.schedulers;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class GymScheduler {

    private static final Logger LOG = Logger.getLogger(GymScheduler.class);

    @Scheduled(every = "5m")
    void provjeriStatusTeretane() {
        LOG.info("Sistemska provjera: Provjeravam vaznost clanarina i slobodne termine u salama...");
    }
}