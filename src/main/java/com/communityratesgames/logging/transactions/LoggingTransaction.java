package com.communityratesgames.logging.transactions;

import com.communityratesgames.logging.domain.Logging;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    @Override
    public List<Logging> showAllLogs() {
        Query q = em.createNativeQuery("SELECT * FROM logging", Logging.class);
        List<Logging> logs = q.getResultList();
        return logs;
    }
}
