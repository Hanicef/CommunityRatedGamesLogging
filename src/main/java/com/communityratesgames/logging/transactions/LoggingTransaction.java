package com.communityratesgames.logging.transactions;

import com.communityratesgames.logging.domain.Logging;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Default
public class LoggingTransaction implements LoggingDataMethods {

    @PersistenceContext(unitName = "communityratesgameslogging")
    private EntityManager em;

    @Override
    public Logging addNewLog(Logging log) {
        em.persist(log);
        em.flush();
        return log;
    }
}
